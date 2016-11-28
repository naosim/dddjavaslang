package com.naosim.dddjavaslang.domain.payment;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@EqualsAndHashCode
@AllArgsConstructor
public class CreditCardExpireDate {
    private final LocalDate localDate;
}
