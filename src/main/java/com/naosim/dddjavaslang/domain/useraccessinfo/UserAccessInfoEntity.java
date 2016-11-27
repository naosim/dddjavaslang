package com.naosim.dddjavaslang.domain.useraccessinfo;

import com.naosim.dddjavaslang.domain.account.UserId;
import com.naosim.dddjavaslang.domain.useraccessinfo.birthday.EngagableAge;
import com.naosim.dddjavaslang.domain.useraccessinfo.username.UserNameKana;
import com.naosim.dddjavaslang.domain.useraccessinfo.username.UserNameKanji;
import lombok.AllArgsConstructor;

/**
 * 連絡先情報
 */
@AllArgsConstructor
public class UserAccessInfoEntity {
    private final UserId userId;
    private final UserNameKana userNameKana;
    private final UserNameKanji userNameKanji;
    private final EngagableAge age;
}
