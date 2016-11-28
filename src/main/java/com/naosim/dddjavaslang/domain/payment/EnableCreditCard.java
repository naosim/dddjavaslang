package com.naosim.dddjavaslang.domain.payment;

import lombok.EqualsAndHashCode;

/**
 * 有効なクレジットカード
 */
@EqualsAndHashCode
public class EnableCreditCard extends CreditCard {
    public EnableCreditCard(CreditCardNumber creditCardNumber, CreditCardExpireDate creditCardExpireDate) {
        super(creditCardNumber, creditCardExpireDate);
    }
}
