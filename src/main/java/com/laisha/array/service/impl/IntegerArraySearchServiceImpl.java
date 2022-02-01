package com.laisha.array.service.impl;

import com.laisha.array.entity.UserIntegerArray;
import com.laisha.array.exception.ProjectException;
import com.laisha.array.service.IntegerArraySearchService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class IntegerArraySearchServiceImpl implements IntegerArraySearchService {

    private static final Logger logger = LogManager.getLogger();
    private static final IntegerArraySearchServiceImpl instance =
            new IntegerArraySearchServiceImpl();

    private IntegerArraySearchServiceImpl() {
    }

    public static IntegerArraySearchServiceImpl getInstance() {

        return instance;
    }

    @Override
    public int searchMinElement(UserIntegerArray userIntegerArray)
            throws ProjectException {

        int[] integerArray = getIntegerArrayWithCheckByNullAndEmpty(userIntegerArray);
        int minimumElement = Integer.MAX_VALUE;
        for (int element : integerArray) {
            if (element < minimumElement) {
                minimumElement = element;
            }
        }
        logger.log(Level.DEBUG, "Found minimum element = {}.", minimumElement);
        return minimumElement;
    }

    @Override
    public int searchMaxElement(UserIntegerArray userIntegerArray)
            throws ProjectException {

        int[] integerArray = getIntegerArrayWithCheckByNullAndEmpty(userIntegerArray);
        int maximumElement = Integer.MIN_VALUE;
        for (int element : integerArray) {
            if (element > maximumElement) {
                maximumElement = element;
            }
        }
        logger.log(Level.DEBUG, "Found maximum element = {}.", maximumElement);
        return maximumElement;
    }

    @Override
    public double calculateAverageValue(UserIntegerArray userIntegerArray)
            throws ProjectException {

        int[] integerArray = getIntegerArrayWithCheckByNullAndEmpty(userIntegerArray);
        double totalSum = 0;
        for (int element : integerArray) {
            totalSum = totalSum + element;
        }
        double averageValue = totalSum / integerArray.length;
        logger.log(Level.DEBUG, "Calculated average value = {}.", averageValue);
        return averageValue;
    }

    @Override
    public long calculateSumOfArrayElements(UserIntegerArray userIntegerArray)
            throws ProjectException {

        int[] integerArray = getIntegerArrayWithCheckByNullAndEmpty(userIntegerArray);
        long totalSum = 0;
        for (int element : integerArray) {
            totalSum = totalSum + element;
        }
        logger.log(Level.DEBUG, "Calculated total sum = {}.", totalSum);
        return totalSum;
    }

    @Override
    public int countNegativeElementQuantity(UserIntegerArray userIntegerArray)
            throws ProjectException {

        int[] integerArray = getIntegerArrayWithCheckByNullAndEmpty(userIntegerArray);
        int elementQuantity = 0;
        for (int element : integerArray) {
            if (element < 0) {
                elementQuantity++;
            }
        }
        logger.log(Level.DEBUG, "Counted quantity of negative " +
                "array elements = {}.", elementQuantity);
        return elementQuantity;
    }

    @Override
    public int countNotNegativeElementQuantity(UserIntegerArray userIntegerArray)
            throws ProjectException {

        int[] integerArray = getIntegerArrayWithCheckByNullAndEmpty(userIntegerArray);
        int elementQuantity = 0;
        for (int element : integerArray) {
            if (element >= 0) {
                elementQuantity++;
            }
        }
        logger.log(Level.DEBUG, "Counted quantity of not negative " +
                "array elements = {}.", elementQuantity);
        return elementQuantity;
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
