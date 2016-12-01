package com.naosim.dddjavaslang.domain.course.courseengagementdate;

import com.naosim.dddjavaslang.lib.engagementlifesycle.engagementdate.EngagementStartCancelOrderDate;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

/**
 * 契約開始キャンセル申込日
 */
@EqualsAndHashCode
public class CourseEngagementStartCancelOrderDate extends EngagementStartCancelOrderDate {
    public CourseEngagementStartCancelOrderDate(LocalDate value) {
        super(value);
    }
}
