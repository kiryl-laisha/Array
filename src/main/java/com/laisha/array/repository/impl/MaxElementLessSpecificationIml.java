package com.laisha.array.repository.impl;

import com.laisha.array.entity.UserArray;
import com.laisha.array.repository.UserArraySpecification;
import com.laisha.array.service.impl.UserIntegerArraySearchServiceImpl;

import java.util.OptionalInt;

public class MaxElementLessSpecificationIml implements UserArraySpecification {

    private static final UserIntegerArraySearchServiceImpl searchService =
            UserIntegerArraySearchServiceImpl.getInstance();
    private final int providedValue;

    public MaxElementLessSpecificationIml(int providedValue) {
        this.providedValue = providedValue;
    }

    @Override
    public boolean specify(UserArray userArray) {

        OptionalInt maxElement = searchService.searchMaxElement(userArray);
        if (maxElement.isEmpty()) {
            return false;
        }
        return maxElement.getAsInt() < providedValue;
    }
}
