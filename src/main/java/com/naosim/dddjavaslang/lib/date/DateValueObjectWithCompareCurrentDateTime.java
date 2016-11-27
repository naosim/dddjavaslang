package com.naosim.dddjavaslang.lib.date;

import java.time.LocalDate;

public interface DateValueObjectWithCompareCurrentDateTime {
    LocalDate getValue();
    default boolean isBefore(CurrentDateTime currentDateTime) {
        return getValue().isBefore(currentDateTime.getValue().toLocalDate());
    }
    default boolean isAfter(CurrentDateTime currentDateTime) {
        return getValue().isAfter(currentDateTime.getValue().toLocalDate());
    }
    default boolean isEqual(CurrentDateTime currentDateTime) {
        return getValue().isEqual(currentDateTime.getValue().toLocalDate());
    }
    default boolean isFuture(CurrentDateTime currentDateTime) {
        return isAfter(currentDateTime);
    }
    default boolean isNotFuture(CurrentDateTime currentDateTime) {
        return !isFuture(currentDateTime);
    }
}
