package com.naosim.dddjavaslang.domain.course.courseengagementdate;

import com.naosim.dddjavaslang.domain.course.CourseEngagementStatus;
import com.naosim.dddjavaslang.domain.course.CourseType;
import com.naosim.dddjavaslang.lib.engagementlifesycle.EngagementStatusType;
import com.naosim.dddjavaslang.lib.engagementlifesycle.engagementdate.EngagementEndOrderEventList;
import com.naosim.dddjavaslang.lib.engagementlifesycle.engagementdate.EngagementEventDateSet;
import javaslang.control.Option;
import lombok.Getter;

public class CourseEngagementDateSet extends EngagementEventDateSet<
        CourseEngagementStartOrderDate,
        CourseEngagementStartCancelOrderDate,
        CourseEngagementStartDate,
        CourseEngagementEndOrderDate,
        CourseEngagementEndCancelOrderDate,
        CourseEngagementEndDate,
        CourseEngagementStatus
            >

    {
        @Getter
        private final CourseType courseType;

        public CourseEngagementDateSet(CourseEngagementStartOrderDate engagementStartOrderDate, Option<CourseEngagementStartCancelOrderDate> engagementStartCancelOrderDate, CourseEngagementStartDate engagementStartDate, EngagementEndOrderEventList<CourseEngagementEndOrderDate, CourseEngagementEndCancelOrderDate> engagementEndOrderList, Option<CourseEngagementEndDate> engagementEndDateOption, CourseType courseType) {
            super(engagementStartOrderDate, engagementStartCancelOrderDate, engagementStartDate, engagementEndOrderList, engagementEndDateOption);
            this.courseType = courseType;
        }

        @Override
        protected CourseEngagementStatus convertStatus(EngagementStatusType engagementStatusType) {
        return CourseEngagementStatus.convert(engagementStatusType);
    }
}
