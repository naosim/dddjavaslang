package com.naosim.dddjavaslang.domain.engagement;

import com.naosim.dddjavaslang.domain.account.UserId;
import com.naosim.dddjavaslang.domain.engagement.engagementdate.EngagementEndDate;
import com.naosim.dddjavaslang.domain.engagement.engagementdate.EngagementEndOrderDate;
import com.naosim.dddjavaslang.domain.engagement.engagementdate.EngagementStartCancelOrderDate;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class EngagementCancelStartOrder {
    @Getter
    private final UserId userId;
    @Getter
    private final EngagementStartCancelOrderDate engagementStartCancelOrderDate;
}
