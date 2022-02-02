package com.laisha.array.repository.impl;

import com.laisha.array.entity.IntegerArrayStatistics;
import com.laisha.array.entity.UserIntegerArray;
import com.laisha.array.repository.IntegerArraySpecification;
import com.laisha.array.warehouse.Warehouse;

import java.util.UUID;

public class MaxElementMoreValueSpecificationImpl implements IntegerArraySpecification {

    private static final Warehouse warehouse = Warehouse.getInstance();
    private final int providedValue;

    public MaxElementMoreValueSpecificationImpl(int providedValue) {
        this.providedValue = providedValue;
    }

    @Override
    public boolean specify(UserIntegerArray userIntegerArray){

        UUID integerArrayId = userIntegerArray.getUserIntegerArrayId();
        IntegerArrayStatistics integerArrayStatistics = warehouse.get(integerArrayId);
        return (integerArrayStatistics.getMaxElement() > providedValue);
    }
}
