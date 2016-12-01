package com.naosim.dddjavaslang.service;

import com.naosim.dddjavaslang.domain.account.UserId;
import com.naosim.dddjavaslang.domain.serviceengagement.EngagementRepository;
import com.naosim.dddjavaslang.domain.serviceengagement.engagementdate.ServiceEngagementStartCancelOrderDate;
import com.naosim.dddjavaslang.lib.javaslangutil.JavaslangUtil;
import com.naosim.dddjavaslang.lib.valid.InvalidReason;
import javaslang.control.Option;
import javaslang.control.Validation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 契約申込キャンセル
 */
@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class EngagementCancelStartOrderService {
    private final EngagementRepository engagementRepository;

    public Option<InvalidReason> order(UserId userId, ServiceEngagementStartCancelOrderDate serviceEngagementStartCancelOrderDate) {
        Validation<InvalidReason, ?> validation = engagementRepository
                .findBeforeEngage(userId)
                .map(entity -> entity.cancelStartOrder(serviceEngagementStartCancelOrderDate))
                .peek(engagementRepository::cancelStartOrder);
        return JavaslangUtil.invalidOptional(validation);
    }
}
