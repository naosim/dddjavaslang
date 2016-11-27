package com.naosim.dddjavaslang.domain.useraccessinfo;

import com.naosim.dddjavaslang.domain.useraccessinfo.username.UniqueUserNameKana;
import com.naosim.dddjavaslang.domain.useraccessinfo.username.UserNameKana;
import com.naosim.dddjavaslang.lib.valid.InvalidReason;
import javaslang.control.Validation;

public interface UserAccessInfoRepository {
    Validation<InvalidReason, UniqueUserNameKana> validateUserNameKana(UserNameKana userNameKana);
    void insert(UserAccessInfoOrder userAccessInfoOrder);
}
