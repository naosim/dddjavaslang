package com.naosim.dddjavaslang.lib.engagementlifesycle.engagementdate;

import com.naosim.dddjavaslang.lib.date.CurrentDateTime;
import com.naosim.dddjavaslang.lib.date.DateToStateUtil;
import com.naosim.dddjavaslang.lib.engagementlifesycle.EngagementStatus;
import com.naosim.dddjavaslang.lib.engagementlifesycle.EngagementStatusType;
import javaslang.control.Option;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
@AllArgsConstructor
public abstract class EngagementEventDateSet<
        SOD extends EngagementStartOrderDate,
        SCOD extends EngagementStartCancelOrderDate,
        SD extends EngagementStartDate,
        EOD extends EngagementEndOrderDate,
        ECOD extends EngagementEndCancelOrderDate,
        ED extends EngagementEndDate,
        ES extends EngagementStatus
        > {
    private final SOD engagementStartOrderDate;
    private final Option<SCOD> engagementStartCancelOrderDate;
    private final SD engagementStartDate;
    private final EngagementEndOrderEventList<EOD, ECOD> engagementEndOrderList;
    private final Option<ED> engagementEndDateOption;

    public ES createEngagementStatus(
            CurrentDateTime currentDateTime
    ) {
        return convertStatus(_createEngagementStatus(currentDateTime));
    }

    private EngagementStatusType _createEngagementStatus(
            CurrentDateTime currentDateTime
    ) {
        if(engagementStartCancelOrderDate.isDefined() && engagementStartCancelOrderDate.get().isNotFuture(currentDateTime)) {
            return EngagementStatusType.startOrderCanceled;
        }

        int index = DateToStateUtil.getSection(
                currentDateTime,
                engagementStartOrderDate,
                Option.some(engagementStartDate),
                engagementEndOrderList.getLastEngagementEndOrderDate(),
                engagementEndDateOption
        );

        return new EngagementStatusType[] {
                EngagementStatusType.startOrdered,
                EngagementStatusType.engaged,
                EngagementStatusType.engagedAndEndOrdered,
                EngagementStatusType.ended
        }[index];
    }

    public boolean canCancelStart(CurrentDateTime currentDateTime) {
        return EngagementStatusType.startOrdered.equals(_createEngagementStatus(currentDateTime));
    }

    public boolean cannotCancelStart(CurrentDateTime currentDateTime) {
        return !canCancelStart(currentDateTime);
    }

    public boolean canEnd(CurrentDateTime currentDateTime) {
        return EngagementStatusType.engaged.equals(_createEngagementStatus(currentDateTime));
    }

    public boolean cannotEnd(CurrentDateTime currentDateTime) {
        return !canEnd(currentDateTime);
    }

    public boolean canCancelEnd(CurrentDateTime currentDateTime) {
        return EngagementStatusType.engagedAndEndOrdered.equals(_createEngagementStatus(currentDateTime));
    }

    protected abstract ES convertStatus(EngagementStatusType engagementStatusType);
}
