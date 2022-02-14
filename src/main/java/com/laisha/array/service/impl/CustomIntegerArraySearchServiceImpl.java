package com.laisha.array.service.impl;

import com.laisha.array.entity.CustomArray;
import com.laisha.array.entity.CustomIntegerArray;
import com.laisha.array.exception.ProjectException;
import com.laisha.array.service.CustomIntegerArraySearchService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;

public class CustomIntegerArraySearchServiceImpl implements CustomIntegerArraySearchService {

    private static final Logger logger = LogManager.getLogger();
    private static final CustomIntegerArraySearchServiceImpl instance =
            new CustomIntegerArraySearchServiceImpl();

    private CustomIntegerArraySearchServiceImpl() {
    }

    public static CustomIntegerArraySearchServiceImpl getInstance() {
        return instance;
    }

    @Override
    public OptionalInt searchMinElement(CustomArray customArray) {

        int[] integerArray;
        try {
            integerArray = ((CustomIntegerArray) customArray).getCustomIntegerArray();
        } catch (ProjectException e) {
            logger.log(Level.WARN, "Integer array is null. Minimum element " +
                    "search is not possible. ", e);
            return OptionalInt.empty();
        }
        if (integerArray.length == 0) {
            logger.log(Level.WARN, "Integer array is degenerated. Minimum element " +
                    "search is not possible.");
            return OptionalInt.empty();
        }
        int minimumElement = Integer.MAX_VALUE;
        for (int element : integerArray) {
            if (element < minimumElement) {
                minimumElement = element;
            }
        }
        logger.log(Level.DEBUG, "Found minimum element = {}.", minimumElement);
        return OptionalInt.of(minimumElement);
    }

    @Override
    public OptionalInt searchMaxElement(CustomArray customArray) {

        int[] integerArray;
        try {
            integerArray = ((CustomIntegerArray) customArray).getCustomIntegerArray();
        } catch (ProjectException e) {
            logger.log(Level.WARN, "Integer array is null. Maximum element " +
                    "search is not possible. ", e);
            return OptionalInt.empty();
        }
        if (integerArray.length == 0) {
            logger.log(Level.WARN, "Integer array is degenerated. Maximum element " +
                    "search is not possible.");
            return OptionalInt.empty();
        }
        int maximumElement = Integer.MIN_VALUE;
        for (int element : integerArray) {
            if (element > maximumElement) {
                maximumElement = element;
            }
        }
        logger.log(Level.DEBUG, "Found maximum element = {}.", maximumElement);
        return OptionalInt.of(maximumElement);
    }

    @Override
    public OptionalDouble calculateAverageValue(CustomArray customArray) {

        int[] integerArray;
        try {
            integerArray = ((CustomIntegerArray) customArray).getCustomIntegerArray();
        } catch (ProjectException e) {
            logger.log(Level.WARN, "Integer array is null. Average value " +
                    "calculation is not possible. ", e);
            return OptionalDouble.empty();
        }
        if (integerArray.length == 0) {
            logger.log(Level.WARN, "Integer array is degenerated. Average value " +
                    "calculation is not possible.");
            return OptionalDouble.empty();
        }
        double totalSum = 0;
        for (int element : integerArray) {
            totalSum = totalSum + element;
        }
        double averageValue = totalSum / integerArray.length;
        logger.log(Level.DEBUG, "Calculated average value = {}.", averageValue);
        return OptionalDouble.of(averageValue);
    }

    @Override
    public OptionalLong calculateSumOfArrayElements(CustomArray customArray) {

        int[] integerArray;
        try {
            integerArray = ((CustomIntegerArray) customArray).getCustomIntegerArray();
        } catch (ProjectException e) {
            logger.log(Level.WARN, "Integer array is null. Total sum " +
                    "calculation is not possible. ", e);
            return OptionalLong.empty();
        }
        if (integerArray.length == 0) {
            logger.log(Level.WARN, "Integer array is degenerated. Total sum " +
                    "calculation is not possible.");
            return OptionalLong.empty();
        }
        long totalSum = 0;
        for (int element : integerArray) {
            totalSum = totalSum + element;
        }
        logger.log(Level.DEBUG, "Calculated total sum = {}.", totalSum);
        return OptionalLong.of(totalSum);
    }

    @Override
    public OptionalInt countNegativeElementQuantity(CustomArray customArray) {

        int[] integerArray;
        try {
            integerArray = ((CustomIntegerArray) customArray).getCustomIntegerArray();
        } catch (ProjectException e) {
            logger.log(Level.WARN, "Integer array is null. Negative element " +
                    "count is not possible. ", e);
            return OptionalInt.empty();
        }
        if (integerArray.length == 0) {
            logger.log(Level.WARN, "Integer array is degenerated. Negative element " +
                    "count is not possible.");
            return OptionalInt.empty();
        }
        int elementQuantity = 0;
        for (int element : integerArray) {
            if (element < 0) {
                elementQuantity++;
            }
        }
        logger.log(Level.DEBUG, "Counted quantity of negative " +
                "array elements = {}.", elementQuantity);
        return OptionalInt.of(elementQuantity);
    }

    @Override
    public OptionalInt countZeroElementQuantity(CustomArray customArray) {

        int[] integerArray;
        try {
            integerArray = ((CustomIntegerArray) customArray).getCustomIntegerArray();
        } catch (ProjectException e) {
            logger.log(Level.WARN, "Integer array is null. Zero element " +
                    "count is not possible. ", e);
            return OptionalInt.empty();
        }
        if (integerArray.length == 0) {
            logger.log(Level.WARN, "Integer array is degenerated. Zero element " +
                    "count is not possible.");
            return OptionalInt.empty();
        }
        int elementQuantity = 0;
        for (int element : integerArray) {
            if (element == 0) {
                elementQuantity++;
            }
        }
        logger.log(Level.DEBUG, "Counted quantity of zero " +
                "array elements = {}.", elementQuantity);
        return OptionalInt.of(elementQuantity);
    }
}

