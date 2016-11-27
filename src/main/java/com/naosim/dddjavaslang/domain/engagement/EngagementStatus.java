package com.naosim.dddjavaslang.domain.engagement;

import lombok.AllArgsConstructor;
import lombok.experimental.Delegate;

@AllArgsConstructor
public enum EngagementStatus {
    startOrdered(IsEngaged.notEngaged),
    startOrderCanceled(IsEngaged.notEngaged),
    engaged(IsEngaged.engaged),
    engagedAndEndOrdered(IsEngaged.engaged),
    ended(IsEngaged.notEngaged);

    @Delegate(types = _IsEngaged.class)
    private final IsEngaged isEngaged;

    private interface _IsEngaged {
        boolean isEngaged();
        boolean isNotEngaged();
    }
    enum IsEngaged implements _IsEngaged {
        engaged, notEngaged;
        public boolean isEngaged() {
            return this.equals(engaged);
        }
        public boolean isNotEngaged() {
            return !isEngaged();
        }
    }
}
