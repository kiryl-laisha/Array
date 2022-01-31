package com.laisha.array.service;

import com.laisha.array.entity.UserIntegerArray;
import com.laisha.array.exception.ProjectException;

public interface IntegerArraySearchService {

    int searchMinElement(UserIntegerArray integerArray) throws ProjectException;

    int searchMaxElement(UserIntegerArray integerArray) throws ProjectException;

    double findAverageElement(UserIntegerArray integerArray);

    int calculateSumOfArrayElements(UserIntegerArray integerArray);

    int findQuantityOfNegativeElement(UserIntegerArray integerArray);

    int findQuantityOfPositiveElement(UserIntegerArray integerArray);
}
