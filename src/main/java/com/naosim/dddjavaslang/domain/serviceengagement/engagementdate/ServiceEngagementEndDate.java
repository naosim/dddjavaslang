package com.naosim.dddjavaslang.domain.serviceengagement.engagementdate;

import com.naosim.dddjavaslang.lib.engagementlifesycle.engagementdate.EngagementEndDate;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalDate;
import java.time.YearMonth;

/**
 * 契約終了日
 */
@EqualsAndHashCode
public class ServiceEngagementEndDate extends EngagementEndDate {

    private ServiceEngagementEndDate(LocalDate value) {
        super(value);
    }

    public static ServiceEngagementEndDate create(ServiceEngagementEndOrderDate engagementEndOrderDate) {
        // 申込の翌月１日が契約終了日になる
        return new ServiceEngagementEndDate(YearMonth.from(engagementEndOrderDate.getValue()).atDay(1));
    }
}
