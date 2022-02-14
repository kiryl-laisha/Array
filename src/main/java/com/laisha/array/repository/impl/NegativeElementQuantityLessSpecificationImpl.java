package com.laisha.array.repository.impl;

import com.laisha.array.entity.CustomArray;
import com.laisha.array.repository.CustomArraySpecification;
import com.laisha.array.service.impl.CustomIntegerArraySearchServiceImpl;

import java.util.OptionalInt;

public class NegativeElementQuantityLessSpecificationImpl implements CustomArraySpecification {

    private static final CustomIntegerArraySearchServiceImpl searchService =
            CustomIntegerArraySearchServiceImpl.getInstance();
    private final int providedValue;

    public NegativeElementQuantityLessSpecificationImpl(int providedValue) {
        this.providedValue = providedValue;
    }

    @Override
    public boolean specify(CustomArray customArray) {

        OptionalInt negativeElementQuantity =
                searchService.countNegativeElementQuantity(customArray);
        if (negativeElementQuantity.isEmpty()) {
            return false;
        }
        return negativeElementQuantity.getAsInt() < providedValue;
    }
}
