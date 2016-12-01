package com.naosim.dddjavaslang.domain.serviceengagement;

import com.naosim.dddjavaslang.domain.account.UserId;
import com.naosim.dddjavaslang.domain.serviceengagement.engagementdate.ServiceEngagementStartCancelOrderDate;
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
    private final ServiceEngagementStartCancelOrderDate serviceEngagementStartCancelOrderDate;
}
