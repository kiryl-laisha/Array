package com.laisha.array.repository.impl;

import com.laisha.array.entity.UserArray;
import com.laisha.array.repository.UserArraySpecification;
import com.laisha.array.service.impl.UserIntegerArraySearchServiceImpl;

import java.util.OptionalDouble;

public class AverageValueMoreSpecificationImpl implements UserArraySpecification {

    private static final UserIntegerArraySearchServiceImpl searchService =
            UserIntegerArraySearchServiceImpl.getInstance();
    private final double providedValue;

    public AverageValueMoreSpecificationImpl(double providedValue) {
        this.providedValue = providedValue;
    }

    @Override
    public boolean specify(UserArray userArray) {

        OptionalDouble averageValue = searchService.calculateAverageValue(userArray);
        if (averageValue.isEmpty()) {
            return false;
        }
        int result = Double.compare(averageValue.getAsDouble(), providedValue);
        return result > 0;
    }
}
