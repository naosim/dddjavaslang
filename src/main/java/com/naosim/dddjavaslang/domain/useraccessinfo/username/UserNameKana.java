package com.naosim.dddjavaslang.domain.useraccessinfo.username;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class UserNameKana extends UserName<UserNameSeiKana, UserNameMeiKana> {
    public UserNameKana(UserNameSeiKana userNameSei, UserNameMeiKana userNameMei) {
        super(userNameSei, userNameMei);
    }
}
