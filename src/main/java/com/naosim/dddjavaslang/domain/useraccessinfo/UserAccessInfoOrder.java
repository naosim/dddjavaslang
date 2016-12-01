package com.naosim.dddjavaslang.domain.useraccessinfo;

import com.naosim.dddjavaslang.domain.account.UserId;
import com.naosim.dddjavaslang.domain.serviceengagement.engagementdate.ServiceEngagementStartDate;
import com.naosim.dddjavaslang.domain.serviceengagement.engagementdate.ServiceEngagementStartOrderDate;
import com.naosim.dddjavaslang.domain.useraccessinfo.username.UniqueUserNameKana;
import com.naosim.dddjavaslang.domain.useraccessinfo.username.UserNameKanji;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserAccessInfoOrder {
    private final UserId userId;
    @Getter
    private final UniqueUserNameKana uniqueUserNameKana;
    private final UserNameKanji userNameKanji;
    private final ServiceEngagementStartOrderDate engagementStartOrderDate;
    private final ServiceEngagementStartDate engagementStartDate;

    public static UserAccessInfoOrder create(
            UserId userId,
            UniqueUserNameKana uniqueUserNameKana,
            UserNameKanji userNameKanji,
            ServiceEngagementStartOrderDate engagementStartOrderDate
    ) {
        return new UserAccessInfoOrder(
                userId,
                uniqueUserNameKana,
                userNameKanji,
                engagementStartOrderDate,
                ServiceEngagementStartDate.create(engagementStartOrderDate)
        );
    }
}
