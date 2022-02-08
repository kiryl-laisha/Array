package com.laisha.array.comparator;

import com.laisha.array.entity.UserArray;
import com.laisha.array.service.impl.UserIntegerArrayStreamSearchServiceImpl;

import java.util.Comparator;
import java.util.OptionalInt;

public class IntegerMaxElementComparator implements Comparator<UserArray> {

    private static final UserIntegerArrayStreamSearchServiceImpl searchService =
            UserIntegerArrayStreamSearchServiceImpl.getInstance();

    @Override
    public int compare(UserArray firstUserArray, UserArray secondUserArray) {

        OptionalInt maxElement = searchService.searchMaxElement(firstUserArray);
        int firstMaxElement;
        if (maxElement.isPresent()) {
            firstMaxElement = maxElement.getAsInt();
        } else {
            return -1;
        }
        int secondMaxElement;
        maxElement = searchService.searchMaxElement(secondUserArray);
        if (maxElement.isPresent()) {
            secondMaxElement = maxElement.getAsInt();
        } else {
            return 1;
        }
        return Integer.compare(firstMaxElement, secondMaxElement);
    }
}
