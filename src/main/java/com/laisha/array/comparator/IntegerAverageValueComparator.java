package com.laisha.array.comparator;

import com.laisha.array.entity.CustomArray;
import com.laisha.array.service.impl.CustomIntegerArrayStreamSearchServiceImpl;

import java.util.Comparator;
import java.util.OptionalDouble;

public class IntegerAverageValueComparator implements Comparator<CustomArray> {

    private static final CustomIntegerArrayStreamSearchServiceImpl searchService =
            CustomIntegerArrayStreamSearchServiceImpl.getInstance();

    @Override
    public int compare(CustomArray firstCustomArray, CustomArray secondCustomArray) {

        OptionalDouble averageValue = searchService.calculateAverageValue(firstCustomArray);
        double firstAverageValue;
        if (averageValue.isPresent()) {
            firstAverageValue = averageValue.getAsDouble();
        } else {
            return -1;
        }
        double secondAverageValue;
        averageValue = searchService.calculateAverageValue(secondCustomArray);
        if (averageValue.isPresent()) {
            secondAverageValue = averageValue.getAsDouble();
        } else {
            return 1;
        }
        return Double.compare(firstAverageValue, secondAverageValue);
    }
}

