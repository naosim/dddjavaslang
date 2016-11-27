package com.naosim.dddjavaslang.datasource.useraccessinfo;

import com.naosim.dddjavaslang.domain.useraccessinfo.UserAccessInfoOrder;
import com.naosim.dddjavaslang.domain.useraccessinfo.UserAccessInfoRepository;
import com.naosim.dddjavaslang.domain.useraccessinfo.username.UniqueUserNameKana;
import com.naosim.dddjavaslang.domain.useraccessinfo.username.UserNameKana;
import com.naosim.dddjavaslang.lib.valid.InvalidReason;
import com.naosim.dddjavaslang.lib.valid.InvalidReasonString;
import javaslang.collection.HashSet;
import javaslang.collection.Set;
import javaslang.control.Validation;
import org.springframework.stereotype.Component;

import static com.naosim.dddjavaslang.lib.javaslangutil.LambdaUtil.eqSamePath;
import static com.naosim.dddjavaslang.lib.valid.InvalidReason.throwAction;

@Component
public class UserAccessInfoRepositoryOnMemory implements UserAccessInfoRepository {
    private Set<UserAccessInfoOrder> dataSet = HashSet.empty();

    @Override
    public Validation<InvalidReason, UniqueUserNameKana> validateUserNameKana(UserNameKana userNameKana) {
        return dataSet.map(v -> v.getUniqueUserNameKana())
                .filter(v -> eqSamePath(userNameKana, v, p -> p.getUserNameSei().getValue()))
                .filter(v -> eqSamePath(userNameKana, v, p -> p.getUserNameMei().getValue()))
                .isEmpty()
                ? Validation.valid(new UniqueUserNameKana(userNameKana.getUserNameSei(), userNameKana.getUserNameMei()))
                : Validation.invalid(new InvalidReasonString("既に登録済みのユーザ名"));
    }

    @Override
    public void insert(UserAccessInfoOrder userAccessInfoOrder) {
        validateUserNameKana(userAccessInfoOrder.getUniqueUserNameKana()).toEither().left().forEach(throwAction);
        dataSet = dataSet.add(userAccessInfoOrder);
    }
}
