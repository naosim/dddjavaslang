package com.naosim.dddjavaslang.domain.useraccessinfo.birthday;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
public class Birthday {
    @Getter
    private final LocalDate value;
}
