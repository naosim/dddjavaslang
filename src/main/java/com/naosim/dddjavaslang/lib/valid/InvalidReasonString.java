package com.naosim.dddjavaslang.lib.valid;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class InvalidReasonString implements InvalidReason {
    @Getter
    private final String message;

    public static InvalidReason create(String message) {
        return new InvalidReasonString(message);
    }
}
