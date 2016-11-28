package com.naosim.dddjavaslang.domain.payment;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
@AllArgsConstructor
public class CreditCard {
    @Getter
    private final CreditCardNumber creditCardNumber;
    @Getter
    private final CreditCardExpireDate creditCardExpireDate;
}
