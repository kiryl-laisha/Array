package com.laisha.array.factory.impl;

import com.laisha.array.entity.UserIntegerArray;
import com.laisha.array.exception.ProjectException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayFactoryImplTest {

    private static ArrayFactoryImpl arrayFactory = ArrayFactoryImpl.getInstance();
    private static UserIntegerArray userIntegerArray;
    private static final String REGEX_STRING_AS_UUID = "^[\\da-fA-F]{8}-[\\da-fA-F]{4}" +
            "-4[\\da-fA-F]{3}-[8-9abAB][\\da-fA-F]{3}-[\\da-fA-F]{12}$";

    @AfterEach
    void tearDown() {

        userIntegerArray = null;
    }

    @AfterAll
    static void tearDownClass() {

        arrayFactory = null;
    }

    @Test
    public void createUserIntegerArrayWithNullInitializedParameterTest() {

        String actualExceptionMessage = null;
        try {
            userIntegerArray = arrayFactory.createUserIntegerArray(null);
        } catch (ProjectException projectException) {
            actualExceptionMessage = projectException.getMessage();
        }
        String expectedExceptionMessage = "Object creation is not available.";
        assertEquals(expectedExceptionMessage, actualExceptionMessage);
    }

    @Test
    public void getUserIntegerArrayWithoutArrayInitializationTest() {

        userIntegerArray = arrayFactory.createUserIntegerArray();
        assertThrowsExactly(NullPointerException.class,
                userIntegerArray::getUserIntegerArray);
    }

    @Test
    public void getUserIntegerArrayWithArrayInitializationTest() {

        try {
            userIntegerArray = arrayFactory.createUserIntegerArray(-1, 0, 1);
        } catch (ProjectException e) {
            e.printStackTrace();
        }
        int[] expectedIntegerArray = new int[]{-1, 0, 1};
        int[] actualIntegerArray = userIntegerArray.getUserIntegerArray();
        assertArrayEquals(expectedIntegerArray, actualIntegerArray);
    }

    @Test
    public void getUserIntegerArrayIdWithoutArrayInitializationTest() {

        userIntegerArray = arrayFactory.createUserIntegerArray();
        String integerArrayId = userIntegerArray.getUserIntegerArrayId().toString();
        assertTrue(integerArrayId.matches(REGEX_STRING_AS_UUID));
    }

    @Test
    public void getUserIntegerArrayIdWithArrayInitializationTest() {

        userIntegerArray = null;
        try {
            userIntegerArray = new UserIntegerArray(-1, 0, 1);
        } catch (ProjectException e) {
            e.printStackTrace();
        }
        String integerArrayId = userIntegerArray.getUserIntegerArrayId().toString();
        assertTrue(integerArrayId.matches(REGEX_STRING_AS_UUID));
    }
}
