package com.laisha.array.repository.impl;

import com.laisha.array.entity.UserArray;
import com.laisha.array.repository.UserArraySpecification;
import com.laisha.array.service.impl.UserIntegerArraySearchServiceImpl;

import java.util.OptionalInt;

public class ZeroElementQuantityMoreSpecificationImpl implements UserArraySpecification {

    private static final UserIntegerArraySearchServiceImpl searchService =
            UserIntegerArraySearchServiceImpl.getInstance();
    private final int providedValue;

    public ZeroElementQuantityMoreSpecificationImpl(int providedValue) {
        this.providedValue = providedValue;
    }

    @Override
    public boolean specify(UserArray userArray) {

        OptionalInt zeroElementQuantity =
                searchService.countZeroElementQuantity(userArray);
        if (zeroElementQuantity.isEmpty()) {
            return false;
        }
        return zeroElementQuantity.getAsInt() > providedValue;
    }
}
