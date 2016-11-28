package com.naosim.dddjavaslang.domain.useraccessinfo.username;


import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class UniqueUserNameKana extends UserNameKana {

    public UniqueUserNameKana(UserNameSeiKana userNameSei, UserNameMeiKana userNameMei) {
        super(userNameSei, userNameMei);
    }
}
