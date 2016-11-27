package com.naosim.dddjavaslang.service;

import com.naosim.dddjavaslang.domain.account.AccountRepository;
import com.naosim.dddjavaslang.domain.engagement.EngagementRepository;
import com.naosim.dddjavaslang.domain.order.engagementstart.EngagementStartOrder;
import com.naosim.dddjavaslang.domain.order.engagementstart.ValidEngagementStartOrder;
import com.naosim.dddjavaslang.domain.payment.PaymentRepository;
import com.naosim.dddjavaslang.domain.useraccessinfo.UserAccessInfoRepository;
import com.naosim.dddjavaslang.domain.useraccessinfo.birthday.EngagableAge;
import com.naosim.dddjavaslang.lib.javaslangutil.JavaslangUtil;
import com.naosim.dddjavaslang.lib.valid.InvalidReason;
import javaslang.collection.List;
import javaslang.control.Option;
import javaslang.control.Validation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.naosim.dddjavaslang.lib.javaslangutil.JavaslangUtil.f;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class EngagementStartOrderService {
    private final UserAccessInfoRepository userAccessInfoRepository;
    private final PaymentRepository paymentRepository;
    private final AccountRepository accountRepository;
    private final EngagementRepository engagementRepository;

    public Option<List<InvalidReason>> order(EngagementStartOrder engagementStartOrder) {
        Validation<List<InvalidReason>, ?> validation = validateEngagementStartOrder(engagementStartOrder)
                .map(f(this::order));
        return JavaslangUtil.invalidOptional(validation);
    }

    public void order(ValidEngagementStartOrder engagementStartOrder) {
        // アカウント
        accountRepository.save(engagementStartOrder.getAccount());
        // 契約
        engagementRepository.order(engagementStartOrder.createEngagementStartOrder());
        // 支払方法
        paymentRepository.insert(engagementStartOrder.createPaymentStartOrder());
        // 連絡先情報
        userAccessInfoRepository.insert(engagementStartOrder.createUserAccessInfoOrder());
    }

    // 契約申込のバリデーション
    public Validation<List<InvalidReason>, ValidEngagementStartOrder> validateEngagementStartOrder(EngagementStartOrder engagementStartOrder) {
        return Validation.combine(
                EngagableAge.validateAge(engagementStartOrder.getAge()), // 年齢
                userAccessInfoRepository.validateUserNameKana(engagementStartOrder.getUserNameKana()),// 名前
                paymentRepository.validateCreditCard(engagementStartOrder.getCreditCard())// クレカ
        ).ap((age, kana, card) -> new ValidEngagementStartOrder(
                engagementStartOrder.getEngagementStartOrderDate(),
                kana,
                engagementStartOrder.getUserNameKanji(),
                age,
                card,
                accountRepository.createAccount()
        ));
    }
}
