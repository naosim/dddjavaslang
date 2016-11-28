package com.naosim.dddjavaslang.domain.account;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
@AllArgsConstructor
public class Account {
    @Getter
    private final UserId userId;
    private final Password password;
}
