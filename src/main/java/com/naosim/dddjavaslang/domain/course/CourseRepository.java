package com.naosim.dddjavaslang.domain.course;


import com.naosim.dddjavaslang.domain.account.UserId;
import javaslang.control.Option;

public interface CourseRepository {
    void newOrder(CourseEngagementStartOrder courseEngagementStartOrder);
    Option<CourseEntity> find(UserId userId);
}
