package com.laisha.array.service;

import com.laisha.array.entity.UserIntegerArray;
import com.laisha.array.exception.ProjectException;

public interface IntegerArraySearchService {

    int searchMinElement(UserIntegerArray integerArray)
            throws ProjectException;

    int searchMaxElement(UserIntegerArray integerArray)
            throws ProjectException;

    double calculateAverageValue(UserIntegerArray integerArray)
            throws ProjectException;

    long calculateSumOfArrayElements(UserIntegerArray integerArray)
            throws ProjectException;

    int countNegativeElementQuantity(UserIntegerArray integerArray)
            throws ProjectException;

    int countNotNegativeElementQuantity(UserIntegerArray integerArray)
            throws ProjectException;
}
