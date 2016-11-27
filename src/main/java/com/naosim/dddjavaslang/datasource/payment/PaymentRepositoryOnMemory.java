package com.naosim.dddjavaslang.datasource.payment;

import com.naosim.dddjavaslang.domain.payment.CreditCard;
import com.naosim.dddjavaslang.domain.payment.EnableCreditCard;
import com.naosim.dddjavaslang.domain.payment.PaymentRepository;
import com.naosim.dddjavaslang.domain.payment.PaymentStartOrder;
import com.naosim.dddjavaslang.lib.valid.InvalidReason;
import javaslang.collection.HashSet;
import javaslang.collection.Set;
import javaslang.control.Validation;
import org.springframework.stereotype.Component;

@Component
public class PaymentRepositoryOnMemory implements PaymentRepository {
    private Set<PaymentStartOrder> paymentStartOrderTable = HashSet.empty();

    @Override
    public Validation<InvalidReason, EnableCreditCard> validateCreditCard(CreditCard creditCard) {
        return Validation.valid(new EnableCreditCard(creditCard.getCreditCardNumber(), creditCard.getCreditCardExpireDate()));
    }

    @Override
    public void insert(PaymentStartOrder paymentStartOrder) {
        paymentStartOrderTable = paymentStartOrderTable.add(paymentStartOrder);
    }
}
