package com.naosim.dddjavaslang.domain.payment;

import com.naosim.dddjavaslang.domain.account.UserId;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
@AllArgsConstructor
public class PaymentStartOrder {
    private final UserId userId;
    private final EnableCreditCard enableCreditCard;
}
