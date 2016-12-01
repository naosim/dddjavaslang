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
import lombok.EqualsAndHashCode;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

@EqualsAndHashCode
public class CourseEntity {
    private final EngagementEntity engagementEntity;
    private final List<CourseEngagementDateSet> CourseEngagementDateSetList;
    private final CurrentDateTime currentDateTime;

    private CourseEntity(EngagementEntity engagementEntity, List<CourseEngagementDateSet> courseEngagementDateSetList, CurrentDateTime currentDateTime) {
        this.engagementEntity = engagementEntity;
        CourseEngagementDateSetList = courseEngagementDateSetList;
        this.currentDateTime = currentDateTime;
    }


    public UserId getUserId() {
        return engagementEntity.getUserId();
    }

    public CourseType getCurrentCourseType() {
        throw new NotImplementedException();
    }

    public void addCourse(CourseType courseType, CourseEngagementStartOrderDate courseEngagementStartOrderDate) {
        throw new NotImplementedException();
    }

    public static Validation<InvalidReason, CourseEntity> create(EngagementEntity engagementEntity, List<CourseEngagementDateSet> courseEngagementDateSetList, CurrentDateTime currentDateTime) {
        return courseEngagementDateSetList.isEmpty()
                ? Validation.invalid(InvalidReasonString.create("申込が１つもない"))
                : Validation.valid(new CourseEntity(engagementEntity, courseEngagementDateSetList, currentDateTime));
    }
}
