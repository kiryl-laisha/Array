package com.laisha.array.comparator;

import com.laisha.array.entity.UserArray;
import com.laisha.array.service.impl.UserIntegerArrayStreamSearchServiceImpl;

import java.util.Comparator;
import java.util.OptionalDouble;

public class IntegerAverageValueComparator implements Comparator<UserArray> {

    private static final UserIntegerArrayStreamSearchServiceImpl searchService =
            UserIntegerArrayStreamSearchServiceImpl.getInstance();

    @Override
    public int compare(UserArray firstUserArray, UserArray secondUserArray) {

        OptionalDouble averageValue = searchService.calculateAverageValue(firstUserArray);
        double firstAverageValue;
        if (averageValue.isPresent()) {
            firstAverageValue = averageValue.getAsDouble();
        } else {
            return -1;
        }
        double secondAverageValue;
        averageValue = searchService.calculateAverageValue(secondUserArray);
        if (averageValue.isPresent()) {
            secondAverageValue = averageValue.getAsDouble();
        } else {
            return 1;
        }
        return Double.compare(firstAverageValue, secondAverageValue);
    }
}

