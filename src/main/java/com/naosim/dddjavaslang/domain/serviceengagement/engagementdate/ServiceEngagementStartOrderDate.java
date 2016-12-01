package com.naosim.dddjavaslang.domain.serviceengagement.engagementdate;

import com.naosim.dddjavaslang.lib.date.DateValueObjectWithCompareCurrentDateTime;
import com.naosim.dddjavaslang.lib.engagementlifesycle.engagementdate.EngagementStartOrderDate;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalDate;

/**
 * 契約開始申込日
 */
@EqualsAndHashCode
public class ServiceEngagementStartOrderDate extends EngagementStartOrderDate {

    public ServiceEngagementStartOrderDate(LocalDate value) {
        super(value);
    }
}
