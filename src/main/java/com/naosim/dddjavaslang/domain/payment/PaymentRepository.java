package com.naosim.dddjavaslang.domain.payment;

import com.naosim.dddjavaslang.lib.valid.InvalidReason;
import javaslang.control.Validation;
import lombok.EqualsAndHashCode;

public interface PaymentRepository {
    Validation<InvalidReason, EnableCreditCard> validateCreditCard(CreditCard creditCard);
    void insert(PaymentStartOrder paymentStartOrder);
}
