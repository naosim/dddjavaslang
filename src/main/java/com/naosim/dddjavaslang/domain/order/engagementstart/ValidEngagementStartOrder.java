package com.naosim.dddjavaslang.domain.order.engagementstart;

import com.naosim.dddjavaslang.domain.account.Account;
import com.naosim.dddjavaslang.domain.serviceengagement.engagementdate.ServiceEngagementStartOrderDate;
import com.naosim.dddjavaslang.domain.payment.EnableCreditCard;
import com.naosim.dddjavaslang.domain.payment.PaymentStartOrder;
import com.naosim.dddjavaslang.domain.useraccessinfo.UserAccessInfoOrder;
import com.naosim.dddjavaslang.domain.useraccessinfo.birthday.EngagableAge;
import com.naosim.dddjavaslang.domain.useraccessinfo.username.UniqueUserNameKana;
import com.naosim.dddjavaslang.domain.useraccessinfo.username.UserNameKanji;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;


/**
 * 契約開始申込
 */
@EqualsAndHashCode
@AllArgsConstructor
public class ValidEngagementStartOrder {
    @Getter
    private final ServiceEngagementStartOrderDate engagementStartOrderDate;
    @Getter
    private final UniqueUserNameKana uniqueUserNameKana;
    @Getter
    private final UserNameKanji userNameKanji;
    @Getter
    private final EngagableAge engagableAge;
    @Getter
    private final EnableCreditCard creditCard;
    @Getter
    private final Account account;

    public com.naosim.dddjavaslang.domain.serviceengagement.EngagementStartOrder createEngagementStartOrder() {
        return new com.naosim.dddjavaslang.domain.serviceengagement.EngagementStartOrder(
                account.getUserId(),
                engagementStartOrderDate
        );
    }

    public PaymentStartOrder createPaymentStartOrder() {
        return new PaymentStartOrder(
                account.getUserId(),
                creditCard
        );
    }

    public UserAccessInfoOrder createUserAccessInfoOrder() {
        return UserAccessInfoOrder.create(
                account.getUserId(),
                uniqueUserNameKana,
                userNameKanji,
                engagementStartOrderDate
        );
    }
}
