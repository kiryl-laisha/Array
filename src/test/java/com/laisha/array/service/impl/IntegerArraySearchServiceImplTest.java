package com.laisha.array.service.impl;

import com.laisha.array.entity.UserIntegerArray;
import com.laisha.array.exception.ProjectException;
import com.laisha.array.factory.impl.ArrayFactoryImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntegerArraySearchServiceImplTest {

    static IntegerArraySearchServiceImpl integerArraySearchService =
            IntegerArraySearchServiceImpl.getInstance();
    static ArrayFactoryImpl arrayFactory = ArrayFactoryImpl.getInstance();
    static UserIntegerArray userIntegerArray;

    @AfterEach
    void tearDown() {
        userIntegerArray = null;
    }

    @Test
    public void searchMinElement() {

        int[] integerArray = new int[]{-5, 0, 5, -20, 77};
        int actualMinimumElement = 0;
        try {
            userIntegerArray = arrayFactory.createUserIntegerArray(integerArray);
            actualMinimumElement =
                    integerArraySearchService.searchMinElement(userIntegerArray);
        } catch (ProjectException projectException) {
            projectException.printStackTrace();
        }
        int expectedMinimumElement = -20;
        assertEquals(expectedMinimumElement, actualMinimumElement);
    }

    @Test
    public void searchMinElementForOneElementArray() {

        int[] integerArray = new int[]{-77};
        int actualMinimumElement = 0;
        try {
            userIntegerArray = arrayFactory.createUserIntegerArray(integerArray);
            actualMinimumElement =
                    integerArraySearchService.searchMinElement(userIntegerArray);
        } catch (ProjectException projectException) {
            projectException.printStackTrace();
        }
        int expectedMinimumElement = -77;
        assertEquals(expectedMinimumElement, actualMinimumElement);
    }

    @Test
    public void searchMinElementForNotInitializedArray() {

        userIntegerArray = arrayFactory.createUserIntegerArray();
        String actualExceptionMessage = null;
        try {
            integerArraySearchService.searchMinElement(userIntegerArray);
        } catch (ProjectException projectException) {
            actualExceptionMessage = projectException.getMessage();
        }
        String expectedExceptionMessage = "Integer array of this object is not" +
                "initialized. Method execution is not available.";
        assertEquals(expectedExceptionMessage, actualExceptionMessage);
    }

    @Test
    public void searchMinElementForDegeneratedArray() {

        String actualExceptionMessage = null;
        try {
            userIntegerArray = arrayFactory.createUserIntegerArray(new int[]{});
            integerArraySearchService.searchMinElement(userIntegerArray);
        } catch (ProjectException projectException) {
            actualExceptionMessage = projectException.getMessage();
        }
        String expectedExceptionMessage = "Integer array is degenerated. " +
                "Method execution is not available.";
        assertEquals(expectedExceptionMessage, actualExceptionMessage);
    }

    @Test
    public void searchMaxElement() {

        int[] integerArray = new int[]{-5, 0, 5, -20, 77};
        int actualMaximumElement = 0;
        try {
            userIntegerArray = arrayFactory.createUserIntegerArray(integerArray);
            actualMaximumElement =
                    integerArraySearchService.searchMaxElement(userIntegerArray);
        } catch (ProjectException projectException) {
            projectException.printStackTrace();
        }
        int expectedMaximumElement = 77;
        assertEquals(expectedMaximumElement, actualMaximumElement);
    }

    @Test
    public void searchMaxElementForOneElementArray() {

        int[] integerArray = new int[]{-177};
        int actualMaximumElement = 0;
        try {
            userIntegerArray = arrayFactory.createUserIntegerArray(integerArray);
            actualMaximumElement =
                    integerArraySearchService.searchMaxElement(userIntegerArray);
        } catch (ProjectException projectException) {
            projectException.printStackTrace();
        }
        int expectedMaximumElement = -177;
        assertEquals(expectedMaximumElement, actualMaximumElement);
    }

    @Test
    public void searchMaxElementForNotInitializedArray() {

        userIntegerArray = arrayFactory.createUserIntegerArray();
        String actualExceptionMessage = null;
        try {
            integerArraySearchService.searchMaxElement(userIntegerArray);
        } catch (ProjectException projectException) {
            actualExceptionMessage = projectException.getMessage();
        }
        String expectedExceptionMessage = "Integer array of this object is not" +
                "initialized. Method execution is not available.";
        assertEquals(expectedExceptionMessage, actualExceptionMessage);
    }

    @Test
    public void searchMaxElementForDegeneratedArray() {

        String actualExceptionMessage = null;
        try {
            userIntegerArray = arrayFactory.createUserIntegerArray(new int[]{});
            integerArraySearchService.searchMaxElement(userIntegerArray);
        } catch (ProjectException projectException) {
            actualExceptionMessage = projectException.getMessage();
        }
        String expectedExceptionMessage = "Integer array is degenerated. " +
                "Method execution is not available.";
        assertEquals(expectedExceptionMessage, actualExceptionMessage);
    }

    @Test
    public void calculateAverageValue() {

        int[] integerArray = new int[]{-5, 0, 10, -20, +20};
        double actualAverageValue = 0;
        try {
            userIntegerArray = arrayFactory.createUserIntegerArray(integerArray);
            actualAverageValue =
                    integerArraySearchService.calculateAverageValue(userIntegerArray);
        } catch (ProjectException projectException) {
            projectException.printStackTrace();
        }
        double expectedAverageValue = 1.0;
        assertEquals(expectedAverageValue, actualAverageValue);
    }

    @Test
    public void calculateAverageValueForOneElementArray() {

        int[] integerArray = new int[]{13};
        double actualAverageValue = 0;
        try {
            userIntegerArray = arrayFactory.createUserIntegerArray(integerArray);
            actualAverageValue =
                    integerArraySearchService.calculateAverageValue(userIntegerArray);
        } catch (ProjectException projectException) {
            projectException.printStackTrace();
        }
        double expectedAverageValue = 13;
        assertEquals(expectedAverageValue, actualAverageValue);
    }

    @Test
    public void calculateAverageValueForNotInitializedArray() {

        userIntegerArray = arrayFactory.createUserIntegerArray();
        String actualExceptionMessage = null;
        try {
            integerArraySearchService.calculateAverageValue(userIntegerArray);
        } catch (ProjectException projectException) {
            actualExceptionMessage = projectException.getMessage();
        }
        String expectedExceptionMessage = "Integer array of this object is not" +
                "initialized. Method execution is not available.";
        assertEquals(expectedExceptionMessage, actualExceptionMessage);
    }

    @Test
    public void calculateAverageValueForDegeneratedArray() {

        String actualExceptionMessage = null;
        try {
            userIntegerArray = arrayFactory.createUserIntegerArray(new int[]{});
            integerArraySearchService.calculateAverageValue(userIntegerArray);
        } catch (ProjectException projectException) {
            actualExceptionMessage = projectException.getMessage();
        }
        String expectedExceptionMessage = "Integer array is degenerated. " +
                "Method execution is not available.";
        assertEquals(expectedExceptionMessage, actualExceptionMessage);
    }

    @Test
    public void calculateSumOfArrayElements() {

        int[] integerArray = new int[]{-17, 2_147_483_000, 7, 10, +1_000_000_000};
        long actualTotalSum = 0;
        try {
            userIntegerArray = arrayFactory.createUserIntegerArray(integerArray);
            actualTotalSum =
                    integerArraySearchService.calculateSumOfArrayElements(userIntegerArray);
        } catch (ProjectException projectException) {
            projectException.printStackTrace();
        }
        long expectedTotalSum = 3_147_483_000L;
        assertEquals(expectedTotalSum, actualTotalSum);
    }

    @Test
    public void calculateSumOfArrayElementsForOneElementArray() {

        int[] integerArray = new int[]{15};
        long actualTotalSum = 0;
        try {
            userIntegerArray = arrayFactory.createUserIntegerArray(integerArray);
            actualTotalSum =
                    integerArraySearchService.calculateSumOfArrayElements(userIntegerArray);
        } catch (ProjectException projectException) {
            projectException.printStackTrace();
        }
        long expectedTotalSum = 15;
        assertEquals(expectedTotalSum, actualTotalSum);
    }

    @Test
    public void calculateSumOfArrayElementsForNotInitializedArray() {

        userIntegerArray = arrayFactory.createUserIntegerArray();
        String actualExceptionMessage = null;
        try {
            integerArraySearchService.calculateSumOfArrayElements(userIntegerArray);
        } catch (ProjectException projectException) {
            actualExceptionMessage = projectException.getMessage();
        }
        String expectedExceptionMessage = "Integer array of this object is not" +
                "initialized. Method execution is not available.";
        assertEquals(expectedExceptionMessage, actualExceptionMessage);
    }

    @Test
    public void calculateSumOfArrayElementsForDegeneratedArray() {

        String actualExceptionMessage = null;
        try {
            userIntegerArray = arrayFactory.createUserIntegerArray(new int[]{});
            integerArraySearchService.calculateAverageValue(userIntegerArray);
        } catch (ProjectException projectException) {
            actualExceptionMessage = projectException.getMessage();
        }
        String expectedExceptionMessage = "Integer array is degenerated. " +
                "Method execution is not available.";
        assertEquals(expectedExceptionMessage, actualExceptionMessage);
    }

    @Test
    public void countNegativeElementQuantity() {

        int[] integerArray = new int[]{-17, -2, 7, 10, -100};
        int actualElementQuantity = 0;
        try {
            userIntegerArray = arrayFactory.createUserIntegerArray(integerArray);
            actualElementQuantity =
                    integerArraySearchService.countNegativeElementQuantity(userIntegerArray);
        } catch (ProjectException projectException) {
            projectException.printStackTrace();
        }
        int expectedElementQuantity = 3;
        assertEquals(expectedElementQuantity, actualElementQuantity);
    }

    @Test
    public void countNegativeElementQuantityForOneElementArray() {

        int[] integerArray = new int[]{-1};
        int actualElementQuantity = 0;
        try {
            userIntegerArray = arrayFactory.createUserIntegerArray(integerArray);
            actualElementQuantity =
                    integerArraySearchService.countNegativeElementQuantity(userIntegerArray);
        } catch (ProjectException projectException) {
            projectException.printStackTrace();
        }
        int expectedElementQuantity = 1;
        assertEquals(expectedElementQuantity, actualElementQuantity);
    }

    @Test
    public void countNegativeElementQuantityForNotInitializedArray() {

        userIntegerArray = arrayFactory.createUserIntegerArray();
        String actualExceptionMessage = null;
        try {
            integerArraySearchService.countNegativeElementQuantity(userIntegerArray);
        } catch (ProjectException projectException) {
            actualExceptionMessage = projectException.getMessage();
        }
        String expectedExceptionMessage = "Integer array of this object is not" +
                "initialized. Method execution is not available.";
        assertEquals(expectedExceptionMessage, actualExceptionMessage);
    }

    @Test
    public void countNegativeElementQuantityForDegeneratedArray() {

        String actualExceptionMessage = null;
        try {
            userIntegerArray = arrayFactory.createUserIntegerArray(new int[]{});
            integerArraySearchService.countNegativeElementQuantity(userIntegerArray);
        } catch (ProjectException projectException) {
            actualExceptionMessage = projectException.getMessage();
        }
        String expectedExceptionMessage = "Integer array is degenerated. " +
                "Method execution is not available.";
        assertEquals(expectedExceptionMessage, actualExceptionMessage);
    }

    @Test
    public void countNotNegativeElementQuantity() {

        int[] integerArray = new int[]{-17, 0, 7, 10, -100};
        int actualElementQuantity = 0;
        try {
            userIntegerArray = arrayFactory.createUserIntegerArray(integerArray);
            actualElementQuantity = integerArraySearchService
                    .countNotNegativeElementQuantity(userIntegerArray);
        } catch (ProjectException projectException) {
            projectException.printStackTrace();
        }
        int expectedElementQuantity = 3;
        assertEquals(expectedElementQuantity, actualElementQuantity);
    }

    @Test
    public void countNotNegativeElementQuantityForOneElementArray() {

        int[] integerArray = new int[]{0};
        int actualElementQuantity = 0;
        try {
            userIntegerArray = arrayFactory.createUserIntegerArray(integerArray);
            actualElementQuantity = integerArraySearchService
                    .countNotNegativeElementQuantity(userIntegerArray);
        } catch (ProjectException projectException) {
            projectException.printStackTrace();
        }
        int expectedElementQuantity = 1;
        assertEquals(expectedElementQuantity, actualElementQuantity);
    }

    @Test
    public void countNotNegativeElementQuantityForNotInitializedArray() {

        userIntegerArray = arrayFactory.createUserIntegerArray();
        String actualExceptionMessage = null;
        try {
            integerArraySearchService.countNotNegativeElementQuantity(userIntegerArray);
        } catch (ProjectException projectException) {
            actualExceptionMessage = projectException.getMessage();
        }
        String expectedExceptionMessage = "Integer array of this object is not" +
                "initialized. Method execution is not available.";
        assertEquals(expectedExceptionMessage, actualExceptionMessage);
    }

    @Test
    public void countNotNegativeElementQuantityForDegeneratedArray() {

        String actualExceptionMessage = null;
        try {
            userIntegerArray = arrayFactory.createUserIntegerArray(new int[]{});
            integerArraySearchService.countNotNegativeElementQuantity(userIntegerArray);
        } catch (ProjectException projectException) {
            actualExceptionMessage = projectException.getMessage();
        }
        String expectedExceptionMessage = "Integer array is degenerated. " +
                "Method execution is not available.";
        assertEquals(expectedExceptionMessage, actualExceptionMessage);
    }
}
