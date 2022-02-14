package com.laisha.array.repository.impl;

import com.laisha.array.entity.CustomArray;
import com.laisha.array.repository.CustomArraySpecification;
import com.laisha.array.service.impl.CustomIntegerArraySearchServiceImpl;

import java.util.OptionalInt;

public class MaxElementMoreSpecificationImpl implements CustomArraySpecification {

    private static final CustomIntegerArraySearchServiceImpl searchService =
            CustomIntegerArraySearchServiceImpl.getInstance();
    private final int providedValue;

    public MaxElementMoreSpecificationImpl(int providedValue) {
        this.providedValue = providedValue;
    }

    @Override
    public boolean specify(CustomArray customArray) {

        OptionalInt maxElement = searchService.searchMaxElement(customArray);
        if (maxElement.isEmpty()) {
            return false;
        }
        return maxElement.getAsInt() > providedValue;
    }
}
