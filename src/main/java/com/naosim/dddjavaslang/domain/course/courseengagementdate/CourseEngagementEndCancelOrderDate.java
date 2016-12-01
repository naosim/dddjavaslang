package com.naosim.dddjavaslang.domain.course.courseengagementdate;

import com.naosim.dddjavaslang.lib.engagementlifesycle.engagementdate.EngagementEndCancelOrderDate;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

/**
 * 契約終了キャンセル申込日
 */
@EqualsAndHashCode
public class CourseEngagementEndCancelOrderDate extends EngagementEndCancelOrderDate {
    public CourseEngagementEndCancelOrderDate(LocalDate value) {
        super(value);
    }
}