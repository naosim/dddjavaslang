package com.naosim.dddjavaslang.domain.engagement;

import com.naosim.dddjavaslang.domain.account.UserId;
import com.naosim.dddjavaslang.domain.engagement.engagementdate.EngagementDateSet;
import com.naosim.dddjavaslang.domain.engagement.engagementdate.EngagementEndDate;
import com.naosim.dddjavaslang.domain.engagement.engagementdate.EngagementEndOrderDate;
import com.naosim.dddjavaslang.lib.date.CurrentDateTime;
import com.naosim.dddjavaslang.lib.valid.InvalidReason;
import com.naosim.dddjavaslang.lib.valid.InvalidReasonString;
import javaslang.control.Option;
import javaslang.control.Validation;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalDateTime;

/**
 * 契約中の契約エンティティ
 */
@EqualsAndHashCode
public class EngagementEngagedEntity extends EngagementEntity {
    private EngagementEngagedEntity(UserId userId, EngagementDateSet engagementDateSet, CurrentDateTime currentDateTime) {
        super(userId, engagementDateSet, currentDateTime);
        if(getEngagementStatus().isNotEngaged()) {
            throw new RuntimeException("契約中でない");
        }
    }

    public EngagementEndOrder endOrder(EngagementEndOrderDate engagementEndOrderDate) {
        return new EngagementEndOrder(getUserId(), engagementEndOrderDate, EngagementEndDate.create(engagementEndOrderDate));
    }

    public static Validation<InvalidReason, EngagementEngagedEntity> create(UserId userId, EngagementDateSet engagementDateSet, CurrentDateTime currentDateTime) {
        if(engagementDateSet.createEngagementStatus(currentDateTime).isNotEngaged()) {
            return Validation.invalid(InvalidReasonString.create("契約中でない"));
        }
        return Validation.valid(new EngagementEngagedEntity(userId, engagementDateSet, currentDateTime));

    }

    public static Validation<InvalidReason, EngagementEngagedEntity> create(EngagementEntity engagementEntity) {
        return create(
                engagementEntity.getUserId(),
                engagementEntity.getEngagementDateSet(),
                engagementEntity.getCurrentDateTime()
        );

    }
}
