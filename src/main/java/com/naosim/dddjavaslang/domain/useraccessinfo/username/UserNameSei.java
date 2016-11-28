package com.naosim.dddjavaslang.domain.useraccessinfo.username;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
@AllArgsConstructor
abstract class UserNameSei {
    @Getter
    private final String value;
}
