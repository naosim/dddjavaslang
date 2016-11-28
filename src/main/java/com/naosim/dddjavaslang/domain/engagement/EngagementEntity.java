package com.naosim.dddjavaslang.domain.engagement;

import com.naosim.dddjavaslang.domain.account.UserId;
import com.naosim.dddjavaslang.domain.engagement.engagementdate.EngagementDateSet;
import com.naosim.dddjavaslang.lib.date.CurrentDateTime;
import com.naosim.dddjavaslang.lib.valid.InvalidReason;
import javaslang.control.Option;
import javaslang.control.Validation;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
@AllArgsConstructor
public class EngagementEntity {
    @Getter
    private final UserId userId;
    @Getter
    private final EngagementDateSet engagementDateSet;
    @Getter(AccessLevel.PACKAGE)
    private final CurrentDateTime currentDateTime;
    public EngagementStatus getEngagementStatus() {
        return engagementDateSet.createEngagementStatus(currentDateTime);
    }

    public static EngagementEntity createFromStartOrder(EngagementStartOrder startOrder, CurrentDateTime currentDateTime) {
        return new EngagementEntity(
                startOrder.getUserId(),
                new EngagementDateSet(
                        startOrder.getEngagementStartOrderDate(),
                        Option.none(),
                        startOrder.getEngagementStartDate(),
                        Option.none(),
                        Option.none()
                ),
                currentDateTime
        );

    }
}
