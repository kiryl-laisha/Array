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

class CustomIntegerArrayTest {

    private static CustomIntegerArray customIntegerArray;
    private static final String REGEX_STRING_AS_UUID = "^[\\da-fA-F]{8}-[\\da-fA-F]{4}" +
            "-4[\\da-fA-F]{3}-[8-9abAB][\\da-fA-F]{3}-[\\da-fA-F]{12}$";

    @AfterEach
    void tearDown() {
        customIntegerArray = null;
    }

    @Test
    @DisplayName("Integer array hasn't been initialized.")
    void getCustomIntegerArrayFirstPositiveTest() {

        customIntegerArray = CustomIntegerArray.createBuilder().build();
        String expectedExceptionMessage = "Integer array is null.";
        String actualExceptionMessage = null;
        try {
            customIntegerArray.getCustomIntegerArray();
        } catch (ProjectException e) {
            actualExceptionMessage = e.getMessage();
        }
        assertEquals(expectedExceptionMessage, actualExceptionMessage);
    }

    @ParameterizedTest
    @EmptySource
    @DisplayName("Integer array is initialized by empty source.")
    void getCustomIntegerArraySecondPositiveTest(int[] integerArray) {

        int[] expectedIntegerArray = {};
        customIntegerArray = CustomIntegerArray
                .createBuilder()
                .setIntegerArray(integerArray)
                .build();
        int[] actualIntegerArray = null;
        try {
            actualIntegerArray = customIntegerArray.getCustomIntegerArray();
        } catch (ProjectException e) {
            e.printStackTrace();
        }
        assertArrayEquals(expectedIntegerArray, actualIntegerArray);
    }

    @Test
    @DisplayName("Integer array has been initialized correctly.")
    void getCustomIntegerArrayThirdPositiveTest() {

        int[] expectedIntegerArray = {1, -1, 3};
        customIntegerArray = CustomIntegerArray
                .createBuilder()
                .setIntegerArray(expectedIntegerArray)
                .build();
        int[] actualIntegerArray = new int[]{};
        try {
            actualIntegerArray = customIntegerArray.getCustomIntegerArray();
        } catch (ProjectException e) {
            e.printStackTrace();
        }
        assertArrayEquals(expectedIntegerArray, actualIntegerArray);
    }

    @Test
    @DisplayName("Checking the immutable of an array by reference.")
    void getCustomIntegerArrayFourthPositiveTest() {

        customIntegerArray = CustomIntegerArray
                .createBuilder()
                .setIntegerArray(new int[]{5, -5, 13})
                .build();
        int[] expectedIntegerArray = new int[]{};
        int[] actualIntegerArray = new int[]{};
        try {
            int[] temporaryIntegerArray = customIntegerArray.getCustomIntegerArray();
            expectedIntegerArray = Arrays.copyOf(temporaryIntegerArray,
                    temporaryIntegerArray.length);
            temporaryIntegerArray[0] = 100;
            actualIntegerArray = customIntegerArray.getCustomIntegerArray();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertArrayEquals(expectedIntegerArray, actualIntegerArray);
    }

    @Test
    @DisplayName("Checking the setting by a correct array.")
    void setCustomIntegerArrayFirstPositiveTest() {

        customIntegerArray = CustomIntegerArray.createBuilder().build();
        int[] expectedIntegerArray = new int[]{1, -1, 3};
        customIntegerArray.setCustomIntegerArray(expectedIntegerArray);
        int[] actualIntegerArray = null;
        try {
            actualIntegerArray = customIntegerArray.getCustomIntegerArray();
        } catch (ProjectException e) {
            e.printStackTrace();
        }
        assertArrayEquals(expectedIntegerArray, actualIntegerArray);
    }

    @ParameterizedTest
    @EmptySource
    @DisplayName("Checking the setting by an empty array.")
    void setCustomIntegerArraySecondPositiveTest(int[] integerArray) {

        customIntegerArray = CustomIntegerArray.createBuilder().build();
        int[] expectedIntegerArray = {};
        customIntegerArray.setCustomIntegerArray(integerArray);
        int[] actualIntegerArray = null;
        try {
            actualIntegerArray = customIntegerArray.getCustomIntegerArray();
        } catch (ProjectException e) {
            e.printStackTrace();
        }
        assertArrayEquals(expectedIntegerArray, actualIntegerArray);
    }

    @Test
    @DisplayName("Checking the immutable of an array by reference.")
    void setCustomIntegerArrayThirdPositiveTest() {

        customIntegerArray = CustomIntegerArray.createBuilder().build();
        int[] temporaryIntegerArray = new int[]{0, 5, -5};
        int[] expectedIntegerArray = Arrays.copyOf(temporaryIntegerArray,
                temporaryIntegerArray.length);
        customIntegerArray.setCustomIntegerArray(temporaryIntegerArray);
        temporaryIntegerArray[0] = 100;
        int[] actualIntegerArray = null;
        try {
            actualIntegerArray = customIntegerArray.getCustomIntegerArray();
        } catch (ProjectException e) {
            e.printStackTrace();
        }
        assertArrayEquals(expectedIntegerArray, actualIntegerArray);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2})
    @DisplayName("Element with valid index has been set.")
    void setElementToCustomIntegerArrayFirstPositiveTest(int index) {

        int[] integerArray = new int[]{-10, 5, -5};
        customIntegerArray = CustomIntegerArray
                .createBuilder()
                .setIntegerArray(integerArray)
                .build();
        int expected = index;
        int actual = 0;
        try {
            customIntegerArray.setElementToCustomIntegerArray(index, index);
            actual = customIntegerArray.getCustomIntegerArray()[index];
        } catch (ProjectException e) {
            e.printStackTrace();
        }
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 3, 77})
    @DisplayName("Element with invalid index has been set.")
    void setElementToCustomIntegerArrayFirsNegativeTest(int index) {

        int[] integerArray = new int[]{-20, 5, -5};
        customIntegerArray = CustomIntegerArray
                .createBuilder()
                .setIntegerArray(integerArray)
                .build();
        String expectedExceptionMessage = "Provided element index is out of array " +
                "bounds. Element setting to array is not available.";
        String actualExceptionMessage = null;
        try {
            customIntegerArray.setElementToCustomIntegerArray(index, index);
        } catch (ProjectException e) {
            actualExceptionMessage = e.getMessage();
        }
        assertEquals(expectedExceptionMessage, actualExceptionMessage);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 2})
    @DisplayName("Element with valid index has been tried to set " +
            "for not initialized array.")
    void setElementToCustomIntegerArraySecondNegativeTest(int index) {

        customIntegerArray = CustomIntegerArray.createBuilder().build();
        String expectedExceptionMessage = "Integer array hasn't been initialized or is " +
                "degenerated. Element setting to array is not available.";
        String actualExceptionMessage = null;
        try {
            customIntegerArray.setElementToCustomIntegerArray(index, index);
        } catch (ProjectException e) {
            actualExceptionMessage = e.getMessage();
        }
        assertEquals(expectedExceptionMessage, actualExceptionMessage);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 2})
    @DisplayName("Element with valid index has been tried to set " +
            "for degenerated array.")
    void setElementToCustomIntegerArrayThirdNegativeTest(int index) {

        customIntegerArray = CustomIntegerArray
                .createBuilder()
                .setIntegerArray(new int[]{})
                .build();
        String expectedExceptionMessage = "Integer array hasn't been initialized or is " +
                "degenerated. Element setting to array is not available.";
        String actualExceptionMessage = null;
        try {
            customIntegerArray.setElementToCustomIntegerArray(index, index);
        } catch (ProjectException e) {
            actualExceptionMessage = e.getMessage();
        }
        assertEquals(expectedExceptionMessage, actualExceptionMessage);
    }

    @Test
    @DisplayName("ID is checked for validity. Array is not initialized.")
    void getCustomArrayIdFirstPositiveTest() {

        customIntegerArray = CustomIntegerArray.createBuilder().build();
        String integerArrayId = customIntegerArray.getCustomArrayId().toString();
        assertTrue(integerArrayId.matches(REGEX_STRING_AS_UUID));
    }

    @Test
    @DisplayName("ID is checked for validity. Array is initialized.")
    void getCustomArrayIdSecondPositiveTest() {

        int[] integerArray = new int[]{-20, 5, -5};
        customIntegerArray = CustomIntegerArray
                .createBuilder()
                .setIntegerArray(integerArray)
                .build();
        String integerArrayId = customIntegerArray.getCustomArrayId().toString();
        assertTrue(integerArrayId.matches(REGEX_STRING_AS_UUID));
    }
}
