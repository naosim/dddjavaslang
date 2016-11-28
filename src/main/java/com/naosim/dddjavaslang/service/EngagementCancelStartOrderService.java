package com.naosim.dddjavaslang.service;

import com.naosim.dddjavaslang.domain.account.UserId;
import com.naosim.dddjavaslang.domain.engagement.EngagementRepository;
import com.naosim.dddjavaslang.domain.engagement.engagementdate.EngagementEndOrderDate;
import com.naosim.dddjavaslang.domain.engagement.engagementdate.EngagementStartCancelOrderDate;
import com.naosim.dddjavaslang.lib.javaslangutil.JavaslangUtil;
import com.naosim.dddjavaslang.lib.valid.InvalidReason;
import com.naosim.dddjavaslang.lib.valid.InvalidReasonString;
import javaslang.control.Option;
import javaslang.control.Validation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.naosim.dddjavaslang.lib.javaslangutil.JavaslangUtil.f;

/**
 * 契約申込キャンセル
 */
@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class EngagementCancelStartOrderService {
    private final EngagementRepository engagementRepository;

    public Option<InvalidReason> order(UserId userId, EngagementStartCancelOrderDate engagementStartCancelOrderDate) {
        Validation<InvalidReason, ?> validation = engagementRepository
                .findBeforeEngage(userId)
                .map(entity -> entity.cancelStartOrder(engagementStartCancelOrderDate))
                .map(f(engagementRepository::cancelStartOrder));
        return JavaslangUtil.invalidOptional(validation);
    }
}
