package com.naosim.dddjavaslang.domain.engagement.engagementdate;

import com.naosim.dddjavaslang.lib.date.DateValueObjectWithCompareCurrentDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

/**
 * 契約終了申込日
 */
@AllArgsConstructor
public class EngagementEndOrderDate implements DateValueObjectWithCompareCurrentDateTime {
    @Getter
    private final LocalDate value;
}