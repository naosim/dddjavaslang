package com.naosim.dddjavaslang.domain.useraccessinfo.username;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class UserNameKanji extends UserName<UserNameSeiKanji, UserNameMeiKanji> {
    public UserNameKanji(UserNameSeiKanji userNameSei, UserNameMeiKanji userNameMei) {
        super(userNameSei, userNameMei);
    }
}
