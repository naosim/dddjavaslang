package com.naosim.dddjavaslang.domain.serviceengagement;

import com.naosim.dddjavaslang.lib.engagementlifesycle.EngagementStatus;
import com.naosim.dddjavaslang.lib.engagementlifesycle.EngagementStatusType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Delegate;

import java.util.stream.Stream;

@AllArgsConstructor
public enum ServiceEngagementStatus implements EngagementStatus {
    startOrdered(EngagementStatusType.startOrdered),
    startOrderCanceled(EngagementStatusType.startOrderCanceled),
    engaged(EngagementStatusType.ended),
    engagedAndEndOrdered(EngagementStatusType.engagedAndEndOrdered),
    ended(EngagementStatusType.ended);

    @Getter
    private final EngagementStatusType engagementStatusType;

    public boolean isEngeged() {
        return engagementStatusType.isEngaged();
    }

    public boolean isNotEngaged() {
        return engagementStatusType.isNotEngaged();
    }

    public static ServiceEngagementStatus convert(EngagementStatusType type) {
        return Stream.of(ServiceEngagementStatus.values())
                .filter(v -> v.engagementStatusType.equals(type))
                .findFirst()
                .get();
    }

}
