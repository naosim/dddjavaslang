package com.naosim.dddjavaslang.domain.account;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
@AllArgsConstructor
public class UserId {
    @Getter
    private final String value;
}
