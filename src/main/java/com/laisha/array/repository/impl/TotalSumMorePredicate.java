package com.laisha.array.repository.impl;

import com.laisha.array.entity.UserArray;
import com.laisha.array.service.impl.UserIntegerArrayStreamSearchServiceImpl;

import java.util.OptionalLong;
import java.util.function.Predicate;

public class TotalSumMorePredicate implements Predicate<UserArray> {

    private static final UserIntegerArrayStreamSearchServiceImpl searchService =
            UserIntegerArrayStreamSearchServiceImpl.getInstance();
    private final long providedTotalSum;

    public TotalSumMorePredicate(long providedTotalSum) {
        this.providedTotalSum = providedTotalSum;
    }

    @Override
    public boolean test(UserArray userArray) {

        OptionalLong optionalTotalSum = searchService.calculateSumOfArrayElements(userArray);
        if (optionalTotalSum.isEmpty()) {
            return false;
        }
        int result = Long.compare(optionalTotalSum.getAsLong(), providedTotalSum);
        return result > 0;
    }
}
