package com.naosim.dddjavaslang.domain.serviceengagement.engagementdate;

import com.naosim.dddjavaslang.lib.date.DateValueObjectWithCompareCurrentDateTime;
import com.naosim.dddjavaslang.lib.engagementlifesycle.engagementdate.EngagementEndOrderDate;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalDate;

/**
 * 契約終了申込日
 */
@EqualsAndHashCode
public class ServiceEngagementEndOrderDate extends EngagementEndOrderDate {
    public ServiceEngagementEndOrderDate(LocalDate value) {
        super(value);
    }
}