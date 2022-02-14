package com.laisha.array.comparator;

import com.laisha.array.entity.CustomArray;
import com.laisha.array.service.impl.CustomIntegerArrayStreamSearchServiceImpl;

import java.util.Comparator;
import java.util.OptionalInt;

public class IntegerMaxElementComparator implements Comparator<CustomArray> {

    private static final CustomIntegerArrayStreamSearchServiceImpl searchService =
            CustomIntegerArrayStreamSearchServiceImpl.getInstance();

    @Override
    public int compare(CustomArray firstCustomArray, CustomArray secondCustomArray) {

        OptionalInt maxElement = searchService.searchMaxElement(firstCustomArray);
        int firstMaxElement;
        if (maxElement.isPresent()) {
            firstMaxElement = maxElement.getAsInt();
        } else {
            return -1;
        }
        int secondMaxElement;
        maxElement = searchService.searchMaxElement(secondCustomArray);
        if (maxElement.isPresent()) {
            secondMaxElement = maxElement.getAsInt();
        } else {
            return 1;
        }
        return Integer.compare(firstMaxElement, secondMaxElement);
    }
}
