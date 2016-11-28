package com.naosim.dddjavaslang.datasource.engagement;

import com.naosim.dddjavaslang.domain.account.UserId;
import com.naosim.dddjavaslang.domain.engagement.*;
import com.naosim.dddjavaslang.lib.date.CurrentDateTime;
import com.naosim.dddjavaslang.lib.javaslangutil.JavaslangUtil;
import com.naosim.dddjavaslang.lib.valid.InvalidReason;
import com.naosim.dddjavaslang.lib.valid.InvalidReasonString;
import javaslang.collection.HashSet;
import javaslang.collection.Set;
import javaslang.control.Validation;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
@Component
public class EngagementRepositoryOnMemory implements EngagementRepository {
    private Set<EngagementStartOrder> engagementStartOrderTable = HashSet.empty();
    private Set<EngagementEndOrder> engagementEndOrderTable = HashSet.empty();
    private Set<EngagementCancelStartOrder> engagementCancelStartOrderTable = HashSet.empty();

    @Override
    public void startOrder(EngagementStartOrder engagementStartOrder) {
        engagementStartOrderTable = engagementStartOrderTable.add(engagementStartOrder);
    }

    @Override
    public void cancelStartOrder(EngagementCancelStartOrder engagementCancelStartOrder) {
        engagementCancelStartOrderTable = engagementCancelStartOrderTable.add(engagementCancelStartOrder);
    }

    @Override
    public void endOrder(EngagementEndOrder engagementEndOrder) {
        engagementEndOrderTable = engagementEndOrderTable.add(engagementEndOrder);
    }

    public Validation<InvalidReason, EngagementEntity> find(UserId userId) {
        CurrentDateTime currentDateTime = new CurrentDateTime(LocalDateTime.now());
        return JavaslangUtil.toValidation(
                engagementStartOrderTable.find(v -> v.getUserId().getValue().equals(userId.getValue())),
                () -> InvalidReasonString.create("契約申込がない")
        )
                .map(startOrder -> EngagementEntity.createFromStartOrder(startOrder, currentDateTime));
    }

    @Override
    public Validation<InvalidReason, EngagementEngagedEntity> findEngaged(UserId userId) {
        return find(userId).flatMap(EngagementEngagedEntity::create);
    }

    @Override
    public Validation<InvalidReason, EngagementBeforeEngageEntity> findBeforeEngage(UserId userId) {
        return find(userId).flatMap(EngagementBeforeEngageEntity::create);
    }
}
