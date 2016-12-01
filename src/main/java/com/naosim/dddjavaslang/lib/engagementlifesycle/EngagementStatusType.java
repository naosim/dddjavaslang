package com.naosim.dddjavaslang.lib.engagementlifesycle;

import lombok.AllArgsConstructor;
import lombok.experimental.Delegate;

/**
 * 契約状態
 */
@AllArgsConstructor
public enum EngagementStatusType implements EngagementStatus {
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
