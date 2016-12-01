package com.naosim.dddjavaslang.domain.serviceengagement;

import com.naosim.dddjavaslang.domain.account.UserId;
import com.naosim.dddjavaslang.domain.serviceengagement.engagementdate.ServiceEngagementDateSet;
import com.naosim.dddjavaslang.domain.serviceengagement.engagementdate.ServiceEngagementStartCancelOrderDate;
import com.naosim.dddjavaslang.lib.date.CurrentDateTime;
import com.naosim.dddjavaslang.lib.valid.InvalidReason;
import com.naosim.dddjavaslang.lib.valid.InvalidReasonString;
import javaslang.control.Validation;
import lombok.EqualsAndHashCode;

/**
 * 契約前の契約エンティティ
 */
@EqualsAndHashCode
public class EngagementBeforeEngageEntity extends EngagementEntity {
    private EngagementBeforeEngageEntity(UserId userId, ServiceEngagementDateSet serviceEngagementDateSet, CurrentDateTime currentDateTime) {
        super(userId, serviceEngagementDateSet, currentDateTime);
        if(serviceEngagementDateSet.cannotCancelStart(currentDateTime)) {
            throw new RuntimeException("契約申込状態でない");
        }
    }

    public EngagementCancelStartOrder cancelStartOrder(ServiceEngagementStartCancelOrderDate serviceEngagementStartCancelOrderDate) {
        return new EngagementCancelStartOrder(getUserId(), serviceEngagementStartCancelOrderDate);
    }

    public static Validation<InvalidReason, EngagementBeforeEngageEntity> create(UserId userId, ServiceEngagementDateSet serviceEngagementDateSet, CurrentDateTime currentDateTime) {
        if(serviceEngagementDateSet.cannotCancelStart(currentDateTime)) {
            return Validation.invalid(InvalidReasonString.create("契約申込状態でない"));
        }
        return Validation.valid(new EngagementBeforeEngageEntity(userId, serviceEngagementDateSet, currentDateTime));

    }

    public static Validation<InvalidReason, EngagementBeforeEngageEntity> create(EngagementEntity engagementEntity) {
        return create(
                engagementEntity.getUserId(),
                engagementEntity.getServiceEngagementDateSet(),
                engagementEntity.getCurrentDateTime()
        );

    }
}
