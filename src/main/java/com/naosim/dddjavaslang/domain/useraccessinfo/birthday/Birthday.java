package com.naosim.dddjavaslang.domain.useraccessinfo.birthday;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalDate;

@EqualsAndHashCode
@AllArgsConstructor
public class Birthday {
    @Getter
    private final LocalDate value;
}
