package com.laisha.array.comparator;

import com.laisha.array.entity.UserArray;
import com.laisha.array.service.impl.UserIntegerArrayStreamSearchServiceImpl;

import java.util.Comparator;
import java.util.OptionalLong;

public class IntegerTotalSumComparator implements Comparator<UserArray> {

    private static final UserIntegerArrayStreamSearchServiceImpl searchService =
            UserIntegerArrayStreamSearchServiceImpl.getInstance();

    @Override
    public int compare(UserArray firstUserArray, UserArray secondUserArray) {

        OptionalLong totalSum = searchService.calculateSumOfArrayElements(firstUserArray);
        long firstTotalSum;
        if (totalSum.isPresent()) {
            firstTotalSum = totalSum.getAsLong();
        } else {
            return -1;
        }
        long secondTotalSum;
        totalSum = searchService.calculateSumOfArrayElements(secondUserArray);
        if (totalSum.isPresent()) {
            secondTotalSum = totalSum.getAsLong();
        } else {
            return 1;
        }
        return Long.compare(firstTotalSum, secondTotalSum);
    }
}
