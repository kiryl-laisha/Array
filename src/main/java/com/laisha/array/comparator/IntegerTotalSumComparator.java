package com.laisha.array.comparator;

import com.laisha.array.entity.CustomArray;
import com.laisha.array.service.impl.CustomIntegerArrayStreamSearchServiceImpl;

import java.util.Comparator;
import java.util.OptionalLong;

public class IntegerTotalSumComparator implements Comparator<CustomArray> {

    private static final CustomIntegerArrayStreamSearchServiceImpl searchService =
            CustomIntegerArrayStreamSearchServiceImpl.getInstance();

    @Override
    public int compare(CustomArray firstCustomArray, CustomArray secondCustomArray) {

        OptionalLong totalSum = searchService.calculateSumOfArrayElements(firstCustomArray);
        long firstTotalSum;
        if (totalSum.isPresent()) {
            firstTotalSum = totalSum.getAsLong();
        } else {
            return -1;
        }
        long secondTotalSum;
        totalSum = searchService.calculateSumOfArrayElements(secondCustomArray);
        if (totalSum.isPresent()) {
            secondTotalSum = totalSum.getAsLong();
        } else {
            return 1;
        }
        return Long.compare(firstTotalSum, secondTotalSum);
    }
}
