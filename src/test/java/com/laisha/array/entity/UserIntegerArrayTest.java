package com.laisha.array.entity;

import com.laisha.array.exception.ProjectException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class UserIntegerArrayTest {

    private static UserIntegerArray userIntegerArray;
    private static final String REGEX_STRING_AS_UUID = "^[\\da-fA-F]{8}-[\\da-fA-F]{4}" +
            "-4[\\da-fA-F]{3}-[8-9abAB][\\da-fA-F]{3}-[\\da-fA-F]{12}$";

    @AfterEach
    void tearDown() {
        userIntegerArray = null;
    }

    @Test
    @DisplayName("Integer array hasn't been initialized.")
    void getUserIntegerArrayFirstPositiveTest() {

        userIntegerArray = UserIntegerArray.createBuilder().build();
        String expectedExceptionMessage = "Integer array is null.";
        String actualExceptionMessage = null;
        try {
            userIntegerArray.getUserIntegerArray();
        } catch (ProjectException e) {
            actualExceptionMessage = e.getMessage();
        }
        assertEquals(expectedExceptionMessage, actualExceptionMessage);
    }

    @ParameterizedTest
    @EmptySource
    @DisplayName("Integer array is initialized by empty source.")
    void getUserIntegerArraySecondPositiveTest(int[] integerArray) {

        int[] expectedIntegerArray = {};
        userIntegerArray = UserIntegerArray
                .createBuilder()
                .integerArray(integerArray)
                .build();
        int[] actualIntegerArray = null;
        try {
            actualIntegerArray = userIntegerArray.getUserIntegerArray();
        } catch (ProjectException e) {
            e.printStackTrace();
        }
        assertArrayEquals(expectedIntegerArray, actualIntegerArray);
    }

    @Test
    @DisplayName("Integer array has been initialized correctly.")
    void getUserIntegerArrayThirdPositiveTest() {

        int[] expectedIntegerArray = {1, -1, 3};
        userIntegerArray = UserIntegerArray
                .createBuilder()
                .integerArray(expectedIntegerArray)
                .build();
        int[] actualIntegerArray = new int[]{};
        try {
            actualIntegerArray = userIntegerArray.getUserIntegerArray();
        } catch (ProjectException e) {
            e.printStackTrace();
        }
        assertArrayEquals(expectedIntegerArray, actualIntegerArray);
    }

    @Test
    @DisplayName("Checking the immutable of an array by reference.")
    void getUserIntegerArrayFourthPositiveTest() {

        userIntegerArray = UserIntegerArray
                .createBuilder()
                .integerArray(new int[]{5, -5, 13})
                .build();
        int[] expectedIntegerArray = new int[]{};
        int[] actualIntegerArray = new int[]{};
        try {
            int[] temporaryIntegerArray = userIntegerArray.getUserIntegerArray();
            expectedIntegerArray = Arrays.copyOf(temporaryIntegerArray,
                    temporaryIntegerArray.length);
            temporaryIntegerArray[0] = 100;
            actualIntegerArray = userIntegerArray.getUserIntegerArray();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertArrayEquals(expectedIntegerArray, actualIntegerArray);
    }

    @Test
    @DisplayName("Checking the setting by a correct array.")
    void setUserIntegerArrayFirstPositiveTest() {

        userIntegerArray = UserIntegerArray.createBuilder().build();
        int[] expectedIntegerArray = new int[]{1, -1, 3};
        userIntegerArray.setUserIntegerArray(expectedIntegerArray);
        int[] actualIntegerArray = null;
        try {
            actualIntegerArray = userIntegerArray.getUserIntegerArray();
        } catch (ProjectException e) {
            e.printStackTrace();
        }
        assertArrayEquals(expectedIntegerArray, actualIntegerArray);
    }

    @ParameterizedTest
    @EmptySource
    @DisplayName("Checking the setting by an empty array.")
    void setUserIntegerArraySecondPositiveTest(int[] integerArray) {

        userIntegerArray = UserIntegerArray.createBuilder().build();
        int[] expectedIntegerArray = {};
        userIntegerArray.setUserIntegerArray(integerArray);
        int[] actualIntegerArray = null;
        try {
            actualIntegerArray = userIntegerArray.getUserIntegerArray();
        } catch (ProjectException e) {
            e.printStackTrace();
        }
        assertArrayEquals(expectedIntegerArray, actualIntegerArray);
    }

    @Test
    @DisplayName("Checking the immutable of an array by reference.")
    void setUserIntegerArrayThirdPositiveTest() {

        userIntegerArray = UserIntegerArray.createBuilder().build();
        int[] temporaryIntegerArray = new int[]{0, 5, -5};
        int[] expectedIntegerArray = Arrays.copyOf(temporaryIntegerArray,
                temporaryIntegerArray.length);
        userIntegerArray.setUserIntegerArray(temporaryIntegerArray);
        temporaryIntegerArray[0] = 100;
        int[] actualIntegerArray = null;
        try {
            actualIntegerArray = userIntegerArray.getUserIntegerArray();
        } catch (ProjectException e) {
            e.printStackTrace();
        }
        assertArrayEquals(expectedIntegerArray, actualIntegerArray);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2})
    @DisplayName("Element with valid index has been set.")
    void setElementToUserIntegerArrayFirstPositiveTest(int index) {

        int[] integerArray = new int[]{-10, 5, -5};
        userIntegerArray = UserIntegerArray
                .createBuilder()
                .integerArray(integerArray)
                .build();
        int expected = index;
        int actual = 0;
        try {
            userIntegerArray.setElementToUserIntegerArray(index, index);
            actual = userIntegerArray.getUserIntegerArray()[index];
        } catch (ProjectException e) {
            e.printStackTrace();
        }
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 3, 77})
    @DisplayName("Element with invalid index has been set.")
    void setElementToUserIntegerArrayFirsNegativeTest(int index) {

        int[] integerArray = new int[]{-20, 5, -5};
        userIntegerArray = UserIntegerArray
                .createBuilder()
                .integerArray(integerArray)
                .build();
        String expectedExceptionMessage = "Provided element index is out of array " +
                "bounds. Element setting to array is not available.";
        String actualExceptionMessage = null;
        try {
            userIntegerArray.setElementToUserIntegerArray(index, index);
        } catch (ProjectException e) {
            actualExceptionMessage = e.getMessage();
        }
        assertEquals(expectedExceptionMessage, actualExceptionMessage);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 2})
    @DisplayName("Element with valid index has been tried to set " +
            "for not initialized array.")
    void setElementToUserIntegerArraySecondNegativeTest(int index) {

        userIntegerArray = UserIntegerArray.createBuilder().build();
        String expectedExceptionMessage = "Integer array hasn't been initialized or is " +
                "degenerated. Element setting to array is not available.";
        String actualExceptionMessage = null;
        try {
            userIntegerArray.setElementToUserIntegerArray(index, index);
        } catch (ProjectException e) {
            actualExceptionMessage = e.getMessage();
        }
        assertEquals(expectedExceptionMessage, actualExceptionMessage);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 2})
    @DisplayName("Element with valid index has been tried to set " +
            "for degenerated array.")
    void setElementToUserIntegerArrayThirdNegativeTest(int index) {

        userIntegerArray = UserIntegerArray
                .createBuilder()
                .integerArray(new int[]{})
                .build();
        String expectedExceptionMessage = "Integer array hasn't been initialized or is " +
                "degenerated. Element setting to array is not available.";
        String actualExceptionMessage = null;
        try {
            userIntegerArray.setElementToUserIntegerArray(index, index);
        } catch (ProjectException e) {
            actualExceptionMessage = e.getMessage();
        }
        assertEquals(expectedExceptionMessage, actualExceptionMessage);
    }

    @Test
    @DisplayName("ID is checked for validity. Array is not initialized.")
    void getUserArrayIdFirstPositiveTest() {

        userIntegerArray = UserIntegerArray.createBuilder().build();
        String integerArrayId = userIntegerArray.getUserArrayId().toString();
        assertTrue(integerArrayId.matches(REGEX_STRING_AS_UUID));
    }

    @Test
    @DisplayName("ID is checked for validity. Array is initialized.")
    void getUserArrayIdSecondPositiveTest() {

        int[] integerArray = new int[]{-20, 5, -5};
        userIntegerArray = UserIntegerArray
                .createBuilder()
                .integerArray(integerArray)
                .build();
        String integerArrayId = userIntegerArray.getUserArrayId().toString();
        assertTrue(integerArrayId.matches(REGEX_STRING_AS_UUID));
    }
}
