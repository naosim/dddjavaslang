package com.naosim.dddjavaslang.lib.valid;

import lombok.AllArgsConstructor;

import java.util.function.Consumer;

public interface InvalidReason {
    String getMessage();

    Consumer<InvalidReason> throwAction =  (v) -> {
        throw new RuntimeException();
    };
}
