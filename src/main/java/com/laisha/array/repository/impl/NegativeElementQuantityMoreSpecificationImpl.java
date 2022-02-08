package com.laisha.array.repository.impl;

import com.laisha.array.entity.UserArray;
import com.laisha.array.repository.UserArraySpecification;
import com.laisha.array.service.impl.UserIntegerArraySearchServiceImpl;

import java.util.OptionalInt;

public class NegativeElementQuantityMoreSpecificationImpl implements UserArraySpecification {

    private static final UserIntegerArraySearchServiceImpl searchService =
            UserIntegerArraySearchServiceImpl.getInstance();
    private final int providedValue;

    public NegativeElementQuantityMoreSpecificationImpl(int providedValue) {
        this.providedValue = providedValue;
    }

    @Override
    public boolean specify(UserArray userArray) {

        OptionalInt negativeElementQuantity =
                searchService.countNegativeElementQuantity(userArray);
        if (negativeElementQuantity.isEmpty()) {
            return false;
        }
        return negativeElementQuantity.getAsInt() > providedValue;
    }
}