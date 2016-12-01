package com.naosim.dddjavaslang.domain.course.courseengagementdate;

import com.naosim.dddjavaslang.lib.engagementlifesycle.engagementdate.EngagementStartOrderDate;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

/**
 * 契約開始申込日
 */
@EqualsAndHashCode
public class CourseEngagementStartOrderDate extends EngagementStartOrderDate {

    public CourseEngagementStartOrderDate(LocalDate value) {
        super(value);
    }
}
