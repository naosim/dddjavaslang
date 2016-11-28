package com.naosim.dddjavaslang.domain.engagement;

import com.naosim.dddjavaslang.domain.account.UserId;
import com.naosim.dddjavaslang.domain.engagement.engagementdate.EngagementDateSet;
import com.naosim.dddjavaslang.domain.engagement.engagementdate.EngagementEndDate;
import com.naosim.dddjavaslang.domain.engagement.engagementdate.EngagementEndOrderDate;
import com.naosim.dddjavaslang.domain.engagement.engagementdate.EngagementStartCancelOrderDate;
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
    private EngagementBeforeEngageEntity(UserId userId, EngagementDateSet engagementDateSet, CurrentDateTime currentDateTime) {
        super(userId, engagementDateSet, currentDateTime);
        if(!engagementDateSet.createEngagementStatus(currentDateTime).equals(EngagementStatus.startOrdered)) {
            throw new RuntimeException("契約申込状態でない");
        }
    }

    public EngagementCancelStartOrder cancelStartOrder(EngagementStartCancelOrderDate engagementStartCancelOrderDate) {
        return new EngagementCancelStartOrder(getUserId(), engagementStartCancelOrderDate);
    }

    public static Validation<InvalidReason, EngagementBeforeEngageEntity> create(UserId userId, EngagementDateSet engagementDateSet, CurrentDateTime currentDateTime) {
        if(!engagementDateSet.createEngagementStatus(currentDateTime).equals(EngagementStatus.startOrdered)) {
            return Validation.invalid(InvalidReasonString.create("契約申込状態でない"));
        }
        return Validation.valid(new EngagementBeforeEngageEntity(userId, engagementDateSet, currentDateTime));

    }

    public static Validation<InvalidReason, EngagementBeforeEngageEntity> create(EngagementEntity engagementEntity) {
        return create(
                engagementEntity.getUserId(),
                engagementEntity.getEngagementDateSet(),
                engagementEntity.getCurrentDateTime()
        );

    }
}
