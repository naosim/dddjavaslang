package com.naosim.dddjavaslang.domain.useraccessinfo.username;

import com.naosim.dddjavaslang.lib.string.Kanji;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class UserNameMeiKanji extends UserNameMei implements Kanji {

    public UserNameMeiKanji(String value) {
        super(value);
    }
}
