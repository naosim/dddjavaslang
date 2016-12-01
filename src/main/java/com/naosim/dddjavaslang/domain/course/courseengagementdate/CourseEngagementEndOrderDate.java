package com.naosim.dddjavaslang.domain.course.courseengagementdate;

import com.naosim.dddjavaslang.lib.engagementlifesycle.engagementdate.EngagementEndOrderDate;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

/**
 * 契約終了申込日
 */
@EqualsAndHashCode
public class CourseEngagementEndOrderDate extends EngagementEndOrderDate {
    public CourseEngagementEndOrderDate(LocalDate value) {
        super(value);
    }
}