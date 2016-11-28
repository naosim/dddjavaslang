package com.naosim.dddjavaslang.domain.engagement.engagementdate;

import com.naosim.dddjavaslang.domain.engagement.EngagementStatus;
import com.naosim.dddjavaslang.lib.date.CurrentDateTime;
import com.naosim.dddjavaslang.lib.date.DateToStateUtil;
import javaslang.control.Option;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
@AllArgsConstructor
public class EngagementDateSet {
    private final EngagementStartOrderDate engagementStartOrderDate;
    private final Option<EngagementStartCancelOrderDate> engagementStartCancelOrderDate;
    private final EngagementStartDate engagementStartDate;
    private final Option<EngagementEndOrderDate> engagementEndOrderDateOption;
    private final Option<EngagementEndDate> engagementEndDateOption;

    public EngagementStatus createEngagementStatus(
            CurrentDateTime currentDateTime
    ) {
        if(engagementStartCancelOrderDate.isDefined() && engagementStartCancelOrderDate.get().isNotFuture(currentDateTime)) {
            return EngagementStatus.startOrderCanceled;
        }

        int index = DateToStateUtil.getSection(
                currentDateTime,
                engagementStartOrderDate,
                Option.some(engagementStartDate),
                engagementEndOrderDateOption,
                engagementEndDateOption
        );

        return new EngagementStatus[] {
                EngagementStatus.startOrdered,
                EngagementStatus.engaged,
                EngagementStatus.engagedAndEndOrdered,
                EngagementStatus.ended
        }[index];
    }
}
