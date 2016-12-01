package com.naosim.dddjavaslang.domain.serviceengagement;

import com.naosim.dddjavaslang.domain.account.UserId;
import com.naosim.dddjavaslang.domain.serviceengagement.engagementdate.ServiceEngagementDateSet;
import com.naosim.dddjavaslang.domain.serviceengagement.engagementdate.ServiceEngagementEndOrderDate;
import com.naosim.dddjavaslang.lib.date.CurrentDateTime;
import com.naosim.dddjavaslang.lib.valid.InvalidReason;
import com.naosim.dddjavaslang.lib.valid.InvalidReasonString;
import javaslang.control.Validation;
import lombok.EqualsAndHashCode;

/**
 * 契約中の契約エンティティ
 */
@EqualsAndHashCode
public class EngagementEngagedEntity extends EngagementEntity {
    private EngagementEngagedEntity(UserId userId, ServiceEngagementDateSet serviceEngagementDateSet, CurrentDateTime currentDateTime) {
        super(userId, serviceEngagementDateSet, currentDateTime);
        if(serviceEngagementDateSet.cannotEnd(currentDateTime)) {
            throw new RuntimeException("契約中でない");
        }
    }

    public EngagementEndOrder endOrder(ServiceEngagementEndOrderDate engagementEndOrderDate) {
        return new EngagementEndOrder(getUserId(), engagementEndOrderDate);
    }

    public static Validation<InvalidReason, EngagementEngagedEntity> create(UserId userId, ServiceEngagementDateSet serviceEngagementDateSet, CurrentDateTime currentDateTime) {
        if(serviceEngagementDateSet.cannotEnd(currentDateTime)) {
            return Validation.invalid(InvalidReasonString.create("契約中でない"));
        }
        return Validation.valid(new EngagementEngagedEntity(userId, serviceEngagementDateSet, currentDateTime));

    }

    public static Validation<InvalidReason, EngagementEngagedEntity> create(EngagementEntity engagementEntity) {
        return create(
                engagementEntity.getUserId(),
                engagementEntity.getServiceEngagementDateSet(),
                engagementEntity.getCurrentDateTime()
        );

    }
}
