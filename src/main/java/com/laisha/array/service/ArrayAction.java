package com.laisha.array.service;

import com.laisha.array.entity.CustomIntegerArray;

public interface ArrayAction {

    int findMinElement(CustomIntegerArray integerArray);

    int findMaxElement(CustomIntegerArray integerArray);

    double findAverageElement(CustomIntegerArray integerArray);

    int calculateSumOfArrayElements(CustomIntegerArray integerArray);

    int findQuantityOfNegativeElement(CustomIntegerArray integerArray);

    int findQuantityOfPositiveElement(CustomIntegerArray integerArray);
}
