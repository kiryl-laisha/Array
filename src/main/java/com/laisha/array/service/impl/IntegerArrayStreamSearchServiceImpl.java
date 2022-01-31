package com.laisha.array.service.impl;

import com.laisha.array.entity.UserIntegerArray;
import com.laisha.array.exception.ProjectException;
import com.laisha.array.service.IntegerArraySearchService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class IntegerArrayStreamSearchServiceImpl implements IntegerArraySearchService {

    private static final Logger logger = LogManager.getLogger();
    private static final IntegerArrayStreamSearchServiceImpl instance =
            new IntegerArrayStreamSearchServiceImpl();

    private IntegerArrayStreamSearchServiceImpl() {

    }

    public static IntegerArrayStreamSearchServiceImpl getInstance() {

        return instance;
    }

    @Override
    public int searchMinElement(UserIntegerArray userIntegerArray)
            throws ProjectException {

        int[] integerArray = getUserIntegerArray(userIntegerArray);
        int minimumElement =Arrays
                .stream(integerArray)
                .min()
                .getAsInt();
        logger.log(Level.DEBUG, "Found minimum element = {}.", minimumElement);
        return minimumElement;
    }

    @Override
    public int searchMaxElement(UserIntegerArray userIntegerArray)
            throws ProjectException {

        int[] integerArray = getUserIntegerArray(userIntegerArray);
        int maximumElement = Arrays
                .stream(integerArray)
                .max()
                .getAsInt();
        logger.log(Level.DEBUG, "Found maximum element = {}.", maximumElement);
        return maximumElement;
    }

    @Override
    public double calculateAverageValue(UserIntegerArray userIntegerArray)
            throws ProjectException {

        int[] integerArray = getUserIntegerArray(userIntegerArray);
        double averageValue = Arrays
                .stream(integerArray)
                .average()
                .getAsDouble();
        logger.log(Level.DEBUG, "Calculated average value = {}.", averageValue);
        return averageValue;
    }

    @Override
    public long calculateSumOfArrayElements(UserIntegerArray userIntegerArray)
            throws ProjectException {

        int[] integerArray = getUserIntegerArray(userIntegerArray);
        long totalSum = Arrays
                .stream(integerArray)
                .mapToLong(x -> x)
                .sum();
        logger.log(Level.DEBUG, "Calculated total sum = {}.", totalSum);
        return totalSum;
    }

    @Override
    public int countNegativeElementQuantity(UserIntegerArray userIntegerArray)
            throws ProjectException {

        int[] integerArray = getUserIntegerArray(userIntegerArray);
        int elementQuantity = (int) Arrays
                .stream(integerArray)
                .filter(x -> x < 0)
                .count();
        logger.log(Level.DEBUG, "Counted quantity of negative " +
                "array elements = {}.", elementQuantity);
        return elementQuantity;
    }

    @Override
    public int countNotNegativeElementQuantity(UserIntegerArray userIntegerArray)
            throws ProjectException {

        int[] integerArray = getUserIntegerArray(userIntegerArray);
        int elementQuantity = (int) Arrays
                .stream(integerArray)
                .filter(x -> x >= 0)
                .count();
        logger.log(Level.DEBUG, "Counted quantity of not negative " +
                "array elements = {}.", elementQuantity);
        return elementQuantity;
    }

    private int[] getUserIntegerArray(UserIntegerArray userIntegerArray)
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
