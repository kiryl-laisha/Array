package com.laisha.array.creator.impl;

import com.laisha.array.entity.*;
import com.laisha.array.service.impl.UserIntegerArraySearchServiceImpl;
import com.laisha.array.creator.UserArrayStatisticsCreator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class UserIntegerArrayStatisticsCreator implements UserArrayStatisticsCreator {

    private static final Logger logger = LogManager.getLogger();
    private static final UserIntegerArrayStatisticsCreator instance =
            new UserIntegerArrayStatisticsCreator();
    private static final UserIntegerArraySearchServiceImpl searchService =
            UserIntegerArraySearchServiceImpl.getInstance();

    private UserIntegerArrayStatisticsCreator() {
    }

    public static UserIntegerArrayStatisticsCreator getInstance() {
        return instance;
    }

    @Override
    public Optional<UserArrayStatistics> createUserArrayStatistics(UserArray userArray) {

        int minElement;
        int maxElement;
        double averageValue;
        long totalSum;
        int negativeElementQuantity;
        int zeroElementQuantity;
        try {
            OptionalInt optionalMinElement = searchService.searchMinElement(userArray);
            minElement = optionalMinElement.orElseThrow();

            OptionalInt optionalMaxElement = searchService.searchMaxElement(userArray);
            maxElement = optionalMaxElement.orElseThrow();

            OptionalDouble optionalAverageValue =
                    searchService.calculateAverageValue(userArray);
            averageValue = optionalAverageValue.orElseThrow();

            OptionalLong optionalTotalSum =
                    searchService.calculateSumOfArrayElements(userArray);
            totalSum = optionalTotalSum.orElseThrow();

            OptionalInt optionalNegativeElementQuantity =
                    searchService.countNegativeElementQuantity(userArray);
            negativeElementQuantity = optionalNegativeElementQuantity.orElseThrow();

            OptionalInt optionalZeroElementQuantity =
                    searchService.countZeroElementQuantity(userArray);
            zeroElementQuantity = optionalZeroElementQuantity.orElseThrow();
        } catch (NoSuchElementException e) {
            logger.log(Level.WARN, "Not all parameters have " +
                    "initialized properly.", e);
            return Optional.empty();
        }
        Optional<UserArrayStatistics> userArrayStatistics =
                new UserIntegerArrayStatistics.Builder()
                .setMinElement(minElement)
                .setMaxElement(maxElement)
                .setAverageValue(averageValue)
                .setTotalSum(totalSum)
                .setNegativeElementQuantity(negativeElementQuantity)
                .setZeroElementQuantity(zeroElementQuantity)
                .build();
        return userArrayStatistics;
    }
}
