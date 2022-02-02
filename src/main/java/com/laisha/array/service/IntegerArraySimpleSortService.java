package com.laisha.array.service;

import com.laisha.array.entity.UserIntegerArray;
import com.laisha.array.exception.ProjectException;

public interface IntegerArraySimpleSortService {

    void sortByBubbleSorting(UserIntegerArray userIntegerArray)
            throws ProjectException;

    void sortBySelection(UserIntegerArray userIntegerArray)
            throws ProjectException;

    void sortByInsertion(UserIntegerArray userIntegerArray)
            throws ProjectException;

    void sortByStream(UserIntegerArray userIntegerArray)
            throws ProjectException;
}
