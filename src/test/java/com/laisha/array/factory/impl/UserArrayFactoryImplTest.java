package com.laisha.array.factory.impl;

import com.laisha.array.entity.UserArray;
import com.laisha.array.entity.UserIntegerArray;
import com.laisha.array.exception.ProjectException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;

import static org.junit.jupiter.api.Assertions.*;

class UserArrayFactoryImplTest {

    private static UserArrayFactoryImpl arrayFactory = UserArrayFactoryImpl.getInstance();
    private static UserArray userArray;
    private static final String REGEX_STRING_AS_UUID = "^[\\da-fA-F]{8}-[\\da-fA-F]{4}" +
            "-4[\\da-fA-F]{3}-[8-9abAB][\\da-fA-F]{3}-[\\da-fA-F]{12}$";

    @AfterEach
    void tearDown() {
        userArray = null;
    }

    @AfterAll
    static void tearDownClass() {
        arrayFactory = null;
    }

    @Test
    @DisplayName("Integer array hasn't been initialized.")
    void createUserArrayFirstPositiveTest() {

        userArray = arrayFactory.createUserArray();
        String expectedExceptionMessage = "Integer array is null.";
        String actualExceptionMessage = null;
        try {
            ((UserIntegerArray) userArray).getUserIntegerArray();
        } catch (ProjectException e) {
            actualExceptionMessage = e.getMessage();
        }
        assertEquals(expectedExceptionMessage, actualExceptionMessage);
    }

    @Test
    @DisplayName("ID is checked for validity. Array is not initialized.")
    void createUserArraySecondPositiveTest() {

        userArray = UserIntegerArray.createBuilder().build();
        String integerArrayId = userArray.getUserArrayId().toString();
        assertTrue(integerArrayId.matches(REGEX_STRING_AS_UUID));
    }

    @ParameterizedTest
    @EmptySource
    @DisplayName("Integer array is initialized by empty source.")
    void createUserArrayThirdPositiveTest(int[] integerArray) {

        int[] expectedIntegerArray = {};
        userArray = UserIntegerArray
                .createBuilder()
                .integerArray(integerArray)
                .build();
        int[] actualIntegerArray = null;
        try {
            actualIntegerArray = ((UserIntegerArray) userArray).getUserIntegerArray();
        } catch (ProjectException e) {
            e.printStackTrace();
        }
        assertArrayEquals(expectedIntegerArray, actualIntegerArray);
    }

    @Test
    @DisplayName("Integer array has been initialized correctly.")
    void createUserArrayFourthPositiveTest() {

        int[] expectedIntegerArray = {1, -1, 3};
        userArray = UserIntegerArray
                .createBuilder()
                .integerArray(expectedIntegerArray)
                .build();
        int[] actualIntegerArray = new int[]{};
        try {
            actualIntegerArray = ((UserIntegerArray) userArray).getUserIntegerArray();
        } catch (ProjectException e) {
            e.printStackTrace();
        }
        assertArrayEquals(expectedIntegerArray, actualIntegerArray);
    }

    @Test
    @DisplayName("ID is checked for validity. Array is initialized.")
    void getUserArrayIdSecondPositiveTest() {

        int[] integerArray = new int[]{-20, 5, -5};
        userArray = UserIntegerArray
                .createBuilder()
                .integerArray(integerArray)
                .build();
        String integerArrayId = userArray.getUserArrayId().toString();
        assertTrue(integerArrayId.matches(REGEX_STRING_AS_UUID));
    }
}
