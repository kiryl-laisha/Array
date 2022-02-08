package com.laisha.array.service.impl;

import com.laisha.array.entity.UserArray;
import com.laisha.array.exception.ProjectException;
import com.laisha.array.factory.impl.UserArrayFactoryImpl;
import com.laisha.array.service.UserArraySortService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.Optional;

public class UserIntegerArraySortServiceImpl implements UserArraySortService {

    private static final Logger logger = LogManager.getLogger();
    private static final UserIntegerArraySortServiceImpl instance =
            new UserIntegerArraySortServiceImpl();
    private static final UserIntegerArraySearchServiceImpl searchService =
            UserIntegerArraySearchServiceImpl.getInstance();
    private static final UserArrayFactoryImpl arrayFactory = UserArrayFactoryImpl.getInstance();

    private UserIntegerArraySortServiceImpl() {
    }

    public static UserIntegerArraySortServiceImpl getInstance() {
        return instance;
    }

    @Override
    public Optional<UserArray> sortByBubbleSorting(UserArray userArray) {

        int[] integerArray;
        try {
            integerArray = searchService.getCheckedIntegerArray(userArray);
        } catch (ProjectException e) {
            logger.log(Level.WARN, "Sorting is not available. ", e);
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
        UserArray otherUserArray = arrayFactory.createUserArray(integerArray);
        logger.log(Level.DEBUG, "Bubble sorting completed.");
        return Optional.of(otherUserArray);
    }

    @Override
    public Optional<UserArray> sortBySelection(UserArray userArray) {

        int[] integerArray;
        try {
            integerArray = searchService.getCheckedIntegerArray(userArray);
        } catch (ProjectException e) {
            logger.log(Level.WARN, "Sorting is not available. ", e);
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
        UserArray otherUserArray = arrayFactory.createUserArray(integerArray);
        logger.log(Level.DEBUG, "Selection sorting completed.");
        return Optional.of(otherUserArray);
    }

    @Override
    public Optional<UserArray> sortByInsertion(UserArray userArray) {

        int[] integerArray;
        try {
            integerArray = searchService.getCheckedIntegerArray(userArray);
        } catch (ProjectException e) {
            logger.log(Level.WARN, "Sorting is not available. ", e);
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
        UserArray otherUserArray = arrayFactory.createUserArray(integerArray);
        logger.log(Level.DEBUG, "Insertion sorting completed.");
        return Optional.of(otherUserArray);
    }

    @Override
    public Optional<UserArray> sortByStream(UserArray userArray) {

        int[] integerArray;
        try {
            integerArray = searchService.getCheckedIntegerArray(userArray);
        } catch (ProjectException e) {
            logger.log(Level.WARN, "Sorting is not available. ", e);
            return Optional.empty();
        }
        integerArray = Arrays.copyOf(integerArray, integerArray.length);
        integerArray = Arrays
                .stream(integerArray)
                .sorted()
                .toArray();
        UserArray otherUserArray = arrayFactory.createUserArray(integerArray);
        logger.log(Level.DEBUG, "Sorting by stream completed.");
        return Optional.of(otherUserArray);
    }
}

