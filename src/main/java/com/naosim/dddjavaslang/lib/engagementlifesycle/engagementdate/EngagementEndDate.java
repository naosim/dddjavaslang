package com.naosim.dddjavaslang.lib.engagementlifesycle.engagementdate;


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
@AllArgsConstructor
public class EngagementEndDate implements DateValueObjectWithCompareCurrentDateTime {
    @Getter
    private final LocalDate value;
}
