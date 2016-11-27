package com.naosim.dddjavaslang.lib.javaslangutil;

import javaslang.control.Option;
import javaslang.control.Validation;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class JavaslangUtil {
    public static <E, T> Validation<E, T> validate(T org, Predicate<T> filter, Function<T, E> error) {
        return filter.test(org) ? Validation.valid(org) : Validation.invalid(error.apply(org));
    }

    public static <E, T> Validation<E, T> validate(T org, Predicate<T> filter, Supplier<E> error) {
        return validate(org, filter, v -> error.get());
    }

    public static <E, T> Option<E> invalidOptional(Validation<E, T> org) {
        return org.toEither().left().map(v -> Option.some(v)).getOrElse(Option.none());
    }

    public static <T> Function<T, T> f(Consumer<T> action) {
        return (v) -> {
            action.accept(v);
            return v;
        };
    }

    public static <E, T> Validation<E, T> toValidation(Option<T> org, Supplier<E> error) {
        return org.isDefined() ? Validation.valid(org.get()) : Validation.invalid(error.get());
    }
}
