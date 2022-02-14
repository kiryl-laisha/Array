package com.laisha.array.repository.impl;

import com.laisha.array.entity.CustomArray;
import com.laisha.array.repository.CustomArraySpecification;
import com.laisha.array.service.impl.CustomIntegerArraySearchServiceImpl;

import java.util.OptionalDouble;

public class AverageValueMoreSpecificationImpl implements CustomArraySpecification {

    private static final CustomIntegerArraySearchServiceImpl searchService =
            CustomIntegerArraySearchServiceImpl.getInstance();
    private final double providedValue;

    public AverageValueMoreSpecificationImpl(double providedValue) {
        this.providedValue = providedValue;
    }

    @Override
    public boolean specify(CustomArray customArray) {

        OptionalDouble averageValue = searchService.calculateAverageValue(customArray);
        if (averageValue.isEmpty()) {
            return false;
        }
        int result = Double.compare(averageValue.getAsDouble(), providedValue);
        return result > 0;
    }
}
