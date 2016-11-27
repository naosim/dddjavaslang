package com.naosim.dddjavaslang.domain.useraccessinfo;

import com.naosim.dddjavaslang.domain.account.UserId;
import com.naosim.dddjavaslang.domain.engagement.engagementdate.EngagementStartDate;
import com.naosim.dddjavaslang.domain.engagement.engagementdate.EngagementStartOrderDate;
import com.naosim.dddjavaslang.domain.useraccessinfo.username.UniqueUserNameKana;
import com.naosim.dddjavaslang.domain.useraccessinfo.username.UserNameKanji;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserAccessInfoOrder {
    private final UserId userId;
    @Getter
    private final UniqueUserNameKana uniqueUserNameKana;
    private final UserNameKanji userNameKanji;
    private final EngagementStartOrderDate engagementStartOrderDate;
    private final EngagementStartDate engagementStartDate;

    public static UserAccessInfoOrder create(
            UserId userId,
            UniqueUserNameKana uniqueUserNameKana,
            UserNameKanji userNameKanji,
            EngagementStartOrderDate engagementStartOrderDate
    ) {
        return new UserAccessInfoOrder(
                userId,
                uniqueUserNameKana,
                userNameKanji,
                engagementStartOrderDate,
                EngagementStartDate.create(engagementStartOrderDate)
        );
    }
}
