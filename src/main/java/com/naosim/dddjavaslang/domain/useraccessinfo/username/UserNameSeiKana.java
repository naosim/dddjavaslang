package com.naosim.dddjavaslang.domain.useraccessinfo.username;

import com.naosim.dddjavaslang.lib.string.Kana;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class UserNameSeiKana extends UserNameSei implements Kana {
    public UserNameSeiKana(String value) {
        super(value);
        validate(() -> new RuntimeException("invalid"));
    }
}
