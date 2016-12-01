package com.naosim.dddjavaslang.domain.course.courseengagementdate;


import com.naosim.dddjavaslang.lib.engagementlifesycle.engagementdate.EngagementEndDate;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.time.YearMonth;

/**
 * 契約終了日
 */
@EqualsAndHashCode
public class CourseEngagementEndDate extends EngagementEndDate {

    private CourseEngagementEndDate(LocalDate value) {
        super(value);
    }

    public static CourseEngagementEndDate create(CourseEngagementEndOrderDate engagementEndOrderDate) {
        // 申込の翌月１日が契約終了日になる
        return new CourseEngagementEndDate(YearMonth.from(engagementEndOrderDate.getValue()).atDay(1));
    }
}
