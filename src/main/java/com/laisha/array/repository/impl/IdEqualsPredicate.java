package com.laisha.array.repository.impl;

import com.laisha.array.entity.CustomArray;

import java.util.UUID;
import java.util.function.Predicate;

public class IdEqualsPredicate implements Predicate<CustomArray> {

    private final UUID providedCustomArrayId;

    public IdEqualsPredicate(UUID providedCustomArrayId) {
        this.providedCustomArrayId = providedCustomArrayId;
    }

    @Override
    public boolean test(CustomArray customArray) {

        int result = customArray.getCustomArrayId().compareTo(providedCustomArrayId);
        return result == 0;
    }
}