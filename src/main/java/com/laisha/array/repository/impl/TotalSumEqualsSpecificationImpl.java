package com.laisha.array.repository.impl;

import com.laisha.array.entity.CustomArray;
import com.laisha.array.repository.CustomArraySpecification;
import com.laisha.array.service.impl.CustomIntegerArraySearchServiceImpl;

import java.util.OptionalLong;

public class TotalSumEqualsSpecificationImpl implements CustomArraySpecification {

    private static final CustomIntegerArraySearchServiceImpl searchService =
            CustomIntegerArraySearchServiceImpl.getInstance();
    private final long providedValue;

    public TotalSumEqualsSpecificationImpl(long providedValue) {
        this.providedValue = providedValue;
    }

    @Override
    public boolean specify(CustomArray customArray) {

        OptionalLong totalSum = searchService.calculateSumOfArrayElements(customArray);
        if (totalSum.isEmpty()) {
            return false;
        }
        return totalSum.getAsLong() == providedValue;
    }
}
