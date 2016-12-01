package com.naosim.dddjavaslang.domain.course;

import com.naosim.dddjavaslang.domain.account.UserId;
import com.naosim.dddjavaslang.domain.course.courseengagementdate.CourseEngagementDateSet;
import com.naosim.dddjavaslang.domain.course.courseengagementdate.CourseEngagementStartOrderDate;
import com.naosim.dddjavaslang.domain.serviceengagement.EngagementEntity;
import com.naosim.dddjavaslang.lib.date.CurrentDateTime;
import com.naosim.dddjavaslang.lib.valid.InvalidReason;
import com.naosim.dddjavaslang.lib.valid.InvalidReasonString;
import javaslang.collection.List;
import javaslang.control.Validation;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.experimental.Delegate;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

@EqualsAndHashCode
@AllArgsConstructor
public class CurrentCourseEntity {
    private final EngagementEntity engagementEntity;
    @Delegate
    private final CourseEngagementDateSet courseEngagementDateSet;
    private final CurrentDateTime currentDateTime;

    public UserId getUserId() {
        return engagementEntity.getUserId();
    }

    public void changeCourse(CourseType courseType, CourseEngagementStartOrderDate courseEngagementStartOrderDate) {
        throw new NotImplementedException();
    }
}
