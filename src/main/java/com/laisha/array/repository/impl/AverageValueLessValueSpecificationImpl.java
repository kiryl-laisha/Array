package com.laisha.array.repository.impl;

import com.laisha.array.entity.IntegerArrayStatistics;
import com.laisha.array.entity.UserIntegerArray;
import com.laisha.array.repository.IntegerArraySpecification;
import com.laisha.array.warehouse.Warehouse;

import java.util.UUID;

public class AverageValueLessValueSpecificationImpl implements IntegerArraySpecification {

    private static final Warehouse warehouse = Warehouse.getInstance();
    private final double providedValue;

    public AverageValueLessValueSpecificationImpl(double providedValue) {
        this.providedValue = providedValue;
    }

    @Override
    public boolean specify(UserIntegerArray userIntegerArray) {

        UUID integerArrayId = userIntegerArray.getUserIntegerArrayId();
        IntegerArrayStatistics integerArrayStatistics = warehouse.get(integerArrayId);
        return (integerArrayStatistics.getAverageValue() < providedValue);
    }
}