package com.laisha.array.factory.impl;

import com.laisha.array.entity.CustomArray;
import com.laisha.array.entity.CustomIntegerArray;
import com.laisha.array.exception.ProjectException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;

import static org.junit.jupiter.api.Assertions.*;

class CustomArrayFactoryImplTest {

    private static CustomArrayFactoryImpl arrayFactory = CustomArrayFactoryImpl.getInstance();
    private static CustomArray customArray;
    private static final String REGEX_STRING_AS_UUID = "^[\\da-fA-F]{8}-[\\da-fA-F]{4}" +
            "-4[\\da-fA-F]{3}-[8-9abAB][\\da-fA-F]{3}-[\\da-fA-F]{12}$";

    @AfterEach
    void tearDown() {
        customArray = null;
    }

    @AfterAll
    static void tearDownClass() {
        arrayFactory = null;
    }

    @Test
    @DisplayName("Integer array hasn't been initialized.")
    void createUserArrayFirstPositiveTest() {

        customArray = arrayFactory.createCustomArray();
        String expectedExceptionMessage = "Integer array is null.";
        String actualExceptionMessage = null;
        try {
            ((CustomIntegerArray) customArray).getCustomIntegerArray();
        } catch (ProjectException e) {
            actualExceptionMessage = e.getMessage();
        }
        assertEquals(expectedExceptionMessage, actualExceptionMessage);
    }

    @Test
    @DisplayName("ID is checked for validity. Array is not initialized.")
    void createUserArraySecondPositiveTest() {

        customArray = CustomIntegerArray.createBuilder().build();
        String integerArrayId = customArray.getCustomArrayId().toString();
        assertTrue(integerArrayId.matches(REGEX_STRING_AS_UUID));
    }

    @ParameterizedTest
    @EmptySource
    @DisplayName("Integer array is initialized by empty source.")
    void createUserArrayThirdPositiveTest(int[] integerArray) {

        int[] expectedIntegerArray = {};
        customArray = CustomIntegerArray
                .createBuilder()
                .setIntegerArray(integerArray)
                .build();
        int[] actualIntegerArray = null;
        try {
            actualIntegerArray = ((CustomIntegerArray) customArray).getCustomIntegerArray();
        } catch (ProjectException e) {
            e.printStackTrace();
        }
        assertArrayEquals(expectedIntegerArray, actualIntegerArray);
    }

    @Test
    @DisplayName("Integer array has been initialized correctly.")
    void createUserArrayFourthPositiveTest() {

        int[] expectedIntegerArray = {1, -1, 3};
        customArray = CustomIntegerArray
                .createBuilder()
                .setIntegerArray(expectedIntegerArray)
                .build();
        int[] actualIntegerArray = new int[]{};
        try {
            actualIntegerArray = ((CustomIntegerArray) customArray).getCustomIntegerArray();
        } catch (ProjectException e) {
            e.printStackTrace();
        }
        assertArrayEquals(expectedIntegerArray, actualIntegerArray);
    }

    @Test
    @DisplayName("ID is checked for validity. Array is initialized.")
    void getUserArrayIdSecondPositiveTest() {

        int[] integerArray = new int[]{-20, 5, -5};
        customArray = CustomIntegerArray
                .createBuilder()
                .setIntegerArray(integerArray)
                .build();
        String integerArrayId = customArray.getCustomArrayId().toString();
        assertTrue(integerArrayId.matches(REGEX_STRING_AS_UUID));
    }
}
