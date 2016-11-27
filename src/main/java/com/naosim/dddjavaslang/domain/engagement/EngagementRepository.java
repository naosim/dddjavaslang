package com.naosim.dddjavaslang.domain.engagement;

import com.naosim.dddjavaslang.domain.account.UserId;
import com.naosim.dddjavaslang.lib.valid.InvalidReason;
import javaslang.control.Validation;

public interface EngagementRepository {
    void order(EngagementStartOrder engagementStartOrder);
    void endOrder(EngagementEndOrder engagementEndOrder);
    Validation<InvalidReason, EngagementEngagedEntity> findEngaged(UserId userId);
}
