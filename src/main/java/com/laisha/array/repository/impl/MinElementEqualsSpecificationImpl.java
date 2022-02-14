package com.laisha.array.repository.impl;

import com.laisha.array.entity.CustomArray;
import com.laisha.array.repository.CustomArraySpecification;
import com.laisha.array.service.impl.CustomIntegerArraySearchServiceImpl;

import java.util.OptionalInt;

public class MinElementEqualsSpecificationImpl implements CustomArraySpecification {

    private static final CustomIntegerArraySearchServiceImpl searchService =
            CustomIntegerArraySearchServiceImpl.getInstance();
    private final int providedValue;

    public MinElementEqualsSpecificationImpl(int providedValue) {
        this.providedValue = providedValue;
    }

    @Override
    public boolean specify(CustomArray customArray) {

        OptionalInt minElement = searchService.searchMinElement(customArray);
        if (minElement.isEmpty()) {
            return false;
        }
        return minElement.getAsInt() == providedValue;
    }
}
