package com.laisha.array.comparator;

import com.laisha.array.entity.CustomArray;
import com.laisha.array.service.impl.CustomIntegerArrayStreamSearchServiceImpl;

import java.util.Comparator;
import java.util.OptionalInt;

public class IntegerMinElementComparator implements Comparator<CustomArray> {

    private static final CustomIntegerArrayStreamSearchServiceImpl searchService =
            CustomIntegerArrayStreamSearchServiceImpl.getInstance();

    @Override
    public int compare(CustomArray firstCustomArray, CustomArray secondCustomArray) {

        OptionalInt minElement = searchService.searchMinElement(firstCustomArray);
        int firstMinElement;
        if (minElement.isPresent()) {
            firstMinElement = minElement.getAsInt();
        } else {
            return -1;
        }
        int secondMinElement;
        minElement = searchService.searchMinElement(secondCustomArray);
        if (minElement.isPresent()) {
            secondMinElement = minElement.getAsInt();
        } else {
            return 1;
        }
        return Integer.compare(firstMinElement, secondMinElement);
    }
}

