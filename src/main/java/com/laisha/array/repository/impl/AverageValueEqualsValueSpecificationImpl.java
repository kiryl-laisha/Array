package com.laisha.array.repository.impl;

import com.laisha.array.entity.IntegerArrayStatistics;
import com.laisha.array.entity.UserIntegerArray;
import com.laisha.array.repository.IntegerArraySpecification;
import com.laisha.array.warehouse.Warehouse;

import java.util.UUID;

public class AverageValueEqualsValueSpecificationImpl implements IntegerArraySpecification {

    private static final Warehouse warehouse = Warehouse.getInstance();
    private final double providedValue;

    public AverageValueEqualsValueSpecificationImpl(double providedValue) {
        this.providedValue = providedValue;
    }

    @Override
    public boolean specify(UserIntegerArray userIntegerArray) {

        UUID integerArrayId = userIntegerArray.getUserIntegerArrayId();
        IntegerArrayStatistics integerArrayStatistics = warehouse.get(integerArrayId);
        int result = Double.compare(integerArrayStatistics.getAverageValue(), providedValue);
        return result == 0;
    }
}
