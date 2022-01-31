package com.laisha.array.service.impl;

import com.laisha.array.entity.UserIntegerArray;
import com.laisha.array.exception.ProjectException;
import com.laisha.array.service.IntegerArraySearchService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class IntegerArraySearchServiceImpl implements IntegerArraySearchService {
    //TODO add validation
    private static final Logger logger = LogManager.getLogger();

    @Override
    public int searchMinElement(UserIntegerArray integerArray) throws ProjectException {


        int[] array = integerArray.getUserIntegerArray();
        Arrays.sort(array);
        return array[0];
    }

    @Override
    public int searchMaxElement(UserIntegerArray integerArray)  throws ProjectException{
        int[] array = integerArray.getUserIntegerArray();
        Arrays.sort(array);
        return array[array.length - 1];
    }

    @Override
    public double findAverageElement(UserIntegerArray integerArray) {
        double totalSum = .0;
        int[] array = integerArray.getUserIntegerArray();
        for (int element : array) {
            totalSum = totalSum + element;
        }
        return totalSum / array.length;//TODO is integerArray.getIntegerArray().length() valid?
    }

    @Override
    public int calculateSumOfArrayElements(UserIntegerArray integerArray) {
        int totalSum = 0;
        for (int element : integerArray.getUserIntegerArray()) {
            totalSum = totalSum + element;
        }
        return totalSum;
    }

    @Override
    public int findQuantityOfNegativeElement(UserIntegerArray integerArray) {
        int quantity = 0;
        for (int element : integerArray.getUserIntegerArray()) {
            if (element < 0) {
                quantity++;
            }
        }
        return quantity;
    }

    @Override
    public int findQuantityOfPositiveElement(UserIntegerArray integerArray) {
        int quantity = 0;
        for (int element : integerArray.getUserIntegerArray()) {
            if (element < 0) {
                quantity++;
            }
        }
        return quantity;
    }
}
