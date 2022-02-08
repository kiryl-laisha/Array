package com.laisha.array.service.impl;

import com.laisha.array.entity.UserArray;
import com.laisha.array.factory.impl.UserArrayFactoryImpl;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class UserIntegerArraySearchServiceImplTest {

    static UserIntegerArraySearchServiceImpl searchService =
            UserIntegerArraySearchServiceImpl.getInstance();
    static UserArrayFactoryImpl arrayFactory = UserArrayFactoryImpl.getInstance();
    static UserArray userArray;

    @AfterEach
    void tearDown() {
        userArray = null;
    }

    @AfterAll
    static void tearDownClass() {

        searchService = null;
        arrayFactory = null;
    }

    @Test
    @DisplayName("Searches minimum element for correct integer array.")
    void searchMinElementFirstPositiveTest() {

        int[] integerArray = {-5, 0, 5, -20, 77};
        userArray = arrayFactory.createUserArray(integerArray);
        OptionalInt optionalInt = searchService.searchMinElement(userArray);
        int expectedMinimumElement = -20;
        int actualMinimumElement = 0;
        if (optionalInt.isPresent()) {
            actualMinimumElement = optionalInt.getAsInt();
        }
        assertEquals(expectedMinimumElement, actualMinimumElement);
    }

    @Test
    @DisplayName("Searches minimum element for one element integer array.")
    void searchMinElementSecondPositiveTest() {

        int[] integerArray = {-77};
        userArray = arrayFactory.createUserArray(integerArray);
        OptionalInt optionalInt = searchService.searchMinElement(userArray);
        int expectedMinimumElement = -77;
        int actualMinimumElement = 0;
        if (optionalInt.isPresent()) {
            actualMinimumElement = optionalInt.getAsInt();
        }
        assertEquals(expectedMinimumElement, actualMinimumElement);
    }

    @Test
    @DisplayName("Searches minimum element for integer array is null.")
    void searchMinElementFirstNegativeTest() {

        userArray = arrayFactory.createUserArray();
        OptionalInt optionalInt = searchService.searchMinElement(userArray);
        boolean actual = optionalInt.isPresent();
        assertFalse(actual);
    }

    @Test
    @DisplayName("Searches minimum element for degenerated integer array.")
    void searchMinElementSecondNegativeTest() {

        int[] integerArray = {};
        userArray = arrayFactory.createUserArray(integerArray);
        OptionalInt optionalInt = searchService.searchMinElement(userArray);
        boolean actual = optionalInt.isPresent();
        assertFalse(actual);
    }

    @Test
    @DisplayName("Searches maximum element for correct integer array.")
    void searchMaxElementFirstPositiveTest() {

        int[] integerArray = {-5, 0, 5, -20, 77};
        userArray = arrayFactory.createUserArray(integerArray);
        OptionalInt optionalInt = searchService.searchMaxElement(userArray);
        int expectedMinimumElement = 77;
        int actualMinimumElement = 0;
        if (optionalInt.isPresent()) {
            actualMinimumElement = optionalInt.getAsInt();
        }
        assertEquals(expectedMinimumElement, actualMinimumElement);
    }

    @Test
    @DisplayName("Searches maximum element for one element integer array.")
    void searchMaxElementSecondPositiveTest() {

        int[] integerArray = {-17};
        userArray = arrayFactory.createUserArray(integerArray);
        OptionalInt optionalInt = searchService.searchMaxElement(userArray);
        int expectedMinimumElement = -17;
        int actualMinimumElement = 0;
        if (optionalInt.isPresent()) {
            actualMinimumElement = optionalInt.getAsInt();
        }
        assertEquals(expectedMinimumElement, actualMinimumElement);
    }

    @Test
    @DisplayName("Searches maximum element for integer array is null.")
    void searchMaxElementFirstNegativeTest() {

        userArray = arrayFactory.createUserArray();
        OptionalInt optionalInt = searchService.searchMaxElement(userArray);
        boolean actual = optionalInt.isPresent();
        assertFalse(actual);
    }

    @Test
    @DisplayName("Searches maximum element for degenerated integer array.")
    void searchMaxElementSecondNegativeTest() {

        int[] integerArray = {};
        userArray = arrayFactory.createUserArray(integerArray);
        OptionalInt optionalInt = searchService.searchMaxElement(userArray);
        boolean actual = optionalInt.isPresent();
        assertFalse(actual);
    }

    @Test
    @DisplayName("Calculates average value for correct integer array.")
    void calculateAverageValueFirstPositiveTest() {

        int[] integerArray = {-5, 0, 10, -20, +20};
        userArray = arrayFactory.createUserArray(integerArray);
        double expectedAverageValue = 1.0;
        double actualAverageValue = 0;
        OptionalDouble optionalDouble = searchService.calculateAverageValue(userArray);
        if (optionalDouble.isPresent()) {
            actualAverageValue = optionalDouble.getAsDouble();
        }
        assertEquals(expectedAverageValue, actualAverageValue);
    }

    @Test
    @DisplayName("Calculates average value for one element integer array.")
    void calculateAverageValueSecondPositiveTest() {

        int[] integerArray = {13};
        userArray = arrayFactory.createUserArray(integerArray);
        double expectedAverageValue = 13.0;
        double actualAverageValue = 0;
        OptionalDouble optionalDouble = searchService.calculateAverageValue(userArray);
        if (optionalDouble.isPresent()) {
            actualAverageValue = optionalDouble.getAsDouble();
        }
        assertEquals(expectedAverageValue, actualAverageValue);
    }

    @Test
    @DisplayName("Calculates average value for integer array is null.")
    void calculateAverageValueFirstNegativeTest() {

        userArray = arrayFactory.createUserArray();
        OptionalDouble optionalDouble = searchService.calculateAverageValue(userArray);
        boolean actual = optionalDouble.isPresent();
        assertFalse(actual);
    }

    @Test
    @DisplayName("Calculates average value for degenerated integer array.")
    void calculateAverageValueSecondNegativeTest() {

        int[] integerArray = {};
        userArray = arrayFactory.createUserArray(integerArray);
        OptionalDouble optionalDouble = searchService.calculateAverageValue(userArray);
        boolean actual = optionalDouble.isPresent();
        assertFalse(actual);
    }

    @Test
    @DisplayName("Calculates total sum for correct integer array.")
    void calculateTotalSumFirstPositiveTest() {

        int[] integerArray = {-5, 0, 10, -20, +20};
        userArray = arrayFactory.createUserArray(integerArray);
        long expectedTotalSum = 5;
        long actualTotalSum = 0;
        OptionalLong optionalLong = searchService.calculateSumOfArrayElements(userArray);
        if (optionalLong.isPresent()) {
            actualTotalSum = optionalLong.getAsLong();
        }
        assertEquals(expectedTotalSum, actualTotalSum);
    }

    @Test
    @DisplayName("Calculates total sum for one element integer array.")
    void calculateTotalSumSecondPositiveTest() {

        int[] integerArray = {13};
        userArray = arrayFactory.createUserArray(integerArray);
        long expectedTotalSum = 13;
        long actualTotalSum = 0;
        OptionalLong optionalLong = searchService.calculateSumOfArrayElements(userArray);
        if (optionalLong.isPresent()) {
            actualTotalSum = optionalLong.getAsLong();
        }
        assertEquals(expectedTotalSum, actualTotalSum);
    }

    @Test
    @DisplayName("Calculates total sum for integer array is null.")
    void calculateTotalSumFirstNegativeTest() {

        userArray = arrayFactory.createUserArray();
        OptionalLong optionalLong = searchService.calculateSumOfArrayElements(userArray);
        boolean actual = optionalLong.isPresent();
        assertFalse(actual);
    }

    @Test
    @DisplayName("Calculates total sum for degenerated integer array.")
    void calculateTotalSumSecondNegativeTest() {

        int[] integerArray = {};
        userArray = arrayFactory.createUserArray(integerArray);
        OptionalLong optionalLong = searchService.calculateSumOfArrayElements(userArray);
        boolean actual = optionalLong.isPresent();
        assertFalse(actual);
    }

    @Test
    @DisplayName("Counts quantity of negative element for correct integer array.")
    void countNegativeElementQuantityFirstPositiveTest() {

        int[] integerArray = {-5, 0, 5, -20, 77};
        userArray = arrayFactory.createUserArray(integerArray);
        OptionalInt optionalInt = searchService.countNegativeElementQuantity(userArray);
        int expectedMinimumElement = 2;
        int actualMinimumElement = 0;
        if (optionalInt.isPresent()) {
            actualMinimumElement = optionalInt.getAsInt();
        }
        assertEquals(expectedMinimumElement, actualMinimumElement);
    }

    @Test
    @DisplayName("Counts quantity of negative element for one element integer array.")
    void countNegativeElementQuantitySecondPositiveTest() {

        int[] integerArray = {-77};
        userArray = arrayFactory.createUserArray(integerArray);
        OptionalInt optionalInt = searchService.countNegativeElementQuantity(userArray);
        int expectedMinimumElement = 1;
        int actualMinimumElement = 0;
        if (optionalInt.isPresent()) {
            actualMinimumElement = optionalInt.getAsInt();
        }
        assertEquals(expectedMinimumElement, actualMinimumElement);
    }

    @Test
    @DisplayName("Counts quantity of negative element for integer array is null.")
    void countNegativeElementQuantityFirstNegativeTest() {

        userArray = arrayFactory.createUserArray();
        OptionalInt optionalInt = searchService.countNegativeElementQuantity(userArray);
        boolean actual = optionalInt.isPresent();
        assertFalse(actual);
    }

    @Test
    @DisplayName("Counts quantity of negative element for degenerated integer array.")
    void countNegativeElementQuantitySecondNegativeTest() {

        int[] integerArray = {};
        userArray = arrayFactory.createUserArray(integerArray);
        OptionalInt optionalInt = searchService.countNegativeElementQuantity(userArray);
        boolean actual = optionalInt.isPresent();
        assertFalse(actual);
    }

    @Test
    @DisplayName("Counts quantity of zero element for correct integer array.")
    void countZeroElementQuantityFirstPositiveTest() {

        int[] integerArray = {-5, 0, 5, -20, 77};
        userArray = arrayFactory.createUserArray(integerArray);
        OptionalInt optionalInt = searchService.countZeroElementQuantity(userArray);
        int expectedMinimumElement = 1;
        int actualMinimumElement = 0;
        if (optionalInt.isPresent()) {
            actualMinimumElement = optionalInt.getAsInt();
        }
        assertEquals(expectedMinimumElement, actualMinimumElement);
    }

    @Test
    @DisplayName("Counts quantity of zero element for one element integer array.")
    void countZeroElementQuantitySecondPositiveTest() {

        int[] integerArray = {0};
        userArray = arrayFactory.createUserArray(integerArray);
        OptionalInt optionalInt = searchService.countZeroElementQuantity(userArray);
        int expectedMinimumElement = 1;
        int actualMinimumElement = 0;
        if (optionalInt.isPresent()) {
            actualMinimumElement = optionalInt.getAsInt();
        }
        assertEquals(expectedMinimumElement, actualMinimumElement);
    }

    @Test
    @DisplayName("Counts quantity of zero element for integer array is null.")
    void countZeroElementQuantityFirstNegativeTest() {

        userArray = arrayFactory.createUserArray();
        OptionalInt optionalInt = searchService.countZeroElementQuantity(userArray);
        boolean actual = optionalInt.isPresent();
        assertFalse(actual);
    }

    @Test
    @DisplayName("Counts quantity of zero element for degenerated integer array.")
    void countZeroElementQuantitySecondNegativeTest() {

        int[] integerArray = {};
        userArray = arrayFactory.createUserArray(integerArray);
        OptionalInt optionalInt = searchService.countZeroElementQuantity(userArray);
        boolean actual = optionalInt.isPresent();
        assertFalse(actual);
    }

}
