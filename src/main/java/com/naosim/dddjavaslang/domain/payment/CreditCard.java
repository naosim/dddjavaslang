package com.naosim.dddjavaslang.domain.payment;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class CreditCard {
    @Getter
    private final CreditCardNumber creditCardNumber;
    @Getter
    private final CreditCardExpireDate creditCardExpireDate;
}
