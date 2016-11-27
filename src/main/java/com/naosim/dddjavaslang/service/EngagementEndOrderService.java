package com.naosim.dddjavaslang.service;

import com.naosim.dddjavaslang.domain.account.UserId;
import com.naosim.dddjavaslang.domain.engagement.EngagementEndOrder;
import com.naosim.dddjavaslang.domain.engagement.EngagementRepository;
import com.naosim.dddjavaslang.domain.engagement.engagementdate.EngagementEndDate;
import com.naosim.dddjavaslang.domain.engagement.engagementdate.EngagementEndOrderDate;
import com.naosim.dddjavaslang.lib.javaslangutil.JavaslangUtil;
import com.naosim.dddjavaslang.lib.valid.InvalidReason;
import com.naosim.dddjavaslang.lib.valid.InvalidReasonString;
import javaslang.control.Option;
import javaslang.control.Validation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.naosim.dddjavaslang.lib.javaslangutil.JavaslangUtil.f;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class EngagementEndOrderService {
    private final EngagementRepository engagementRepository;

    public Option<InvalidReason> order(UserId userId, EngagementEndOrderDate engagementEndOrderDate) {
        Validation<InvalidReason, ?> validation = engagementRepository
                .findEngaged(userId)
                .flatMap(entity -> JavaslangUtil.validate(entity, v -> v.getEngagementStatus().isEngaged(), () -> new InvalidReasonString("契約中でない")))
                .map(entity -> entity.endOrder(engagementEndOrderDate))
                .map(f(engagementRepository::endOrder));
        return JavaslangUtil.invalidOptional(validation);
    }
}
