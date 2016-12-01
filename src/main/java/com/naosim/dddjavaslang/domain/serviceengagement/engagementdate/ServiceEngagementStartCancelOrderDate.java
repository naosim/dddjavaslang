package com.naosim.dddjavaslang.domain.serviceengagement.engagementdate;

import com.naosim.dddjavaslang.lib.date.DateValueObjectWithCompareCurrentDateTime;
import com.naosim.dddjavaslang.lib.engagementlifesycle.engagementdate.EngagementStartCancelOrderDate;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalDate;

/**
 * 契約開始キャンセル申込日
 */
@EqualsAndHashCode
public class ServiceEngagementStartCancelOrderDate extends EngagementStartCancelOrderDate {
    public ServiceEngagementStartCancelOrderDate(LocalDate value) {
        super(value);
    }
}
