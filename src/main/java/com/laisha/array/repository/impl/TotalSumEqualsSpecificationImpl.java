package com.laisha.array.repository.impl;

import com.laisha.array.entity.UserArray;
import com.laisha.array.repository.UserArraySpecification;
import com.laisha.array.service.impl.UserIntegerArraySearchServiceImpl;

import java.util.OptionalLong;

public class TotalSumEqualsSpecificationImpl implements UserArraySpecification {

    private static final UserIntegerArraySearchServiceImpl searchService =
            UserIntegerArraySearchServiceImpl.getInstance();
    private final long providedValue;

    public TotalSumEqualsSpecificationImpl(long providedValue) {
        this.providedValue = providedValue;
    }

    @Override
    public boolean specify(UserArray userArray) {

        OptionalLong totalSum = searchService.calculateSumOfArrayElements(userArray);
        if (totalSum.isEmpty()) {
            return false;
        }
        return totalSum.getAsLong() == providedValue;
    }
}
