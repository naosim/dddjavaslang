package com.naosim.dddjavaslang.domain.course;

import com.naosim.dddjavaslang.lib.engagementlifesycle.EngagementStatus;
import com.naosim.dddjavaslang.lib.engagementlifesycle.EngagementStatusType;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.stream.Stream;

/**
 * 契約状態
 */
@AllArgsConstructor
public enum CourseEngagementStatus implements EngagementStatus {
    startOrdered(EngagementStatusType.startOrdered),
    startOrderCanceled(EngagementStatusType.startOrderCanceled),
    engaged(EngagementStatusType.ended),
    engagedAndEndOrdered(EngagementStatusType.engagedAndEndOrdered),
    ended(EngagementStatusType.ended);

    @Getter
    private final EngagementStatusType engagementStatusType;

    public static CourseEngagementStatus convert(EngagementStatusType type) {
        return Stream.of(CourseEngagementStatus.values())
                .filter(v -> v.engagementStatusType.equals(type))
                .findFirst()
                .get();
    }

}

