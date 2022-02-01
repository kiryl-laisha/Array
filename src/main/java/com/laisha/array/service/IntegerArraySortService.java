package com.laisha.array.service;

import com.laisha.array.entity.UserIntegerArray;
import com.laisha.array.exception.ProjectException;

public interface IntegerArraySortService {

    UserIntegerArray sortByBubbleSorting(UserIntegerArray userIntegerArray)
            throws ProjectException;

    UserIntegerArray sortBySelection(UserIntegerArray userIntegerArray)
            throws ProjectException;

    UserIntegerArray sortByInsertion(UserIntegerArray userIntegerArray)
            throws ProjectException;

    UserIntegerArray sortByStream(UserIntegerArray userIntegerArray)
            throws ProjectException;
}
