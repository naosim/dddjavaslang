package com.naosim.dddjavaslang.domain.course;

import com.naosim.dddjavaslang.domain.account.UserId;
import com.naosim.dddjavaslang.domain.course.courseengagementdate.CourseEngagementStartOrderDate;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class CourseEngagementStartOrder {
    @Getter
    private final UserId userId;

    @Getter
    private final CourseType courseType;

    @Getter
    private final CourseEngagementStartOrderDate courseEngagementStartOrderDate;
}
