package com.naosim.dddjavaslang.lib.date;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
public class CurrentDateTime {
    @Getter
    private final LocalDateTime value;
}
