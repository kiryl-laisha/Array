package com.laisha.array.repository.impl;

import com.laisha.array.entity.CustomArray;
import com.laisha.array.service.impl.CustomIntegerArrayStreamSearchServiceImpl;

import java.util.OptionalLong;
import java.util.function.Predicate;

public class TotalSumMorePredicate implements Predicate<CustomArray> {

    private static final CustomIntegerArrayStreamSearchServiceImpl searchService =
            CustomIntegerArrayStreamSearchServiceImpl.getInstance();
    private final long providedTotalSum;

    public TotalSumMorePredicate(long providedTotalSum) {
        this.providedTotalSum = providedTotalSum;
    }

    @Override
    public boolean test(CustomArray customArray) {

        OptionalLong optionalTotalSum = searchService.calculateSumOfArrayElements(customArray);
        if (optionalTotalSum.isEmpty()) {
            return false;
        }
        int result = Long.compare(optionalTotalSum.getAsLong(), providedTotalSum);
        return result > 0;
    }
}
