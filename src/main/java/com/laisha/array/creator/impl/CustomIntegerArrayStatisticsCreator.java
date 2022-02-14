package com.laisha.array.creator.impl;

import com.laisha.array.creator.CustomArrayStatisticsCreator;
import com.laisha.array.entity.CustomArray;
import com.laisha.array.entity.CustomArrayStatistics;
import com.laisha.array.entity.CustomIntegerArrayStatistics;
import com.laisha.array.service.impl.CustomIntegerArraySearchServiceImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class CustomIntegerArrayStatisticsCreator implements CustomArrayStatisticsCreator {

    private static final Logger logger = LogManager.getLogger();
    private static final CustomIntegerArrayStatisticsCreator instance =
            new CustomIntegerArrayStatisticsCreator();
    private static final CustomIntegerArraySearchServiceImpl searchService =
            CustomIntegerArraySearchServiceImpl.getInstance();

    private CustomIntegerArrayStatisticsCreator() {
    }

    public static CustomIntegerArrayStatisticsCreator getInstance() {
        return instance;
    }

    @Override
    public Optional<CustomArrayStatistics> createCustomArrayStatistics(CustomArray customArray) {

        int minElement;
        int maxElement;
        double averageValue;
        long totalSum;
        int negativeElementQuantity;
        int zeroElementQuantity;
        try {
            OptionalInt optionalMinElement = searchService.searchMinElement(customArray);
            minElement = optionalMinElement.orElseThrow();

            OptionalInt optionalMaxElement = searchService.searchMaxElement(customArray);
            maxElement = optionalMaxElement.orElseThrow();

            OptionalDouble optionalAverageValue =
                    searchService.calculateAverageValue(customArray);
            averageValue = optionalAverageValue.orElseThrow();

            OptionalLong optionalTotalSum =
                    searchService.calculateSumOfArrayElements(customArray);
            totalSum = optionalTotalSum.orElseThrow();

            OptionalInt optionalNegativeElementQuantity =
                    searchService.countNegativeElementQuantity(customArray);
            negativeElementQuantity = optionalNegativeElementQuantity.orElseThrow();

            OptionalInt optionalZeroElementQuantity =
                    searchService.countZeroElementQuantity(customArray);
            zeroElementQuantity = optionalZeroElementQuantity.orElseThrow();
        } catch (NoSuchElementException e) {
            logger.log(Level.WARN, "Not all parameters have " +
                    "initialized properly.", e);
            return Optional.empty();
        }
        Optional<CustomArrayStatistics> arrayStatistics =
                new CustomIntegerArrayStatistics.Builder()
                        .setMinElement(minElement)
                        .setMaxElement(maxElement)
                        .setAverageValue(averageValue)
                        .setTotalSum(totalSum)
                        .setNegativeElementQuantity(negativeElementQuantity)
                        .setZeroElementQuantity(zeroElementQuantity)
                        .build();
        return arrayStatistics;
    }
}
