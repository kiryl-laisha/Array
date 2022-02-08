package com.laisha.array.service.impl;

import com.laisha.array.entity.UserArray;
import com.laisha.array.exception.ProjectException;
import com.laisha.array.service.UserIntegerArraySearchService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;

public class UserIntegerArrayStreamSearchServiceImpl implements UserIntegerArraySearchService {

    private static final Logger logger = LogManager.getLogger();
    private static final UserIntegerArrayStreamSearchServiceImpl instance =
            new UserIntegerArrayStreamSearchServiceImpl();
    private static final UserIntegerArraySearchServiceImpl searchService =
            UserIntegerArraySearchServiceImpl.getInstance();

    private UserIntegerArrayStreamSearchServiceImpl() {

    }

    public static UserIntegerArrayStreamSearchServiceImpl getInstance() {

        return instance;
    }

    @Override
    public OptionalInt searchMinElement(UserArray userArray) {


        int[] integerArray;
        try {
            integerArray = searchService.getCheckedIntegerArray(userArray);
        } catch (ProjectException e) {
            logger.log(Level.WARN, "Integer array is null or degenerated." +
                    " Minimum element search is not possible. ", e);
            return OptionalInt.empty();
        }
        int minimumElement = Arrays
                .stream(integerArray)
                .min()
                .getAsInt();
        logger.log(Level.DEBUG, "Found minimum element = {}.", minimumElement);
        return OptionalInt.of(minimumElement);
    }

    @Override
    public OptionalInt searchMaxElement(UserArray userArray) {

        int[] integerArray;
        try {
            integerArray = searchService.getCheckedIntegerArray(userArray);
        } catch (ProjectException e) {
            logger.log(Level.WARN, "Integer array is null or degenerated." +
                    " Maximum element search is not possible. ", e);
            return OptionalInt.empty();
        }
        int maximumElement = Arrays
                .stream(integerArray)
                .max()
                .getAsInt();
        logger.log(Level.DEBUG, "Found maximum element = {}.", maximumElement);
        return OptionalInt.of(maximumElement);
    }

    @Override
    public OptionalDouble calculateAverageValue(UserArray userArray) {

        int[] integerArray;
        try {
            integerArray = searchService.getCheckedIntegerArray(userArray);
        } catch (ProjectException e) {
            logger.log(Level.WARN, "Integer array is null or degenerated." +
                    " Average value calculation is not possible. ", e);
            return OptionalDouble.empty();
        }
        double averageValue = Arrays
                .stream(integerArray)
                .average()
                .getAsDouble();
        logger.log(Level.DEBUG, "Calculated average value = {}.", averageValue);
        return OptionalDouble.of(averageValue);
    }

    @Override
    public OptionalLong calculateSumOfArrayElements(UserArray userArray) {

        int[] integerArray;
        try {
            integerArray = searchService.getCheckedIntegerArray(userArray);
        } catch (ProjectException e) {
            logger.log(Level.WARN, "Integer array is null or degenerated." +
                    " Total sum calculation is not possible. ", e);
            return OptionalLong.empty();
        }
        long totalSum = Arrays
                .stream(integerArray)
                .mapToLong(x -> x)
                .sum();
        logger.log(Level.DEBUG, "Calculated total sum = {}.", totalSum);
        return OptionalLong.of(totalSum);
    }

    @Override
    public OptionalInt countNegativeElementQuantity(UserArray userArray) {

        int[] integerArray;
        try {
            integerArray = searchService.getCheckedIntegerArray(userArray);
        } catch (ProjectException e) {
            logger.log(Level.WARN, "Integer array is null or degenerated." +
                    " Negative element count is not possible. ", e);
            return OptionalInt.empty();
        }
        int elementQuantity = (int) Arrays
                .stream(integerArray)
                .filter(x -> x < 0)
                .count();
        logger.log(Level.DEBUG, "Counted quantity of negative " +
                "array elements = {}.", elementQuantity);
        return OptionalInt.of(elementQuantity);
    }

    @Override
    public OptionalInt countZeroElementQuantity(UserArray userArray) {

        int[] integerArray;
        try {
            integerArray = searchService.getCheckedIntegerArray(userArray);
        } catch (ProjectException e) {
            logger.log(Level.WARN, "Integer array is null or degenerated." +
                    " Zero element count is not possible. ", e);
            return OptionalInt.empty();
        }
        int elementQuantity = (int) Arrays
                .stream(integerArray)
                .filter(x -> x == 0)
                .count();
        logger.log(Level.DEBUG, "Counted quantity of zero " +
                "array elements = {}.", elementQuantity);
        return OptionalInt.of(elementQuantity);
    }
}
