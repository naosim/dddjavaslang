package com.naosim.dddjavaslang.lib.exception;

import java.util.function.Supplier;

public class ExceptionFactory {
    public static Supplier<RuntimeException> e(Class clazz) {
        return e(clazz.getSimpleName());
    }

    public static Supplier<RuntimeException> e(Object obj) {
        return () -> new RuntimeException(obj.toString());
    }
}
