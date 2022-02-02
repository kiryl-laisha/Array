package com.laisha.array.entity;

import com.laisha.array.exception.ProjectException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class UserIntegerArrayTest {

    private static UserIntegerArray userIntegerArray;
    private static final String REGEX_STRING_AS_UUID = "^[\\da-fA-F]{8}-[\\da-fA-F]{4}" +
            "-4[\\da-fA-F]{3}-[8-9abAB][\\da-fA-F]{3}-[\\da-fA-F]{12}$";

    @AfterEach
    void tearDown() {

        userIntegerArray = null;
    }

    @Test
    public void createUserIntegerArrayWithNullArrayInitializationTest() {

        String actualExceptionMessage = null;
        try {
            userIntegerArray = new UserIntegerArray(null);
        } catch (ProjectException projectException) {
            actualExceptionMessage = projectException.getMessage();
        }
        String expectedExceptionMessage = "The provided to constructor " +
                "integer array is null.";
        assertEquals(expectedExceptionMessage, actualExceptionMessage);
    }

    @Test
    public void getUserIntegerArrayWithoutArrayInitializationTest() {

        userIntegerArray = new UserIntegerArray();
        assertThrowsExactly(NullPointerException.class,
                userIntegerArray::getUserIntegerArray);
    }

    @Test
    public void getUserIntegerArrayWithArrayInitializationTest() {

        try {
            userIntegerArray = new UserIntegerArray(1, -1, 3);
        } catch (ProjectException e) {
            e.printStackTrace();
        }
        int[] expectedIntegerArray = new int[]{1, -1, 3};
        int[] actualIntegerArray = userIntegerArray.getUserIntegerArray();
        assertArrayEquals(expectedIntegerArray, actualIntegerArray);
    }

    @Test
    public void getUserIntegerArrayAndCheckArrayImmutableTest() {

        try {
            userIntegerArray = new UserIntegerArray(1, -1, 3);
        } catch (ProjectException e) {
            e.printStackTrace();
        }
        int[] temporaryIntegerArray = userIntegerArray.getUserIntegerArray();
        int[] expectedIntegerArray = Arrays.copyOf(temporaryIntegerArray,
                temporaryIntegerArray.length);
        temporaryIntegerArray[0] = 100;
        int[] actualIntegerArray = userIntegerArray.getUserIntegerArray();
        assertArrayEquals(expectedIntegerArray, actualIntegerArray);
    }

    @Test
    public void setUserIntegerArrayTest() {

        userIntegerArray = new UserIntegerArray();
        int[] expectedIntegerArray = new int[]{1, -1, 3};
        try {
            userIntegerArray.setUserIntegerArray(expectedIntegerArray);
        } catch (ProjectException e) {
            e.printStackTrace();
        }
        int[] actualIntegerArray = userIntegerArray.getUserIntegerArray();
        assertArrayEquals(expectedIntegerArray, actualIntegerArray);
    }

    @Test
    public void setUserIntegerArrayByNullTest() {

        String actualExceptionMessage = null;
        userIntegerArray = new UserIntegerArray();
        try {
            userIntegerArray.setUserIntegerArray(null);
        } catch (ProjectException projectException) {
            actualExceptionMessage = projectException.getMessage();
        }
        String expectedExceptionMessage = "The provided integer array is null.";
        assertEquals(expectedExceptionMessage, actualExceptionMessage);
    }

    @Test
    public void setUserIntegerArrayByEmptyArrayTest() {

        userIntegerArray = new UserIntegerArray();
        int[] expectedIntegerArray = new int[]{};
        try {
            userIntegerArray.setUserIntegerArray(expectedIntegerArray);
        } catch (ProjectException e) {
            e.printStackTrace();
        }
        int[] actualIntegerArray = userIntegerArray.getUserIntegerArray();
        assertArrayEquals(expectedIntegerArray, actualIntegerArray);
    }

    @Test
    public void setUserIntegerArrayAndCheckArrayImmutableTest() {

        userIntegerArray = new UserIntegerArray();
        int[] temporaryIntegerArray = new int[]{0, 5, -5};
        int[] expectedIntegerArray = Arrays.copyOf(temporaryIntegerArray,
                temporaryIntegerArray.length);
        try {
            userIntegerArray.setUserIntegerArray(temporaryIntegerArray);
        } catch (ProjectException e) {
            e.printStackTrace();
        }
        temporaryIntegerArray[0] = 100;
        int[] actualIntegerArray = userIntegerArray.getUserIntegerArray();
        assertArrayEquals(expectedIntegerArray, actualIntegerArray);
    }

    @Test
    public void getUserIntegerArrayIdWithoutArrayInitializationTest() {

        userIntegerArray = new UserIntegerArray();
        String integerArrayId = userIntegerArray.getUserIntegerArrayId().toString();
        assertTrue(integerArrayId.matches(REGEX_STRING_AS_UUID));
    }

    @Test
    public void getUserIntegerArrayIdWithArrayInitializationTest() {

        userIntegerArray = null;
        try {
            userIntegerArray = new UserIntegerArray(1, -1, 3);
        } catch (ProjectException e) {
            e.printStackTrace();
        }
        String integerArrayId = userIntegerArray.getUserIntegerArrayId().toString();
        assertTrue(integerArrayId.matches(REGEX_STRING_AS_UUID));
    }
}
