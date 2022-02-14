package com.laisha.array.repository.impl;

import com.laisha.array.entity.CustomArray;
import com.laisha.array.repository.CustomArraySpecification;
import com.laisha.array.service.impl.CustomIntegerArraySearchServiceImpl;

import java.util.OptionalInt;

public class ZeroElementQuantityEqualsSpecificationImpl implements CustomArraySpecification {

    private static final CustomIntegerArraySearchServiceImpl searchService =
            CustomIntegerArraySearchServiceImpl.getInstance();
    private final int providedValue;

    public ZeroElementQuantityEqualsSpecificationImpl(int providedValue) {
        this.providedValue = providedValue;
    }

    @Override
    public boolean specify(CustomArray customArray) {

        OptionalInt zeroElementQuantity =
                searchService.countZeroElementQuantity(customArray);
        if (zeroElementQuantity.isEmpty()) {
            return false;
        }
        return zeroElementQuantity.getAsInt() == providedValue;
    }
}

