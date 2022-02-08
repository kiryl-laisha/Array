package com.laisha.array.service.impl;

import com.laisha.array.entity.UserArray;
import com.laisha.array.entity.UserIntegerArray;
import com.laisha.array.exception.ProjectException;
import com.laisha.array.factory.impl.UserArrayFactoryImpl;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class UserIntegerArraySimpleSortServiceImplTest {

    private static UserArrayFactoryImpl arrayFactory = UserArrayFactoryImpl.getInstance();
    private static UserIntegerArraySimpleSortServiceImpl sortService =
            UserIntegerArraySimpleSortServiceImpl.getInstance();
    UserArray userArray;

    @AfterEach
    void tearDown() {
        userArray = null;
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
        userArray = arrayFactory.createUserArray(integerArray);
        int[] expectedIntegerArray = {-10, -5, 6, 13, 100};
        int[] actualIntegerArray = {};
        try {
            sortService.sortByBubbleSorting(userArray);
            actualIntegerArray = ((UserIntegerArray) userArray).getUserIntegerArray();
        } catch (ProjectException e) {
            e.printStackTrace();
        }
        assertArrayEquals(expectedIntegerArray, actualIntegerArray);
    }

    @Test
    @DisplayName("Sorts one element integer array by bubble sorting.")
    void sortByBubbleSortingSecondPositiveTest() {

        int[] expectedIntegerArray = {13};
        userArray = arrayFactory.createUserArray(expectedIntegerArray);
        int[] actualIntegerArray = {};
        try {
            sortService.sortByBubbleSorting(userArray);
            actualIntegerArray = ((UserIntegerArray) userArray).getUserIntegerArray();
        } catch (ProjectException e) {
            e.printStackTrace();
        }
        assertArrayEquals(expectedIntegerArray, actualIntegerArray);
    }

    @Test
    @DisplayName("Sorts not initialized integer array by bubble sorting.")
    void sortByBubbleSortingFirstNegativeTest() {

        userArray = arrayFactory.createUserArray();
        String expectedExceptionMessage = "Integer array of this object is null";
        String actualExceptionMessage = null;
        try {
            sortService.sortByBubbleSorting(userArray);
        } catch (ProjectException e) {
            actualExceptionMessage = e.getMessage();
        }
        assertEquals(expectedExceptionMessage, actualExceptionMessage);
    }

    @ParameterizedTest
    @EmptySource
    @DisplayName("Sorts degenerated integer array by bubble sorting.")
    void sortByBubbleSortingSecondNegativeTest(int... integerArray) {

        userArray = arrayFactory.createUserArray(integerArray);
        String expectedExceptionMessage = "Integer array of this object is degenerated.";
        String actualExceptionMessage = null;
        try {
            sortService.sortByBubbleSorting(userArray);
        } catch (ProjectException e) {
            actualExceptionMessage = e.getMessage();
        }
        assertEquals(expectedExceptionMessage, actualExceptionMessage);
    }

    @Test
    @DisplayName("Sorts valid integer array by selection.")
    void sortBySelectionFirstPositiveTest() {

        int[] integerArray = {13, 6, -10, 100, -5};
        userArray = arrayFactory.createUserArray(integerArray);
        int[] expectedIntegerArray = {-10, -5, 6, 13, 100};
        int[] actualIntegerArray = {};
        try {
            sortService.sortBySelection(userArray);
            actualIntegerArray = ((UserIntegerArray) userArray).getUserIntegerArray();
        } catch (ProjectException e) {
            e.printStackTrace();
        }
        assertArrayEquals(expectedIntegerArray, actualIntegerArray);
    }

    @Test
    @DisplayName("Sorts one element integer array by selection.")
    void sortBySelectionSecondPositiveTest() {

        int[] expectedIntegerArray = {13};
        userArray = arrayFactory.createUserArray(expectedIntegerArray);
        int[] actualIntegerArray = {};
        try {
            sortService.sortBySelection(userArray);
            actualIntegerArray = ((UserIntegerArray) userArray).getUserIntegerArray();
        } catch (ProjectException e) {
            e.printStackTrace();
        }
        assertArrayEquals(expectedIntegerArray, actualIntegerArray);
    }

    @Test
    @DisplayName("Sorts not initialized integer array by selection.")
    void sortBySelectionFirstNegativeTest() {

        userArray = arrayFactory.createUserArray();
        String expectedExceptionMessage = "Integer array of this object is null";
        String actualExceptionMessage = null;
        try {
            sortService.sortBySelection(userArray);
        } catch (ProjectException e) {
            actualExceptionMessage = e.getMessage();
        }
        assertEquals(expectedExceptionMessage, actualExceptionMessage);
    }

    @ParameterizedTest
    @EmptySource
    @DisplayName("Sorts degenerated integer array by selection.")
    void sortBySelectionSecondNegativeTest(int... integerArray) {

        userArray = arrayFactory.createUserArray(integerArray);
        String expectedExceptionMessage = "Integer array of this object is degenerated.";
        String actualExceptionMessage = null;
        try {
            sortService.sortBySelection(userArray);
        } catch (ProjectException e) {
            actualExceptionMessage = e.getMessage();
        }
        assertEquals(expectedExceptionMessage, actualExceptionMessage);
    }

    @Test
    @DisplayName("Sorts valid integer array by insertion.")
    void sortByInsertionFirstPositiveTest() {

        int[] integerArray = {13, 6, -10, 100, -5};
        userArray = arrayFactory.createUserArray(integerArray);
        int[] expectedIntegerArray = {-10, -5, 6, 13, 100};
        int[] actualIntegerArray = {};
        try {
            sortService.sortByInsertion(userArray);
            actualIntegerArray = ((UserIntegerArray) userArray).getUserIntegerArray();
        } catch (ProjectException e) {
            e.printStackTrace();
        }
        assertArrayEquals(expectedIntegerArray, actualIntegerArray);
    }

    @Test
    @DisplayName("Sorts one element integer array by insertion.")
    void sortByInsertionSecondPositiveTest() {

        int[] expectedIntegerArray = {13};
        userArray = arrayFactory.createUserArray(expectedIntegerArray);
        int[] actualIntegerArray = {};
        try {
            sortService.sortByInsertion(userArray);
            actualIntegerArray = ((UserIntegerArray) userArray).getUserIntegerArray();
        } catch (ProjectException e) {
            e.printStackTrace();
        }
        assertArrayEquals(expectedIntegerArray, actualIntegerArray);
    }

    @Test
    @DisplayName("Sorts not initialized integer array by insertion.")
    void sortByInsertionFirstNegativeTest() {

        userArray = arrayFactory.createUserArray();
        String expectedExceptionMessage = "Integer array of this object is null";
        String actualExceptionMessage = null;
        try {
            sortService.sortByInsertion(userArray);
        } catch (ProjectException e) {
            actualExceptionMessage = e.getMessage();
        }
        assertEquals(expectedExceptionMessage, actualExceptionMessage);
    }

    @ParameterizedTest
    @EmptySource
    @DisplayName("Sorts degenerated integer array by insertion.")
    void sortByInsertionSecondNegativeTest(int... integerArray) {

        userArray = arrayFactory.createUserArray(integerArray);
        String expectedExceptionMessage = "Integer array of this object is degenerated.";
        String actualExceptionMessage = null;
        try {
            sortService.sortByInsertion(userArray);
        } catch (ProjectException e) {
            actualExceptionMessage = e.getMessage();
        }
        assertEquals(expectedExceptionMessage, actualExceptionMessage);
    }

    @Test
    @DisplayName("Sorts valid integer array by stream.")
    void sortByStreamFirstPositiveTest() {

        int[] integerArray = {13, 6, -10, 100, -5};
        userArray = arrayFactory.createUserArray(integerArray);
        int[] expectedIntegerArray = {-10, -5, 6, 13, 100};
        int[] actualIntegerArray = {};
        try {
            sortService.sortByStream(userArray);
            actualIntegerArray = ((UserIntegerArray) userArray).getUserIntegerArray();
        } catch (ProjectException e) {
            e.printStackTrace();
        }
        assertArrayEquals(expectedIntegerArray, actualIntegerArray);
    }

    @Test
    @DisplayName("Sorts one element integer array by stream.")
    void sortByStreamSecondPositiveTest() {

        int[] expectedIntegerArray = {13};
        userArray = arrayFactory.createUserArray(expectedIntegerArray);
        int[] actualIntegerArray = {};
        try {
            sortService.sortByStream(userArray);
            actualIntegerArray = ((UserIntegerArray) userArray).getUserIntegerArray();
        } catch (ProjectException e) {
            e.printStackTrace();
        }
        assertArrayEquals(expectedIntegerArray, actualIntegerArray);
    }

    @Test
    @DisplayName("Sorts not initialized integer array by stream.")
    void sortByStreamFirstNegativeTest() {

        userArray = arrayFactory.createUserArray();
        String expectedExceptionMessage = "Integer array of this object is null";
        String actualExceptionMessage = null;
        try {
            sortService.sortByStream(userArray);
        } catch (ProjectException e) {
            actualExceptionMessage = e.getMessage();
        }
        assertEquals(expectedExceptionMessage, actualExceptionMessage);
    }

    @ParameterizedTest
    @EmptySource
    @DisplayName("Sorts degenerated integer array by stream.")
    void sortByStreamSecondNegativeTest(int... integerArray) {

        userArray = arrayFactory.createUserArray(integerArray);
        String expectedExceptionMessage = "Integer array of this object is degenerated.";
        String actualExceptionMessage = null;
        try {
            sortService.sortByStream(userArray);
        } catch (ProjectException e) {
            actualExceptionMessage = e.getMessage();
        }
        assertEquals(expectedExceptionMessage, actualExceptionMessage);
    }
}
