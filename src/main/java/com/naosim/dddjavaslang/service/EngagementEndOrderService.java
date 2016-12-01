package com.naosim.dddjavaslang.service;

import com.naosim.dddjavaslang.domain.account.UserId;
import com.naosim.dddjavaslang.domain.serviceengagement.EngagementRepository;
import com.naosim.dddjavaslang.domain.serviceengagement.engagementdate.ServiceEngagementEndOrderDate;
import com.naosim.dddjavaslang.lib.javaslangutil.JavaslangUtil;
import com.naosim.dddjavaslang.lib.valid.InvalidReason;
import javaslang.control.Option;
import javaslang.control.Validation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class EngagementEndOrderService {
    private final EngagementRepository engagementRepository;

    public Option<InvalidReason> order(UserId userId, ServiceEngagementEndOrderDate engagementEndOrderDate) {
        return engagementRepository
                .findEngaged(userId)
                .map(entity -> entity.endOrder(engagementEndOrderDate))
                .peek(engagementRepository::endOrder)
                .leftMap(Option::some).getError();
    }
}
