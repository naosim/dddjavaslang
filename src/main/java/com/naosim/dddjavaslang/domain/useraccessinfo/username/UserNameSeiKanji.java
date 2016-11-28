package com.naosim.dddjavaslang.domain.useraccessinfo.username;

import com.naosim.dddjavaslang.lib.string.Kanji;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class UserNameSeiKanji extends UserNameSei implements Kanji {
    public UserNameSeiKanji(String value) {
        super(value);
    }
}
