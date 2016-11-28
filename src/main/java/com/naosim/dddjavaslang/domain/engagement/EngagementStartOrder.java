package com.naosim.dddjavaslang.domain.engagement;

import com.naosim.dddjavaslang.domain.account.UserId;
import com.naosim.dddjavaslang.domain.engagement.engagementdate.EngagementStartDate;
import com.naosim.dddjavaslang.domain.engagement.engagementdate.EngagementStartOrderDate;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
@AllArgsConstructor
public class EngagementStartOrder {
    @Getter
    private final UserId userId;
    @Getter
    private final EngagementStartOrderDate engagementStartOrderDate;
    @Getter
    private final EngagementStartDate engagementStartDate;
}
