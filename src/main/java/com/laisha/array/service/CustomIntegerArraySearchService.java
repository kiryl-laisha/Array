package com.laisha.array.service;

import com.laisha.array.entity.CustomArray;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;

public interface CustomIntegerArraySearchService {

    OptionalInt searchMinElement(CustomArray customArray);

    OptionalInt searchMaxElement(CustomArray customArray);

    OptionalDouble calculateAverageValue(CustomArray customArray);

    OptionalLong calculateSumOfArrayElements(CustomArray customArray);

    OptionalInt countNegativeElementQuantity(CustomArray customArray);

    OptionalInt countZeroElementQuantity(CustomArray customArray);
}

