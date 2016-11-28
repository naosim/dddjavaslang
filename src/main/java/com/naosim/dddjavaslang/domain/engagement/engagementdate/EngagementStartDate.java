package com.naosim.dddjavaslang.domain.engagement.engagementdate;

import com.naosim.dddjavaslang.lib.date.DateValueObjectWithCompareCurrentDateTime;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalDate;
import java.time.YearMonth;

/**
 * 契約開始日
 */
@EqualsAndHashCode
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class EngagementStartDate implements DateValueObjectWithCompareCurrentDateTime {
    @Getter
    private final LocalDate value;

    public static EngagementStartDate create(EngagementStartOrderDate engagementStartOrderDate) {
        // 申込の翌月１日が契約開始日になる
        return new EngagementStartDate(YearMonth.from(engagementStartOrderDate.getValue()).atDay(1));
    }
}
