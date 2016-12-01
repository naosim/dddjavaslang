package com.naosim.dddjavaslang.domain.course.courseengagementdate;

import com.naosim.dddjavaslang.lib.engagementlifesycle.engagementdate.EngagementStartDate;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.time.YearMonth;

/**
 * 契約開始日
 */
@EqualsAndHashCode
public class CourseEngagementStartDate extends EngagementStartDate {
    public CourseEngagementStartDate(LocalDate value) {
        super(value);
    }

    public static CourseEngagementStartDate create(CourseEngagementStartOrderDate engagementStartOrderDate) {
        // 申込の翌月１日が契約開始日になる
        return new CourseEngagementStartDate(YearMonth.from(engagementStartOrderDate.getValue()).atDay(1));
    }
}
