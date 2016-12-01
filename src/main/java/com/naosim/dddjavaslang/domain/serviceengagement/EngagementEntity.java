package com.naosim.dddjavaslang.domain.serviceengagement;

import com.naosim.dddjavaslang.domain.account.UserId;
import com.naosim.dddjavaslang.domain.serviceengagement.engagementdate.ServiceEngagementDateSet;
import com.naosim.dddjavaslang.domain.serviceengagement.engagementdate.ServiceEngagementEndCancelOrderDate;
import com.naosim.dddjavaslang.domain.serviceengagement.engagementdate.ServiceEngagementEndDate;
import com.naosim.dddjavaslang.domain.serviceengagement.engagementdate.ServiceEngagementEndOrderDate;
import com.naosim.dddjavaslang.lib.date.CurrentDateTime;
import com.naosim.dddjavaslang.lib.engagementlifesycle.engagementdate.EngagementEndOrderEventList;
import javaslang.Tuple;
import javaslang.Tuple2;
import javaslang.collection.List;
import javaslang.control.Option;
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
    private final ServiceEngagementDateSet serviceEngagementDateSet;
    @Getter(AccessLevel.PACKAGE)
    private final CurrentDateTime currentDateTime;
    public ServiceEngagementStatus getEngagementStatus() {
        return serviceEngagementDateSet.createEngagementStatus(currentDateTime);
    }

    public static EngagementEntity createFromOrder(
            EngagementStartOrder startOrder,
            Option<EngagementCancelStartOrder> cancelStartOrder,
            List<EngagementEndOrder> endOrderList,
            CurrentDateTime currentDateTime) {
        EngagementEndOrderEventList<ServiceEngagementEndOrderDate, ServiceEngagementEndCancelOrderDate> engagementEndOrderList
                = new EngagementEndOrderEventList<>(
                        endOrderList.map(v -> Tuple.of(v.getEngagementEndOrderDate(), v.getServiceEngagementEndCancelOrderDateOption())).toList()
                );
        return new EngagementEntity(
                startOrder.getUserId(),
                new ServiceEngagementDateSet(
                        startOrder.getEngagementStartOrderDate(),
                        cancelStartOrder.map(v -> v.getServiceEngagementStartCancelOrderDate()),
                        startOrder.getEngagementStartDate(),
                        engagementEndOrderList,
                        engagementEndOrderList.getLastEngagementEndOrderDate().map(ServiceEngagementEndDate::create)
                ),
                currentDateTime
        );

    }
}
