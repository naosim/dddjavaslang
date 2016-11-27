package com.naosim.dddjavaslang.domain.useraccessinfo.birthday;


import com.naosim.dddjavaslang.lib.date.CurrentDateTime;
import com.naosim.dddjavaslang.lib.javaslangutil.JavaslangUtil;
import com.naosim.dddjavaslang.lib.valid.InvalidReason;
import com.naosim.dddjavaslang.lib.valid.InvalidReasonString;
import javaslang.control.Validation;

/**
 * 契約可能な年齢
 * 20歳以上
 */
public class EngagableAge extends Age {
    private EngagableAge(Birthday birthday, CurrentDateTime currentDateTime) {
        super(birthday, currentDateTime);
    }


    public static Validation<InvalidReason, EngagableAge> validateAge(Age age) {
        return JavaslangUtil
                .validate(
                        age,
                        v -> v.getValue() >= 20,
                        () -> InvalidReasonString.create("20歳以上でない")
                )
                .map(v -> new EngagableAge(v.getBirthday(), v.getCurrentDateTime()));
    }
}
