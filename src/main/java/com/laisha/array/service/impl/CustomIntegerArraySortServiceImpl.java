package com.laisha.array.service.impl;

import com.laisha.array.entity.CustomArray;
import com.laisha.array.entity.CustomIntegerArray;
import com.laisha.array.exception.ProjectException;
import com.laisha.array.factory.impl.CustomArrayFactoryImpl;
import com.laisha.array.service.CustomArraySortService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.Optional;

public class CustomIntegerArraySortServiceImpl implements CustomArraySortService {

    private static final Logger logger = LogManager.getLogger();
    private static final CustomIntegerArraySortServiceImpl instance =
            new CustomIntegerArraySortServiceImpl();
    private static final CustomArrayFactoryImpl arrayFactory = CustomArrayFactoryImpl.getInstance();

    private CustomIntegerArraySortServiceImpl() {
    }

    public static CustomIntegerArraySortServiceImpl getInstance() {
        return instance;
    }

    @Override
    public Optional<CustomArray> sortByBubbleSorting(CustomArray customArray) {

        int[] integerArray;
        try {
            integerArray = ((CustomIntegerArray) customArray).getCustomIntegerArray();
        } catch (ProjectException e) {
            logger.log(Level.WARN, "Integer array is null. Sorting " +
                    "is not available. ", e);
            return Optional.empty();
        }
        if (integerArray.length == 0) {
            logger.log(Level.WARN, "Integer array is degenerated. Sorting " +
                    "is not available.");
            return Optional.empty();
        }
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
        CustomArray otherCustomArray = arrayFactory.createCustomArray(integerArray);
        logger.log(Level.DEBUG, "Bubble sorting completed.");
        return Optional.of(otherCustomArray);
    }

    @Override
    public Optional<CustomArray> sortBySelection(CustomArray customArray) {

        int[] integerArray;
        try {
            integerArray = ((CustomIntegerArray) customArray).getCustomIntegerArray();
        } catch (ProjectException e) {
            logger.log(Level.WARN, "Integer array is null. Sorting " +
                    "is not available. ", e);
            return Optional.empty();
        }
        if (integerArray.length == 0) {
            logger.log(Level.WARN, "Integer array is degenerated. Sorting " +
                    "is not available.");
            return Optional.empty();
        }
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
        CustomArray otherCustomArray = arrayFactory.createCustomArray(integerArray);
        logger.log(Level.DEBUG, "Selection sorting completed.");
        return Optional.of(otherCustomArray);
    }

    @Override
    public Optional<CustomArray> sortByInsertion(CustomArray customArray) {

        int[] integerArray;
        try {
            integerArray = ((CustomIntegerArray) customArray).getCustomIntegerArray();
        } catch (ProjectException e) {
            logger.log(Level.WARN, "Integer array is null. Sorting " +
                    "is not available. ", e);
            return Optional.empty();
        }
        if (integerArray.length == 0) {
            logger.log(Level.WARN, "Integer array is degenerated. Sorting " +
                    "is not available.");
            return Optional.empty();
        }
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
        CustomArray otherCustomArray = arrayFactory.createCustomArray(integerArray);
        logger.log(Level.DEBUG, "Insertion sorting completed.");
        return Optional.of(otherCustomArray);
    }

    @Override
    public Optional<CustomArray> sortByStream(CustomArray customArray) {

        int[] integerArray;
        try {
            integerArray = ((CustomIntegerArray) customArray).getCustomIntegerArray();
        } catch (ProjectException e) {
            logger.log(Level.WARN, "Integer array is null. Sorting " +
                    "is not available. ", e);
            return Optional.empty();
        }
        if (integerArray.length == 0) {
            logger.log(Level.WARN, "Integer array is degenerated. Sorting " +
                    "is not available.");
            return Optional.empty();
        }
        integerArray = Arrays.copyOf(integerArray, integerArray.length);
        integerArray = Arrays
                .stream(integerArray)
                .sorted()
                .toArray();
        CustomArray otherCustomArray = arrayFactory.createCustomArray(integerArray);
        logger.log(Level.DEBUG, "Sorting by stream completed.");
        return Optional.of(otherCustomArray);
    }
}

