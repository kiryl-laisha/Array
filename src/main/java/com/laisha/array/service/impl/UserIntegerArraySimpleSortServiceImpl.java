package com.laisha.array.service.impl;

import com.laisha.array.entity.UserArray;
import com.laisha.array.entity.UserIntegerArray;
import com.laisha.array.exception.ProjectException;
import com.laisha.array.service.UserArraySimpleSortService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class UserIntegerArraySimpleSortServiceImpl implements UserArraySimpleSortService {

    private static final Logger logger = LogManager.getLogger();
    private static final UserIntegerArraySimpleSortServiceImpl instance =
            new UserIntegerArraySimpleSortServiceImpl();
    private static final UserIntegerArraySearchServiceImpl searchService =
            UserIntegerArraySearchServiceImpl.getInstance();

    private UserIntegerArraySimpleSortServiceImpl() {
    }

    public static UserIntegerArraySimpleSortServiceImpl getInstance() {
        return instance;
    }

    @Override
    public void sortByBubbleSorting(UserArray userArray) throws ProjectException {

        int[] integerArray = searchService.getCheckedIntegerArray(userArray);
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
        ((UserIntegerArray) userArray).setUserIntegerArray(integerArray);
        logger.log(Level.DEBUG, "Bubble sorting completed.");
    }

    @Override
    public void sortBySelection(UserArray userArray) throws ProjectException {

        int[] integerArray = searchService.getCheckedIntegerArray(userArray);
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
        ((UserIntegerArray) userArray).setUserIntegerArray(integerArray);
        logger.log(Level.DEBUG, "Selection sorting completed.");
    }

    @Override
    public void sortByInsertion(UserArray userArray) throws ProjectException {

        int[] integerArray = searchService.getCheckedIntegerArray(userArray);
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
        ((UserIntegerArray) userArray).setUserIntegerArray(integerArray);
        logger.log(Level.DEBUG, "Insertion sorting completed.");
    }

    @Override
    public void sortByStream(UserArray userArray) throws ProjectException {

        int[] integerArray = searchService.getCheckedIntegerArray(userArray);
        integerArray = Arrays
                .stream(integerArray)
                .sorted()
                .toArray();
        ((UserIntegerArray) userArray).setUserIntegerArray(integerArray);
        logger.log(Level.DEBUG, "Sorting by stream completed.");
    }
}
