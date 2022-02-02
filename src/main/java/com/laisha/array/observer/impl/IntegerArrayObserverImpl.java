package com.laisha.array.observer.impl;

import com.laisha.array.entity.IntegerArrayStatistics;
import com.laisha.array.entity.UserIntegerArray;
import com.laisha.array.exception.ProjectException;
import com.laisha.array.observer.IntegerArrayObserver;
import com.laisha.array.service.impl.IntegerArraySearchServiceImpl;
import com.laisha.array.warehouse.Warehouse;

import java.util.UUID;

public class IntegerArrayObserverImpl implements IntegerArrayObserver {

    private static final IntegerArraySearchServiceImpl searchService =
            IntegerArraySearchServiceImpl.getInstance();
    private static final Warehouse warehouse =  Warehouse.getInstance();

    @Override
    public void changeElements(UserIntegerArray userIntegerArray)
            throws ProjectException {

        int minElement;
        int maxElement;
        double averageValue;
        long totalSum;
        int negativeElementQuantity;
        int notNegativeElementQuantity;
        try {
            minElement = searchService.searchMinElement(userIntegerArray);
            maxElement = searchService.searchMaxElement(userIntegerArray);
            averageValue = searchService.calculateAverageValue(userIntegerArray);
            totalSum = searchService.calculateSumOfArrayElements(userIntegerArray);
            negativeElementQuantity =
                    searchService.countNegativeElementQuantity(userIntegerArray);
            notNegativeElementQuantity =
                    searchService.countNotNegativeElementQuantity(userIntegerArray);
        } catch (ProjectException projectException) {
            throw new ProjectException("Statistic elements definition" +
                    "is not available.", projectException);
        }
        IntegerArrayStatistics integerArrayStatistics =
                new IntegerArrayStatistics(minElement,
                                           maxElement,
                                           averageValue,
                                           totalSum,
                                           negativeElementQuantity,
                                           notNegativeElementQuantity);
        UUID integerArrayId = userIntegerArray.getUserIntegerArrayId();
        warehouse.replace(integerArrayId, integerArrayStatistics);
    }
}
