package com.laisha.array.comparator;

import com.laisha.array.entity.UserArray;
import com.laisha.array.service.impl.UserIntegerArrayStreamSearchServiceImpl;

import java.util.Comparator;
import java.util.OptionalInt;

public class IntegerMinElementComparator implements Comparator<UserArray> {

    private static final UserIntegerArrayStreamSearchServiceImpl searchService =
            UserIntegerArrayStreamSearchServiceImpl.getInstance();

    @Override
    public int compare(UserArray firstUserArray, UserArray secondUserArray) {

        OptionalInt minElement = searchService.searchMinElement(firstUserArray);
        int firstMinElement;
        if (minElement.isPresent()) {
            firstMinElement = minElement.getAsInt();
        } else {
            return -1;
        }
        int secondMinElement;
        minElement = searchService.searchMinElement(secondUserArray);
        if (minElement.isPresent()) {
            secondMinElement = minElement.getAsInt();
        } else {
            return 1;
        }
        return Integer.compare(firstMinElement, secondMinElement);
    }
}

