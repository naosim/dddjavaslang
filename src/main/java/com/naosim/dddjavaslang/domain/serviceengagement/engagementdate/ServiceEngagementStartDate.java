package com.naosim.dddjavaslang.domain.serviceengagement.engagementdate;

import com.naosim.dddjavaslang.lib.engagementlifesycle.engagementdate.EngagementStartDate;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.time.YearMonth;

/**
 * 契約開始日
 */
@EqualsAndHashCode
public class ServiceEngagementStartDate extends EngagementStartDate {
    public ServiceEngagementStartDate(LocalDate value) {
        super(value);
    }

    public static ServiceEngagementStartDate create(ServiceEngagementStartOrderDate engagementStartOrderDate) {
        // 申込の翌月１日が契約開始日になる
        return new ServiceEngagementStartDate(YearMonth.from(engagementStartOrderDate.getValue()).atDay(1));
    }
}
