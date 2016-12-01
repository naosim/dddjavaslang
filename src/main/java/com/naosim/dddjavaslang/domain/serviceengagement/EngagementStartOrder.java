package com.naosim.dddjavaslang.domain.serviceengagement;

import com.naosim.dddjavaslang.domain.account.UserId;
import com.naosim.dddjavaslang.domain.serviceengagement.engagementdate.ServiceEngagementStartDate;
import com.naosim.dddjavaslang.domain.serviceengagement.engagementdate.ServiceEngagementStartOrderDate;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
@AllArgsConstructor
public class EngagementStartOrder {
    @Getter
    private final UserId userId;
    @Getter
    private final ServiceEngagementStartOrderDate engagementStartOrderDate;

    public ServiceEngagementStartDate getEngagementStartDate() {
        // 契約開始日は契約申込日によって決まる
        return ServiceEngagementStartDate.create(engagementStartOrderDate);
    }
}
