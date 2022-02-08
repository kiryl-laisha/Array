package com.laisha.array.service;

import com.laisha.array.entity.UserArray;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;

public interface UserIntegerArraySearchService {

    OptionalInt searchMinElement(UserArray userArray);

    OptionalInt searchMaxElement(UserArray userArray);

    OptionalDouble calculateAverageValue(UserArray userArray);

    OptionalLong calculateSumOfArrayElements(UserArray userArray);

    OptionalInt countNegativeElementQuantity(UserArray userArray);

    OptionalInt countZeroElementQuantity(UserArray userArray);
}
