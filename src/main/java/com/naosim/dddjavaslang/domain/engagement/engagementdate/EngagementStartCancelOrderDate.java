package com.naosim.dddjavaslang.domain.engagement.engagementdate;

import com.naosim.dddjavaslang.lib.date.DateValueObjectWithCompareCurrentDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

/**
 * 契約開始キャンセル申込日
 */
@AllArgsConstructor
public class EngagementStartCancelOrderDate implements DateValueObjectWithCompareCurrentDateTime {
    @Getter
    private final LocalDate value;
}
