package com.naosim.dddjavaslang.domain.engagement.engagementdate;


import com.naosim.dddjavaslang.lib.date.DateValueObjectWithCompareCurrentDateTime;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalDate;
import java.time.YearMonth;

/**
 * 契約終了日
 */
@EqualsAndHashCode
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class EngagementEndDate implements DateValueObjectWithCompareCurrentDateTime {
    @Getter
    private final LocalDate value;

    public static EngagementEndDate create(EngagementEndOrderDate engagementEndOrderDate) {
        // 申込の翌月１日が契約終了日になる
        return new EngagementEndDate(YearMonth.from(engagementEndOrderDate.getValue()).atDay(1));
    }
}
