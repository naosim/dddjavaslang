package com.naosim.dddjavaslang.lib.engagementlifesycle.engagementdate;

import com.naosim.dddjavaslang.lib.date.DateValueObjectWithCompareCurrentDateTime;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalDate;

/**
 * 契約終了申込日
 */
@EqualsAndHashCode
@AllArgsConstructor
public class EngagementEndOrderDate implements DateValueObjectWithCompareCurrentDateTime {
    @Getter
    private final LocalDate value;
}