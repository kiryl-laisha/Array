package com.laisha.array.service.impl;

import com.laisha.array.entity.UserIntegerArray;
import com.laisha.array.exception.ProjectException;
import com.laisha.array.factory.impl.ArrayFactoryImpl;
import com.laisha.array.service.IntegerArraySortService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class IntegerArraySortServiceImpl implements IntegerArraySortService {

    private static final Logger logger = LogManager.getLogger();
    private static final IntegerArraySortServiceImpl instance =
            new IntegerArraySortServiceImpl();
    private static final ArrayFactoryImpl arrayFactory = ArrayFactoryImpl.getInstance();

    private IntegerArraySortServiceImpl() {
    }

    public static IntegerArraySortServiceImpl getInstance() {

        return instance;
    }

    @Override
    public UserIntegerArray sortByBubbleSorting(UserIntegerArray userIntegerArray)
            throws ProjectException {

        int[] integerArray = getIntegerArrayWithCheckByNullAndEmpty(userIntegerArray);
        integerArray = Arrays.copyOf(integerArray, integerArray.length);
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
        UserIntegerArray userIntegerArray1 =
                arrayFactory.createUserIntegerArray(integerArray);
        logger.log(Level.DEBUG, "Bubble sorting completed.");
        return userIntegerArray1;
    }

    @Override
    public UserIntegerArray sortBySelection(UserIntegerArray userIntegerArray)
            throws ProjectException {

        int[] integerArray = getIntegerArrayWithCheckByNullAndEmpty(userIntegerArray);
        integerArray = Arrays.copyOf(integerArray, integerArray.length);
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
        UserIntegerArray userIntegerArray1 =
                arrayFactory.createUserIntegerArray(integerArray);
        logger.log(Level.DEBUG, "Selection sorting completed.");
        return userIntegerArray1;
    }

    @Override
    public UserIntegerArray sortByInsertion(UserIntegerArray userIntegerArray)
            throws ProjectException {

        int[] integerArray = getIntegerArrayWithCheckByNullAndEmpty(userIntegerArray);
        integerArray = Arrays.copyOf(integerArray, integerArray.length);
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
        UserIntegerArray userIntegerArray1 =
                arrayFactory.createUserIntegerArray(integerArray);
        logger.log(Level.DEBUG, "Insertion sorting completed.");
        return userIntegerArray1;
    }
    @Override
    public UserIntegerArray sortByStream(UserIntegerArray userIntegerArray)
            throws ProjectException {

        int[] integerArray = getIntegerArrayWithCheckByNullAndEmpty(userIntegerArray);
        integerArray = Arrays.copyOf(integerArray, integerArray.length);
        integerArray = Arrays
                .stream(integerArray)
                .sorted()
                .toArray();
        UserIntegerArray userIntegerArray1 =
                arrayFactory.createUserIntegerArray(integerArray);
        logger.log(Level.DEBUG, "Sorting by stream completed.");
        return userIntegerArray1;
    }

    private int[] getIntegerArrayWithCheckByNullAndEmpty(UserIntegerArray userIntegerArray)
            throws ProjectException {

        int[] integerArray;
        try {
            integerArray = userIntegerArray.getUserIntegerArray();
        } catch (NullPointerException nullPointerException) {
            throw new ProjectException("Integer array of this object is not" +
                    "initialized. Method execution is not available.",
                    nullPointerException);
        }
        if (integerArray.length == 0) {
            throw new ProjectException("Integer array is degenerated. " +
                    "Method execution is not available.");
        }
        return integerArray;
    }
}

