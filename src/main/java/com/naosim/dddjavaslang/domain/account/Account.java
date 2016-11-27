package com.naosim.dddjavaslang.domain.account;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class Account {
    @Getter
    private final UserId userId;
    private final Password password;
}
