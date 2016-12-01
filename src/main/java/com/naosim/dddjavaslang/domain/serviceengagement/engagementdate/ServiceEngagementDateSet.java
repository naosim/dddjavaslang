package com.naosim.dddjavaslang.domain.serviceengagement.engagementdate;

import com.naosim.dddjavaslang.domain.serviceengagement.ServiceEngagementStatus;
import com.naosim.dddjavaslang.lib.engagementlifesycle.EngagementStatusType;
import com.naosim.dddjavaslang.lib.engagementlifesycle.engagementdate.EngagementEndOrderEventList;
import com.naosim.dddjavaslang.lib.engagementlifesycle.engagementdate.EngagementEventDateSet;
import javaslang.control.Option;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class ServiceEngagementDateSet extends EngagementEventDateSet<
        ServiceEngagementStartOrderDate,
        ServiceEngagementStartCancelOrderDate,
        ServiceEngagementStartDate,
        ServiceEngagementEndOrderDate,
        ServiceEngagementEndCancelOrderDate,
        ServiceEngagementEndDate,
        ServiceEngagementStatus
        > {
    public ServiceEngagementDateSet(
            ServiceEngagementStartOrderDate engagementStartOrderDate,
            Option<ServiceEngagementStartCancelOrderDate> engagementStartCancelOrderDate,
            ServiceEngagementStartDate engagementStartDate,
            EngagementEndOrderEventList<ServiceEngagementEndOrderDate, ServiceEngagementEndCancelOrderDate> engagementEndOrderList,
            Option<ServiceEngagementEndDate> engagementEndDateOption
    ) {
        super(engagementStartOrderDate, engagementStartCancelOrderDate, engagementStartDate, engagementEndOrderList, engagementEndDateOption);
    }

    @Override
    protected ServiceEngagementStatus convertStatus(EngagementStatusType engagementStatusType) {
        return ServiceEngagementStatus.convert(engagementStatusType);
    }
}
