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

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class UserIntegerArraySortServiceImplTest {

    private static UserArrayFactoryImpl arrayFactory = UserArrayFactoryImpl.getInstance();
    private static UserIntegerArraySortServiceImpl sortService =
            UserIntegerArraySortServiceImpl.getInstance();
    UserArray userArray;
    UserArray otherUserArray;

    @AfterEach
    void tearDown() {

        userArray = null;
        otherUserArray = null;
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
        userArray = arrayFactory.createUserArray(integerArray);
        Optional<UserArray> optionalUserArray = sortService.sortByBubbleSorting(userArray);
        optionalUserArray.ifPresent(array -> otherUserArray = array);
        int[] expectedIntegerArray = {-10, -5, 6, 13, 100};
        int[] actualIntegerArray = {};
        try {
            actualIntegerArray = ((UserIntegerArray) otherUserArray).getUserIntegerArray();
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
        userArray = arrayFactory.createUserArray(integerArray);
        Optional<UserArray> optionalUserArray = sortService.sortByBubbleSorting(userArray);
        optionalUserArray.ifPresent(array -> otherUserArray = array);
        int[] expectedIntegerArray = {13};
        int[] actualIntegerArray = {};
        try {
            actualIntegerArray = ((UserIntegerArray) otherUserArray).getUserIntegerArray();
        } catch (ProjectException e) {
            e.printStackTrace();
        }
        assertArrayEquals(expectedIntegerArray, actualIntegerArray);
    }

    @Test
    @DisplayName("Sorts not initialized integer array by bubble sorting. " +
            "New object is not returned.")
    void sortByBubbleSortingFirstNegativeTest() {

        userArray = arrayFactory.createUserArray();
        Optional<UserArray> optionalUserArray = sortService.sortByBubbleSorting(userArray);
        boolean actual = optionalUserArray.isPresent();
        assertFalse(actual);
    }

    @ParameterizedTest
    @EmptySource
    @DisplayName("Sorts degenerated integer array by bubble sorting. " +
            "New object is not returned.")
    void sortByBubbleSortingSecondNegativeTest(int... integerArray) {

        userArray = arrayFactory.createUserArray(integerArray);
        Optional<UserArray> optionalUserArray = sortService.sortByBubbleSorting(userArray);
        boolean actual = optionalUserArray.isPresent();
        assertFalse(actual);
    }

    @Test
    @DisplayName("Sorts valid integer array by selection. New object is " +
            "returned with sorted integer array.")
    void sortBySelectionFirstPositiveTest() {

        int[] integerArray = {13, 6, -10, 100, -5};
        userArray = arrayFactory.createUserArray(integerArray);
        Optional<UserArray> optionalUserArray = sortService.sortBySelection(userArray);
        optionalUserArray.ifPresent(array -> otherUserArray = array);
        int[] expectedIntegerArray = {-10, -5, 6, 13, 100};
        int[] actualIntegerArray = {};
        try {
            actualIntegerArray = ((UserIntegerArray) otherUserArray).getUserIntegerArray();
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
        userArray = arrayFactory.createUserArray(integerArray);
        Optional<UserArray> optionalUserArray = sortService.sortBySelection(userArray);
        optionalUserArray.ifPresent(array -> otherUserArray = array);
        int[] expectedIntegerArray = {13};
        int[] actualIntegerArray = {};
        try {
            actualIntegerArray = ((UserIntegerArray) otherUserArray).getUserIntegerArray();
        } catch (ProjectException e) {
            e.printStackTrace();
        }
        assertArrayEquals(expectedIntegerArray, actualIntegerArray);
    }

    @Test
    @DisplayName("Sorts not initialized integer array by selection. " +
            "New object is not returned.")
    void sortBySelectionFirstNegativeTest() {

        userArray = arrayFactory.createUserArray();
        Optional<UserArray> optionalUserArray = sortService.sortBySelection(userArray);
        boolean actual = optionalUserArray.isPresent();
        assertFalse(actual);
    }

    @ParameterizedTest
    @EmptySource
    @DisplayName("Sorts degenerated integer array by selection. " +
            "New object is not returned.")
    void sortBySelectionSecondNegativeTest(int... integerArray) {

        userArray = arrayFactory.createUserArray(integerArray);
        Optional<UserArray> optionalUserArray = sortService.sortBySelection(userArray);
        boolean actual = optionalUserArray.isPresent();
        assertFalse(actual);
    }

    @Test
    @DisplayName("Sorts valid integer array by insertion. New object is " +
            "returned with sorted integer array.")
    void sortByInsertionFirstPositiveTest() {

        int[] integerArray = {13, 6, -10, 100, -5};
        userArray = arrayFactory.createUserArray(integerArray);
        Optional<UserArray> optionalUserArray = sortService.sortByInsertion(userArray);
        optionalUserArray.ifPresent(array -> otherUserArray = array);
        int[] expectedIntegerArray = {-10, -5, 6, 13, 100};
        int[] actualIntegerArray = {};
        try {
            actualIntegerArray = ((UserIntegerArray) otherUserArray).getUserIntegerArray();
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
        userArray = arrayFactory.createUserArray(integerArray);
        Optional<UserArray> optionalUserArray = sortService.sortByInsertion(userArray);
        optionalUserArray.ifPresent(array -> otherUserArray = array);
        int[] expectedIntegerArray = {13};
        int[] actualIntegerArray = {};
        try {
            actualIntegerArray = ((UserIntegerArray) otherUserArray).getUserIntegerArray();
        } catch (ProjectException e) {
            e.printStackTrace();
        }
        assertArrayEquals(expectedIntegerArray, actualIntegerArray);
    }

    @Test
    @DisplayName("Sorts not initialized integer array by insertion. " +
            "New object is not returned.")
    void sortByInsertionFirstNegativeTest() {

        userArray = arrayFactory.createUserArray();
        Optional<UserArray> optionalUserArray = sortService.sortByInsertion(userArray);
        boolean actual = optionalUserArray.isPresent();
        assertFalse(actual);
    }

    @ParameterizedTest
    @EmptySource
    @DisplayName("Sorts degenerated integer array by insertion. " +
            "New object is not returned.")
    void sortByInsertionSecondNegativeTest(int... integerArray) {

        userArray = arrayFactory.createUserArray(integerArray);
        Optional<UserArray> optionalUserArray = sortService.sortByInsertion(userArray);
        boolean actual = optionalUserArray.isPresent();
        assertFalse(actual);
    }

    @Test
    @DisplayName("Sorts valid integer array by stream. New object is " +
            "returned with sorted integer array.")
    void sortByStreamFirstPositiveTest() {

        int[] integerArray = {13, 6, -10, 100, -5};
        userArray = arrayFactory.createUserArray(integerArray);
        Optional<UserArray> optionalUserArray = sortService.sortByStream(userArray);
        optionalUserArray.ifPresent(array -> otherUserArray = array);
        int[] expectedIntegerArray = {-10, -5, 6, 13, 100};
        int[] actualIntegerArray = {};
        try {
            actualIntegerArray = ((UserIntegerArray) otherUserArray).getUserIntegerArray();
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
        userArray = arrayFactory.createUserArray(integerArray);
        Optional<UserArray> optionalUserArray = sortService.sortByStream(userArray);
        optionalUserArray.ifPresent(array -> otherUserArray = array);
        int[] expectedIntegerArray = {13};
        int[] actualIntegerArray = {};
        try {
            actualIntegerArray = ((UserIntegerArray) otherUserArray).getUserIntegerArray();
        } catch (ProjectException e) {
            e.printStackTrace();
        }
        assertArrayEquals(expectedIntegerArray, actualIntegerArray);
    }

    @Test
    @DisplayName("Sorts not initialized integer array by stream. " +
            "New object is not returned.")
    void sortByStreamFirstNegativeTest() {

        userArray = arrayFactory.createUserArray();
        Optional<UserArray> optionalUserArray = sortService.sortByStream(userArray);
        boolean actual = optionalUserArray.isPresent();
        assertFalse(actual);
    }

    @ParameterizedTest
    @EmptySource
    @DisplayName("Sorts degenerated integer array by stream. " +
            "New object is not returned.")
    void sortByStreamSecondNegativeTest(int... integerArray) {

        userArray = arrayFactory.createUserArray(integerArray);
        Optional<UserArray> optionalUserArray = sortService.sortByStream(userArray);
        boolean actual = optionalUserArray.isPresent();
        assertFalse(actual);
    }
}
