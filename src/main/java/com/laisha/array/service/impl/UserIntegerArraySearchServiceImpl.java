package com.laisha.array.service.impl;

import com.laisha.array.entity.UserArray;
import com.laisha.array.entity.UserIntegerArray;
import com.laisha.array.exception.ProjectException;
import com.laisha.array.service.UserIntegerArraySearchService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;

public class UserIntegerArraySearchServiceImpl implements UserIntegerArraySearchService {

    private static final Logger logger = LogManager.getLogger();
    private static final UserIntegerArraySearchServiceImpl instance =
            new UserIntegerArraySearchServiceImpl();

    private UserIntegerArraySearchServiceImpl() {
    }

    public static UserIntegerArraySearchServiceImpl getInstance() {
        return instance;
    }

    @Override
    public OptionalInt searchMinElement(UserArray userArray) {

        int[] integerArray;
        try {
            integerArray = getCheckedIntegerArray(userArray);
        } catch (ProjectException e) {
            logger.log(Level.WARN, "Integer array is null or degenerated. " +
                    "Minimum element search is not possible. ", e);
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
    public OptionalInt searchMaxElement(UserArray userArray) {

        int[] integerArray;
        try {
            integerArray = getCheckedIntegerArray(userArray);
        } catch (ProjectException e) {
            logger.log(Level.WARN, "Integer array is null or degenerated. " +
                    "Maximum element search is not possible. ", e);
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
    public OptionalDouble calculateAverageValue(UserArray userArray) {

        int[] integerArray;
        try {
            integerArray = getCheckedIntegerArray(userArray);
        } catch (ProjectException e) {
            logger.log(Level.WARN, "Integer array is null or degenerated." +
                    " Average value calculation is not possible. ", e);
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
    public OptionalLong calculateSumOfArrayElements(UserArray userArray) {

        int[] integerArray;
        try {
            integerArray = getCheckedIntegerArray(userArray);
        } catch (ProjectException e) {
            logger.log(Level.WARN, "Integer array is null or degenerated." +
                    " Total sum calculation is not possible. ", e);
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
    public OptionalInt countNegativeElementQuantity(UserArray userArray) {

        int[] integerArray;
        try {
            integerArray = getCheckedIntegerArray(userArray);
        } catch (ProjectException e) {
            logger.log(Level.WARN, "Integer array is null or degenerated." +
                    " Negative element count is not possible. ", e);
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
    public OptionalInt countZeroElementQuantity(UserArray userArray) {

        int[] integerArray;
        try {
            integerArray = getCheckedIntegerArray(userArray);
        } catch (ProjectException e) {
            logger.log(Level.WARN, "Integer array is null or degenerated." +
                    " Zero element count is not possible. ", e);
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

    int[] getCheckedIntegerArray(UserArray userArray)
            throws ProjectException {

        int[] integerArray;
        try {
            integerArray = ((UserIntegerArray) userArray).getUserIntegerArray();
        } catch (ProjectException e) {
            throw new ProjectException("Integer array of this object is null", e);
        }
        if (integerArray.length == 0) {
            throw new ProjectException("Integer array of this object is degenerated.");
        }
        return integerArray;
    }
}

