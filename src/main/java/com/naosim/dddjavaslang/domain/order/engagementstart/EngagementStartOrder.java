package com.naosim.dddjavaslang.domain.order.engagementstart;

import com.naosim.dddjavaslang.domain.engagement.engagementdate.EngagementStartOrderDate;
import com.naosim.dddjavaslang.domain.payment.CreditCard;
import com.naosim.dddjavaslang.domain.useraccessinfo.birthday.Age;
import com.naosim.dddjavaslang.domain.useraccessinfo.username.UserNameKana;
import com.naosim.dddjavaslang.domain.useraccessinfo.username.UserNameKanji;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 契約開始申込
 */
@AllArgsConstructor
public class EngagementStartOrder {
    @Getter
    private final EngagementStartOrderDate engagementStartOrderDate;
    @Getter
    private final UserNameKana userNameKana;
    @Getter
    private final UserNameKanji userNameKanji;
    @Getter
    private final Age age;
    @Getter
    private final CreditCard creditCard;
}
