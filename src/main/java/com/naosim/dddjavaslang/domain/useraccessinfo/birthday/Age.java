package com.naosim.dddjavaslang.domain.useraccessinfo.birthday;


import com.naosim.dddjavaslang.lib.date.CurrentDateTime;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.temporal.ChronoUnit;

@AllArgsConstructor
public class Age {
    @Getter
    private final Birthday birthday;
    @Getter(AccessLevel.PROTECTED)
    private final CurrentDateTime currentDateTime;
    public int getValue() {
        return (int)ChronoUnit.YEARS.between(birthday.getValue(), currentDateTime.getValue());
    }
}
