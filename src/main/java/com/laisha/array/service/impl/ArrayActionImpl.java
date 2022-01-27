package com.laisha.array.service.impl;

import com.laisha.array.entity.CustomIntegerArray;
import com.laisha.array.service.ArrayAction;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class ArrayActionImpl implements ArrayAction {
    //TODO add validation
    public static final Logger log = LogManager.getLogger();

    @Override
    public int findMinElement(CustomIntegerArray integerArray) {
        int[] array = integerArray.getIntegerArray();
        Arrays.sort(array);
        return array[0];
    }

    @Override
    public int findMaxElement(CustomIntegerArray integerArray) {
        int[] array = integerArray.getIntegerArray();
        Arrays.sort(array);
        return array[array.length - 1];
    }

    @Override
    public double findAverageElement(CustomIntegerArray integerArray) {
        double totalSum = .0;
        int[] array = integerArray.getIntegerArray();
        for (int element : array) {
            totalSum = totalSum + element;
        }
        return totalSum / array.length;//TODO is integerArray.getIntegerArray().length() valid?
    }

    @Override
    public int calculateSumOfArrayElements(CustomIntegerArray integerArray) {
        int totalSum = 0;
        for (int element : integerArray.getIntegerArray()) {
            totalSum = totalSum + element;
        }
        return totalSum;
    }

    @Override
    public int findQuantityOfNegativeElement(CustomIntegerArray integerArray) {
        int quantity = 0;
        for (int element : integerArray.getIntegerArray()) {
            if (element < 0) {
                quantity++;
            }
        }
        return quantity;
    }

    @Override
    public int findQuantityOfPositiveElement(CustomIntegerArray integerArray) {
        int quantity = 0;
        for (int element : integerArray.getIntegerArray()) {
            if (element < 0) {
                quantity++;
            }
        }
        return quantity;
    }
}
