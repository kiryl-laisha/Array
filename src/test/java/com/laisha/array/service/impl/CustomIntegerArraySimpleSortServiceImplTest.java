package com.laisha.array.service.impl;

import com.laisha.array.entity.CustomArray;
import com.laisha.array.entity.CustomIntegerArray;
import com.laisha.array.exception.ProjectException;
import com.laisha.array.factory.impl.CustomArrayFactoryImpl;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomIntegerArraySimpleSortServiceImplTest {

    private static CustomArrayFactoryImpl arrayFactory = CustomArrayFactoryImpl.getInstance();
    private static CustomIntegerArraySimpleSortServiceImpl sortService =
            CustomIntegerArraySimpleSortServiceImpl.getInstance();
    CustomArray customArray;

    @AfterEach
    void tearDown() {
        customArray = null;
    }

    @AfterAll
    static void tearDownClass() {

        arrayFactory = null;
        sortService = null;
    }

    @Test
    @DisplayName("Sorts valid integer array by bubble sorting.")
    void sortByBubbleSortingFirstPositiveTest() {

        int[] integerArray = {13, 6, -10, 100, -5};
        customArray = arrayFactory.createCustomArray(integerArray);
        int[] expectedIntegerArray = {-10, -5, 6, 13, 100};
        int[] actualIntegerArray = {};
        try {
            sortService.sortByBubbleSorting(customArray);
            actualIntegerArray = ((CustomIntegerArray) customArray).getCustomIntegerArray();
        } catch (ProjectException e) {
            e.printStackTrace();
        }
        assertArrayEquals(expectedIntegerArray, actualIntegerArray);
    }

    @Test
    @DisplayName("Sorts one element integer array by bubble sorting.")
    void sortByBubbleSortingSecondPositiveTest() {

        int[] expectedIntegerArray = {13};
        customArray = arrayFactory.createCustomArray(expectedIntegerArray);
        int[] actualIntegerArray = {};
        try {
            sortService.sortByBubbleSorting(customArray);
            actualIntegerArray = ((CustomIntegerArray) customArray).getCustomIntegerArray();
        } catch (ProjectException e) {
            e.printStackTrace();
        }
        assertArrayEquals(expectedIntegerArray, actualIntegerArray);
    }

    @Test
    @DisplayName("Sorts not initialized integer array by bubble sorting.")
    void sortByBubbleSortingFirstNegativeTest() {

        customArray = arrayFactory.createCustomArray();
        String expectedExceptionMessage = "Integer array of this object is null";
        String actualExceptionMessage = null;
        try {
            sortService.sortByBubbleSorting(customArray);
        } catch (ProjectException e) {
            actualExceptionMessage = e.getMessage();
        }
        assertEquals(expectedExceptionMessage, actualExceptionMessage);
    }

    @ParameterizedTest
    @EmptySource
    @DisplayName("Sorts degenerated integer array by bubble sorting.")
    void sortByBubbleSortingSecondNegativeTest(int... integerArray) {

        customArray = arrayFactory.createCustomArray(integerArray);
        String expectedExceptionMessage = "Integer array of this object is degenerated.";
        String actualExceptionMessage = null;
        try {
            sortService.sortByBubbleSorting(customArray);
        } catch (ProjectException e) {
            actualExceptionMessage = e.getMessage();
        }
        assertEquals(expectedExceptionMessage, actualExceptionMessage);
    }

    @Test
    @DisplayName("Sorts valid integer array by selection.")
    void sortBySelectionFirstPositiveTest() {

        int[] integerArray = {13, 6, -10, 100, -5};
        customArray = arrayFactory.createCustomArray(integerArray);
        int[] expectedIntegerArray = {-10, -5, 6, 13, 100};
        int[] actualIntegerArray = {};
        try {
            sortService.sortBySelection(customArray);
            actualIntegerArray = ((CustomIntegerArray) customArray).getCustomIntegerArray();
        } catch (ProjectException e) {
            e.printStackTrace();
        }
        assertArrayEquals(expectedIntegerArray, actualIntegerArray);
    }

    @Test
    @DisplayName("Sorts one element integer array by selection.")
    void sortBySelectionSecondPositiveTest() {

        int[] expectedIntegerArray = {13};
        customArray = arrayFactory.createCustomArray(expectedIntegerArray);
        int[] actualIntegerArray = {};
        try {
            sortService.sortBySelection(customArray);
            actualIntegerArray = ((CustomIntegerArray) customArray).getCustomIntegerArray();
        } catch (ProjectException e) {
            e.printStackTrace();
        }
        assertArrayEquals(expectedIntegerArray, actualIntegerArray);
    }

    @Test
    @DisplayName("Sorts not initialized integer array by selection.")
    void sortBySelectionFirstNegativeTest() {

        customArray = arrayFactory.createCustomArray();
        String expectedExceptionMessage = "Integer array of this object is null";
        String actualExceptionMessage = null;
        try {
            sortService.sortBySelection(customArray);
        } catch (ProjectException e) {
            actualExceptionMessage = e.getMessage();
        }
        assertEquals(expectedExceptionMessage, actualExceptionMessage);
    }

    @ParameterizedTest
    @EmptySource
    @DisplayName("Sorts degenerated integer array by selection.")
    void sortBySelectionSecondNegativeTest(int... integerArray) {

        customArray = arrayFactory.createCustomArray(integerArray);
        String expectedExceptionMessage = "Integer array of this object is degenerated.";
        String actualExceptionMessage = null;
        try {
            sortService.sortBySelection(customArray);
        } catch (ProjectException e) {
            actualExceptionMessage = e.getMessage();
        }
        assertEquals(expectedExceptionMessage, actualExceptionMessage);
    }

    @Test
    @DisplayName("Sorts valid integer array by insertion.")
    void sortByInsertionFirstPositiveTest() {

        int[] integerArray = {13, 6, -10, 100, -5};
        customArray = arrayFactory.createCustomArray(integerArray);
        int[] expectedIntegerArray = {-10, -5, 6, 13, 100};
        int[] actualIntegerArray = {};
        try {
            sortService.sortByInsertion(customArray);
            actualIntegerArray = ((CustomIntegerArray) customArray).getCustomIntegerArray();
        } catch (ProjectException e) {
            e.printStackTrace();
        }
        assertArrayEquals(expectedIntegerArray, actualIntegerArray);
    }

    @Test
    @DisplayName("Sorts one element integer array by insertion.")
    void sortByInsertionSecondPositiveTest() {

        int[] expectedIntegerArray = {13};
        customArray = arrayFactory.createCustomArray(expectedIntegerArray);
        int[] actualIntegerArray = {};
        try {
            sortService.sortByInsertion(customArray);
            actualIntegerArray = ((CustomIntegerArray) customArray).getCustomIntegerArray();
        } catch (ProjectException e) {
            e.printStackTrace();
        }
        assertArrayEquals(expectedIntegerArray, actualIntegerArray);
    }

    @Test
    @DisplayName("Sorts not initialized integer array by insertion.")
    void sortByInsertionFirstNegativeTest() {

        customArray = arrayFactory.createCustomArray();
        String expectedExceptionMessage = "Integer array of this object is null";
        String actualExceptionMessage = null;
        try {
            sortService.sortByInsertion(customArray);
        } catch (ProjectException e) {
            actualExceptionMessage = e.getMessage();
        }
        assertEquals(expectedExceptionMessage, actualExceptionMessage);
    }

    @ParameterizedTest
    @EmptySource
    @DisplayName("Sorts degenerated integer array by insertion.")
    void sortByInsertionSecondNegativeTest(int... integerArray) {

        customArray = arrayFactory.createCustomArray(integerArray);
        String expectedExceptionMessage = "Integer array of this object is degenerated.";
        String actualExceptionMessage = null;
        try {
            sortService.sortByInsertion(customArray);
        } catch (ProjectException e) {
            actualExceptionMessage = e.getMessage();
        }
        assertEquals(expectedExceptionMessage, actualExceptionMessage);
    }

    @Test
    @DisplayName("Sorts valid integer array by stream.")
    void sortByStreamFirstPositiveTest() {

        int[] integerArray = {13, 6, -10, 100, -5};
        customArray = arrayFactory.createCustomArray(integerArray);
        int[] expectedIntegerArray = {-10, -5, 6, 13, 100};
        int[] actualIntegerArray = {};
        try {
            sortService.sortByStream(customArray);
            actualIntegerArray = ((CustomIntegerArray) customArray).getCustomIntegerArray();
        } catch (ProjectException e) {
            e.printStackTrace();
        }
        assertArrayEquals(expectedIntegerArray, actualIntegerArray);
    }

    @Test
    @DisplayName("Sorts one element integer array by stream.")
    void sortByStreamSecondPositiveTest() {

        int[] expectedIntegerArray = {13};
        customArray = arrayFactory.createCustomArray(expectedIntegerArray);
        int[] actualIntegerArray = {};
        try {
            sortService.sortByStream(customArray);
            actualIntegerArray = ((CustomIntegerArray) customArray).getCustomIntegerArray();
        } catch (ProjectException e) {
            e.printStackTrace();
        }
        assertArrayEquals(expectedIntegerArray, actualIntegerArray);
    }

    @Test
    @DisplayName("Sorts not initialized integer array by stream.")
    void sortByStreamFirstNegativeTest() {

        customArray = arrayFactory.createCustomArray();
        String expectedExceptionMessage = "Integer array of this object is null";
        String actualExceptionMessage = null;
        try {
            sortService.sortByStream(customArray);
        } catch (ProjectException e) {
            actualExceptionMessage = e.getMessage();
        }
        assertEquals(expectedExceptionMessage, actualExceptionMessage);
    }

    @ParameterizedTest
    @EmptySource
    @DisplayName("Sorts degenerated integer array by stream.")
    void sortByStreamSecondNegativeTest(int... integerArray) {

        customArray = arrayFactory.createCustomArray(integerArray);
        String expectedExceptionMessage = "Integer array of this object is degenerated.";
        String actualExceptionMessage = null;
        try {
            sortService.sortByStream(customArray);
        } catch (ProjectException e) {
            actualExceptionMessage = e.getMessage();
        }
        assertEquals(expectedExceptionMessage, actualExceptionMessage);
    }
}
