package com.naosim.dddjavaslang.lib.string;

import javaslang.control.Option;

import java.util.function.Supplier;

public interface Kana {
    String getValue();
    default boolean validate() {
        return getValue().matches("^[\\u30A0-\\u30FF]+$");
    }

    default void validate(Supplier<RuntimeException> exceptionSupplier) {
        Option.some("").filter(v -> validate()).getOrElseThrow(exceptionSupplier);
    }
}
