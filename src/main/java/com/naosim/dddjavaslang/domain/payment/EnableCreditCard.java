package com.naosim.dddjavaslang.domain.payment;

/**
 * 有効なクレジットカード
 */
public class EnableCreditCard extends CreditCard {
    public EnableCreditCard(CreditCardNumber creditCardNumber, CreditCardExpireDate creditCardExpireDate) {
        super(creditCardNumber, creditCardExpireDate);
    }
}
