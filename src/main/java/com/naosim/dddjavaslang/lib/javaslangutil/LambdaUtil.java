package com.naosim.dddjavaslang.lib.javaslangutil;

import javaslang.control.Option;
import javaslang.control.Validation;

import java.util.function.Consumer;
import java.util.function.Function;

public class LambdaUtil {
    public static <T> boolean eqSamePath(T a, T b, Function<T, Object> path) {
        return path.apply(a).equals(path.apply(b));
    }
}
