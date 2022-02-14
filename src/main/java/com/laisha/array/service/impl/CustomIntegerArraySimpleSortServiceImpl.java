package com.laisha.array.service.impl;

import com.laisha.array.entity.CustomArray;
import com.laisha.array.entity.CustomIntegerArray;
import com.laisha.array.exception.ProjectException;
import com.laisha.array.service.CustomArraySimpleSortService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class CustomIntegerArraySimpleSortServiceImpl implements CustomArraySimpleSortService {

    private static final Logger logger = LogManager.getLogger();
    private static final CustomIntegerArraySimpleSortServiceImpl instance =
            new CustomIntegerArraySimpleSortServiceImpl();

    private CustomIntegerArraySimpleSortServiceImpl() {
    }

    public static CustomIntegerArraySimpleSortServiceImpl getInstance() {
        return instance;
    }

    @Override
    public void sortByBubbleSorting(CustomArray customArray) throws ProjectException {

        int[] integerArray = ((CustomIntegerArray) customArray).getCustomIntegerArray();
        int buffer;
        for (int i = 0; i < integerArray.length - 1; i++) {
            for (int j = i + 1; j < integerArray.length; j++) {
                if (integerArray[j] < integerArray[i]) {
                    buffer = integerArray[i];
                    integerArray[i] = integerArray[j];
                    integerArray[j] = buffer;
                }
            }
        }
        ((CustomIntegerArray) customArray).setCustomIntegerArray(integerArray);
        logger.log(Level.DEBUG, "Bubble sorting completed.");
    }

    @Override
    public void sortBySelection(CustomArray customArray) throws ProjectException {

        int[] integerArray = ((CustomIntegerArray) customArray).getCustomIntegerArray();
        int buffer;
        int minElementIndex;
        for (int i = 0; i < integerArray.length - 1; i++) {
            minElementIndex = i;
            for (int j = i + 1; j < integerArray.length; j++) {
                if (integerArray[j] < integerArray[minElementIndex]) {
                    minElementIndex = j;
                }
                if (minElementIndex > i) {
                    buffer = integerArray[i];
                    integerArray[i] = integerArray[minElementIndex];
                    integerArray[minElementIndex] = buffer;
                }
            }
        }
        ((CustomIntegerArray) customArray).setCustomIntegerArray(integerArray);
        logger.log(Level.DEBUG, "Selection sorting completed.");
    }

    @Override
    public void sortByInsertion(CustomArray customArray) throws ProjectException {

        int[] integerArray = ((CustomIntegerArray) customArray).getCustomIntegerArray();
        int minElementIndex;
        for (int i = 0; i < integerArray.length; i++) {
            minElementIndex = i;
            for (int j = i; j >= 0; j--) {
                if (integerArray[j] > integerArray[i]) {
                    minElementIndex = j;
                }
            }
            if (minElementIndex < i) {
                int buffer = integerArray[i];
                for (int k = i; k > minElementIndex; k--) {
                    integerArray[k] = integerArray[k - 1];
                }
                integerArray[minElementIndex] = buffer;
            }
        }
        ((CustomIntegerArray) customArray).setCustomIntegerArray(integerArray);
        logger.log(Level.DEBUG, "Insertion sorting completed.");
    }

    @Override
    public void sortByStream(CustomArray customArray) throws ProjectException {

        int[] integerArray = ((CustomIntegerArray) customArray).getCustomIntegerArray();
        integerArray = Arrays
                .stream(integerArray)
                .sorted()
                .toArray();
        ((CustomIntegerArray) customArray).setCustomIntegerArray(integerArray);
        logger.log(Level.DEBUG, "Sorting by stream completed.");
    }
}
