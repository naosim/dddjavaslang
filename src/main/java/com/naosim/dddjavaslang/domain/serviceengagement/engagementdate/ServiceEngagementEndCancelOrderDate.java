package com.naosim.dddjavaslang.domain.serviceengagement.engagementdate;

import com.naosim.dddjavaslang.lib.engagementlifesycle.engagementdate.EngagementEndCancelOrderDate;
import com.naosim.dddjavaslang.lib.engagementlifesycle.engagementdate.EngagementEndOrderDate;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

/**
 * 契約終了キャンセル申込日
 */
@EqualsAndHashCode
public class ServiceEngagementEndCancelOrderDate extends EngagementEndCancelOrderDate {
    public ServiceEngagementEndCancelOrderDate(LocalDate value) {
        super(value);
    }
}