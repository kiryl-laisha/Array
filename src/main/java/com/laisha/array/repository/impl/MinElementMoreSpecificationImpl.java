package com.laisha.array.repository.impl;

import com.laisha.array.entity.UserArray;
import com.laisha.array.repository.UserArraySpecification;
import com.laisha.array.service.impl.UserIntegerArraySearchServiceImpl;

import java.util.OptionalInt;

public class MinElementMoreSpecificationImpl implements UserArraySpecification {

    private static final UserIntegerArraySearchServiceImpl searchService =
            UserIntegerArraySearchServiceImpl.getInstance();
    private final int providedValue;

    public MinElementMoreSpecificationImpl(int providedValue) {
        this.providedValue = providedValue;
    }

    @Override
    public boolean specify(UserArray userArray) {

        OptionalInt minElement = searchService.searchMinElement(userArray);
        if (minElement.isEmpty()) {
            return false;
        }
        return minElement.getAsInt() > providedValue;
    }
}