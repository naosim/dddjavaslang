package com.naosim.dddjavaslang.domain.serviceengagement;

import com.naosim.dddjavaslang.domain.account.UserId;
import com.naosim.dddjavaslang.domain.serviceengagement.engagementdate.ServiceEngagementEndCancelOrderDate;
import com.naosim.dddjavaslang.domain.serviceengagement.engagementdate.ServiceEngagementEndDate;
import com.naosim.dddjavaslang.domain.serviceengagement.engagementdate.ServiceEngagementEndOrderDate;
import javaslang.control.Option;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class EngagementEndOrder {
    @Getter
    private final UserId userId;
    @Getter
    private final ServiceEngagementEndOrderDate engagementEndOrderDate;
    @Getter
    private final Option<ServiceEngagementEndCancelOrderDate> ServiceEngagementEndCancelOrderDateOption = Option.none();

    public ServiceEngagementEndDate getEngagementEndDate() {
        return ServiceEngagementEndDate.create(engagementEndOrderDate);
    }
}
