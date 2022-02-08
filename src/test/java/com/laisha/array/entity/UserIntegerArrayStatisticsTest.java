package com.laisha.array.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UserIntegerArrayStatisticsTest {

    @Test
    @DisplayName("Array Statistics object is created successfully.")
    void buildPositiveTest() {

        Optional<UserArrayStatistics> userArrayStatistics =
                new UserIntegerArrayStatistics.Builder()
                        .setMinElement(1)
                        .setMaxElement(5)
                        .setAverageValue(3)
                        .setTotalSum(9)
                        .setNegativeElementQuantity(0)
                        .setNegativeElementQuantity(0)
                        .build();
        boolean actual = userArrayStatistics.isPresent();
        assertTrue(actual);
    }

    @Test
    @DisplayName("Array Statistics object is not created.")
    void buildNegativeTest() {

        Optional<UserArrayStatistics> userArrayStatistics =
                new UserIntegerArrayStatistics.Builder()
                        .setMinElement(1)
                        .setMaxElement(5)
                        .setAverageValue(3)
                        .setTotalSum(9)
                        .setNegativeElementQuantity(0)
                        .build();
        boolean actual = userArrayStatistics.isPresent();
        assertFalse(actual);
    }
}