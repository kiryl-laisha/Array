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

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class CustomIntegerArraySortServiceImplTest {

    private static CustomArrayFactoryImpl arrayFactory = CustomArrayFactoryImpl.getInstance();
    private static CustomIntegerArraySortServiceImpl sortService =
            CustomIntegerArraySortServiceImpl.getInstance();
    CustomArray customArray;
    CustomArray otherCustomArray;

    @AfterEach
    void tearDown() {

        customArray = null;
        otherCustomArray = null;
    }

    @AfterAll
    static void tearDownClass() {

        arrayFactory = null;
        sortService = null;
    }

    @Test
    @DisplayName("Sorts valid integer array by bubble sorting. New object is " +
            "returned with sorted integer array.")
    void sortByBubbleSortingFirstPositiveTest() {

        int[] integerArray = {13, 6, -10, 100, -5};
        customArray = arrayFactory.createCustomArray(integerArray);
        Optional<CustomArray> optionalUserArray = sortService.sortByBubbleSorting(customArray);
        optionalUserArray.ifPresent(array -> otherCustomArray = array);
        int[] expectedIntegerArray = {-10, -5, 6, 13, 100};
        int[] actualIntegerArray = {};
        try {
            actualIntegerArray = ((CustomIntegerArray) otherCustomArray).getCustomIntegerArray();
        } catch (ProjectException e) {
            e.printStackTrace();
        }
        assertArrayEquals(expectedIntegerArray, actualIntegerArray);
    }

    @Test
    @DisplayName("Sorts one element integer array by bubble sorting. New object is " +
            "returned with sorted integer array.")
    void sortByBubbleSortingSecondPositiveTest() {

        int[] integerArray = {13};
        customArray = arrayFactory.createCustomArray(integerArray);
        Optional<CustomArray> optionalUserArray = sortService.sortByBubbleSorting(customArray);
        optionalUserArray.ifPresent(array -> otherCustomArray = array);
        int[] expectedIntegerArray = {13};
        int[] actualIntegerArray = {};
        try {
            actualIntegerArray = ((CustomIntegerArray) otherCustomArray).getCustomIntegerArray();
        } catch (ProjectException e) {
            e.printStackTrace();
        }
        assertArrayEquals(expectedIntegerArray, actualIntegerArray);
    }

    @Test
    @DisplayName("Sorts not initialized integer array by bubble sorting. " +
            "New object is not returned.")
    void sortByBubbleSortingFirstNegativeTest() {

        customArray = arrayFactory.createCustomArray();
        Optional<CustomArray> optionalUserArray = sortService.sortByBubbleSorting(customArray);
        boolean actual = optionalUserArray.isPresent();
        assertFalse(actual);
    }

    @ParameterizedTest
    @EmptySource
    @DisplayName("Sorts degenerated integer array by bubble sorting. " +
            "New object is not returned.")
    void sortByBubbleSortingSecondNegativeTest(int... integerArray) {

        customArray = arrayFactory.createCustomArray(integerArray);
        Optional<CustomArray> optionalUserArray = sortService.sortByBubbleSorting(customArray);
        boolean actual = optionalUserArray.isPresent();
        assertFalse(actual);
    }

    @Test
    @DisplayName("Sorts valid integer array by selection. New object is " +
            "returned with sorted integer array.")
    void sortBySelectionFirstPositiveTest() {

        int[] integerArray = {13, 6, -10, 100, -5};
        customArray = arrayFactory.createCustomArray(integerArray);
        Optional<CustomArray> optionalUserArray = sortService.sortBySelection(customArray);
        optionalUserArray.ifPresent(array -> otherCustomArray = array);
        int[] expectedIntegerArray = {-10, -5, 6, 13, 100};
        int[] actualIntegerArray = {};
        try {
            actualIntegerArray = ((CustomIntegerArray) otherCustomArray).getCustomIntegerArray();
        } catch (ProjectException e) {
            e.printStackTrace();
        }
        assertArrayEquals(expectedIntegerArray, actualIntegerArray);
    }

    @Test
    @DisplayName("Sorts one element integer array by selection. New object is " +
            "returned with sorted integer array.")
    void sortBySelectionSecondPositiveTest() {

        int[] integerArray = {13};
        customArray = arrayFactory.createCustomArray(integerArray);
        Optional<CustomArray> optionalUserArray = sortService.sortBySelection(customArray);
        optionalUserArray.ifPresent(array -> otherCustomArray = array);
        int[] expectedIntegerArray = {13};
        int[] actualIntegerArray = {};
        try {
            actualIntegerArray = ((CustomIntegerArray) otherCustomArray).getCustomIntegerArray();
        } catch (ProjectException e) {
            e.printStackTrace();
        }
        assertArrayEquals(expectedIntegerArray, actualIntegerArray);
    }

    @Test
    @DisplayName("Sorts not initialized integer array by selection. " +
            "New object is not returned.")
    void sortBySelectionFirstNegativeTest() {

        customArray = arrayFactory.createCustomArray();
        Optional<CustomArray> optionalUserArray = sortService.sortBySelection(customArray);
        boolean actual = optionalUserArray.isPresent();
        assertFalse(actual);
    }

    @ParameterizedTest
    @EmptySource
    @DisplayName("Sorts degenerated integer array by selection. " +
            "New object is not returned.")
    void sortBySelectionSecondNegativeTest(int... integerArray) {

        customArray = arrayFactory.createCustomArray(integerArray);
        Optional<CustomArray> optionalUserArray = sortService.sortBySelection(customArray);
        boolean actual = optionalUserArray.isPresent();
        assertFalse(actual);
    }

    @Test
    @DisplayName("Sorts valid integer array by insertion. New object is " +
            "returned with sorted integer array.")
    void sortByInsertionFirstPositiveTest() {

        int[] integerArray = {13, 6, -10, 100, -5};
        customArray = arrayFactory.createCustomArray(integerArray);
        Optional<CustomArray> optionalUserArray = sortService.sortByInsertion(customArray);
        optionalUserArray.ifPresent(array -> otherCustomArray = array);
        int[] expectedIntegerArray = {-10, -5, 6, 13, 100};
        int[] actualIntegerArray = {};
        try {
            actualIntegerArray = ((CustomIntegerArray) otherCustomArray).getCustomIntegerArray();
        } catch (ProjectException e) {
            e.printStackTrace();
        }
        assertArrayEquals(expectedIntegerArray, actualIntegerArray);
    }

    @Test
    @DisplayName("Sorts one element integer array by insertion. New object is " +
            "returned with sorted integer array.")
    void sortByInsertionSecondPositiveTest() {

        int[] integerArray = {13};
        customArray = arrayFactory.createCustomArray(integerArray);
        Optional<CustomArray> optionalUserArray = sortService.sortByInsertion(customArray);
        optionalUserArray.ifPresent(array -> otherCustomArray = array);
        int[] expectedIntegerArray = {13};
        int[] actualIntegerArray = {};
        try {
            actualIntegerArray = ((CustomIntegerArray) otherCustomArray).getCustomIntegerArray();
        } catch (ProjectException e) {
            e.printStackTrace();
        }
        assertArrayEquals(expectedIntegerArray, actualIntegerArray);
    }

    @Test
    @DisplayName("Sorts not initialized integer array by insertion. " +
            "New object is not returned.")
    void sortByInsertionFirstNegativeTest() {

        customArray = arrayFactory.createCustomArray();
        Optional<CustomArray> optionalUserArray = sortService.sortByInsertion(customArray);
        boolean actual = optionalUserArray.isPresent();
        assertFalse(actual);
    }

    @ParameterizedTest
    @EmptySource
    @DisplayName("Sorts degenerated integer array by insertion. " +
            "New object is not returned.")
    void sortByInsertionSecondNegativeTest(int... integerArray) {

        customArray = arrayFactory.createCustomArray(integerArray);
        Optional<CustomArray> optionalUserArray = sortService.sortByInsertion(customArray);
        boolean actual = optionalUserArray.isPresent();
        assertFalse(actual);
    }

    @Test
    @DisplayName("Sorts valid integer array by stream. New object is " +
            "returned with sorted integer array.")
    void sortByStreamFirstPositiveTest() {

        int[] integerArray = {13, 6, -10, 100, -5};
        customArray = arrayFactory.createCustomArray(integerArray);
        Optional<CustomArray> optionalUserArray = sortService.sortByStream(customArray);
        optionalUserArray.ifPresent(array -> otherCustomArray = array);
        int[] expectedIntegerArray = {-10, -5, 6, 13, 100};
        int[] actualIntegerArray = {};
        try {
            actualIntegerArray = ((CustomIntegerArray) otherCustomArray).getCustomIntegerArray();
        } catch (ProjectException e) {
            e.printStackTrace();
        }
        assertArrayEquals(expectedIntegerArray, actualIntegerArray);
    }

    @Test
    @DisplayName("Sorts one element integer array by stream. New object is " +
            "returned with sorted integer array.")
    void sortByStreamSecondPositiveTest() {

        int[] integerArray = {13};
        customArray = arrayFactory.createCustomArray(integerArray);
        Optional<CustomArray> optionalUserArray = sortService.sortByStream(customArray);
        optionalUserArray.ifPresent(array -> otherCustomArray = array);
        int[] expectedIntegerArray = {13};
        int[] actualIntegerArray = {};
        try {
            actualIntegerArray = ((CustomIntegerArray) otherCustomArray).getCustomIntegerArray();
        } catch (ProjectException e) {
            e.printStackTrace();
        }
        assertArrayEquals(expectedIntegerArray, actualIntegerArray);
    }

    @Test
    @DisplayName("Sorts not initialized integer array by stream. " +
            "New object is not returned.")
    void sortByStreamFirstNegativeTest() {

        customArray = arrayFactory.createCustomArray();
        Optional<CustomArray> optionalUserArray = sortService.sortByStream(customArray);
        boolean actual = optionalUserArray.isPresent();
        assertFalse(actual);
    }

    @ParameterizedTest
    @EmptySource
    @DisplayName("Sorts degenerated integer array by stream. " +
            "New object is not returned.")
    void sortByStreamSecondNegativeTest(int... integerArray) {

        customArray = arrayFactory.createCustomArray(integerArray);
        Optional<CustomArray> optionalUserArray = sortService.sortByStream(customArray);
        boolean actual = optionalUserArray.isPresent();
        assertFalse(actual);
    }
}
