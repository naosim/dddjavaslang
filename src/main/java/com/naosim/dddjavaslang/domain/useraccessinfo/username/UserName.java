package com.naosim.dddjavaslang.domain.useraccessinfo.username;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
abstract class UserName<SEI extends UserNameSei, MEI extends UserNameMei> {
    @Getter
    private final SEI userNameSei;
    @Getter
    private final MEI userNameMei;
}
