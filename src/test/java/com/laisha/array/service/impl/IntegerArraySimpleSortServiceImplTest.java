package com.laisha.array.service.impl;

import com.laisha.array.entity.UserIntegerArray;
import com.laisha.array.exception.ProjectException;
import com.laisha.array.factory.impl.ArrayFactoryImpl;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IntegerArraySimpleSortServiceImplTest {

    private static IntegerArraySimpleSortServiceImpl integerArraySimpleSortService =
            IntegerArraySimpleSortServiceImpl.getInstance();
    private static ArrayFactoryImpl arrayFactory = ArrayFactoryImpl.getInstance();
    UserIntegerArray userIntegerArray;

    @AfterEach
    void tearDown() {

        userIntegerArray = null;
    }

    @AfterAll
    static void tearDownClass() {

        integerArraySimpleSortService = null;
        arrayFactory = null;
    }

    @Test
    public void sortByBubbleSortingTest() {

        int[] integerArray = new int[]{13, 6, -10, 100, -5};
        try {
            userIntegerArray = arrayFactory.createUserIntegerArray(integerArray);
            integerArraySimpleSortService.sortByBubbleSorting(userIntegerArray);
        } catch (ProjectException projectException) {
            projectException.printStackTrace();
        }
        int[] expectedIntegerArray = new int[]{-10, -5, 6, 13, 100};
        int[] actualIntegerArray = userIntegerArray.getUserIntegerArray();
        assertArrayEquals(expectedIntegerArray, actualIntegerArray);
    }

    @Test
    public void sortByBubbleSortingForOneElementArrayTest() {

        int[] expectedIntegerArray = new int[]{13};
        try {
            userIntegerArray = arrayFactory.createUserIntegerArray(expectedIntegerArray);
            integerArraySimpleSortService.sortByBubbleSorting(userIntegerArray);
        } catch (ProjectException projectException) {
            projectException.printStackTrace();
        }
        int[] actualIntegerArray = userIntegerArray.getUserIntegerArray();
        assertArrayEquals(expectedIntegerArray, actualIntegerArray);
    }

    @Test
    public void sortByBubbleSortingForNotInitializedArrayTest() {

        userIntegerArray = arrayFactory.createUserIntegerArray();
        String actualExceptionMessage = null;
        try {
            integerArraySimpleSortService.sortByBubbleSorting(userIntegerArray);
        } catch (ProjectException projectException) {
            actualExceptionMessage = projectException.getMessage();
        }
        String expectedExceptionMessage = "Integer array of this object is not" +
                "initialized. Method execution is not available.";
        assertEquals(expectedExceptionMessage, actualExceptionMessage);
    }

    @Test
    public void sortByBubbleSortingForDegeneratedArrayTest() {

        String actualExceptionMessage = null;
        try {
            userIntegerArray = arrayFactory.createUserIntegerArray(new int[]{});
            integerArraySimpleSortService.sortByBubbleSorting(userIntegerArray);
        } catch (ProjectException projectException) {
            actualExceptionMessage = projectException.getMessage();
        }
        String expectedExceptionMessage = "Integer array is degenerated. " +
                "Method execution is not available.";
        assertEquals(expectedExceptionMessage, actualExceptionMessage);
    }

    @Test
    public void sortBySelectionTest() {

        int[] integerArray = new int[]{-33, 6, -10, 100, -105};
        try {
            userIntegerArray = arrayFactory.createUserIntegerArray(integerArray);
            integerArraySimpleSortService.sortBySelection(userIntegerArray);
        } catch (ProjectException projectException) {
            projectException.printStackTrace();
        }
        int[] expectedIntegerArray = new int[]{-105, -33, -10, 6, 100};
        int[] actualIntegerArray = userIntegerArray.getUserIntegerArray();
        assertArrayEquals(expectedIntegerArray, actualIntegerArray);
    }

    @Test
    public void sortBySelectionForOneElementArrayTest() {

        int[] expectedIntegerArray = new int[]{9};
        try {
            userIntegerArray = arrayFactory.createUserIntegerArray(expectedIntegerArray);
            integerArraySimpleSortService.sortBySelection(userIntegerArray);
        } catch (ProjectException projectException) {
            projectException.printStackTrace();
        }
        int[] actualIntegerArray = userIntegerArray.getUserIntegerArray();
        assertArrayEquals(expectedIntegerArray, actualIntegerArray);
    }

    @Test
    public void sortBySelectionForNotInitializedArrayTest() {

        userIntegerArray = arrayFactory.createUserIntegerArray();
        String actualExceptionMessage = null;
        try {
            integerArraySimpleSortService.sortBySelection(userIntegerArray);
        } catch (ProjectException projectException) {
            actualExceptionMessage = projectException.getMessage();
        }
        String expectedExceptionMessage = "Integer array of this object is not" +
                "initialized. Method execution is not available.";
        assertEquals(expectedExceptionMessage, actualExceptionMessage);
    }

    @Test
    public void sortBySelectionForDegeneratedArrayTest() {

        String actualExceptionMessage = null;
        try {
            userIntegerArray = arrayFactory.createUserIntegerArray(new int[]{});
            integerArraySimpleSortService.sortBySelection(userIntegerArray);
        } catch (ProjectException projectException) {
            actualExceptionMessage = projectException.getMessage();
        }
        String expectedExceptionMessage = "Integer array is degenerated. " +
                "Method execution is not available.";
        assertEquals(expectedExceptionMessage, actualExceptionMessage);
    }

    @Test
    public void sortByInsertionTest() {

        int[] integerArray = new int[]{-10, 6, -33, 100, -15};
        try {
            userIntegerArray = arrayFactory.createUserIntegerArray(integerArray);
            integerArraySimpleSortService.sortByInsertion(userIntegerArray);
        } catch (ProjectException projectException) {
            projectException.printStackTrace();
        }
        int[] expectedIntegerArray = new int[]{-33, -15, -10, 6, 100};
        int[] actualIntegerArray = userIntegerArray.getUserIntegerArray();
        assertArrayEquals(expectedIntegerArray, actualIntegerArray);
    }

    @Test
    public void sortByInsertionForOneElementArrayTest() {

        int[] expectedIntegerArray = new int[]{9};
        try {
            userIntegerArray = arrayFactory.createUserIntegerArray(expectedIntegerArray);
            integerArraySimpleSortService.sortByInsertion(userIntegerArray);
        } catch (ProjectException projectException) {
            projectException.printStackTrace();
        }
        int[] actualIntegerArray = userIntegerArray.getUserIntegerArray();
        assertArrayEquals(expectedIntegerArray, actualIntegerArray);
    }

    @Test
    public void sortByInsertionForNotInitializedArrayTest() {

        userIntegerArray = arrayFactory.createUserIntegerArray();
        String actualExceptionMessage = null;
        try {
            integerArraySimpleSortService.sortByInsertion(userIntegerArray);
        } catch (ProjectException projectException) {
            actualExceptionMessage = projectException.getMessage();
        }
        String expectedExceptionMessage = "Integer array of this object is not" +
                "initialized. Method execution is not available.";
        assertEquals(expectedExceptionMessage, actualExceptionMessage);
    }

    @Test
    public void sortByInsertionForDegeneratedArrayTest() {

        String actualExceptionMessage = null;
        try {
            userIntegerArray = arrayFactory.createUserIntegerArray(new int[]{});
            integerArraySimpleSortService.sortByInsertion(userIntegerArray);
        } catch (ProjectException projectException) {
            actualExceptionMessage = projectException.getMessage();
        }
        String expectedExceptionMessage = "Integer array is degenerated. " +
                "Method execution is not available.";
        assertEquals(expectedExceptionMessage, actualExceptionMessage);
    }

    @Test
    public void sortByStreamTest() {

        int[] integerArray = new int[]{10, 100, -13, 6, -15};
        try {
            userIntegerArray = arrayFactory.createUserIntegerArray(integerArray);
            integerArraySimpleSortService.sortByStream(userIntegerArray);
        } catch (ProjectException projectException) {
            projectException.printStackTrace();
        }
        int[] expectedIntegerArray = new int[]{-15, -13, 6, 10, 100};
        int[] actualIntegerArray = userIntegerArray.getUserIntegerArray();
        assertArrayEquals(expectedIntegerArray, actualIntegerArray);
    }

    @Test
    public void sortByStreamForOneElementArrayTest() {

        int[] expectedIntegerArray = new int[]{9};
        try {
            userIntegerArray = arrayFactory.createUserIntegerArray(expectedIntegerArray);
            integerArraySimpleSortService.sortByStream(userIntegerArray);
        } catch (ProjectException projectException) {
            projectException.printStackTrace();
        }
        int[] actualIntegerArray = userIntegerArray.getUserIntegerArray();
        assertArrayEquals(expectedIntegerArray, actualIntegerArray);
    }

    @Test
    public void sortByStreamForNotInitializedArrayTest() {

        userIntegerArray = arrayFactory.createUserIntegerArray();
        String actualExceptionMessage = null;
        try {
            integerArraySimpleSortService.sortByStream(userIntegerArray);
        } catch (ProjectException projectException) {
            actualExceptionMessage = projectException.getMessage();
        }
        String expectedExceptionMessage = "Integer array of this object is not" +
                "initialized. Method execution is not available.";
        assertEquals(expectedExceptionMessage, actualExceptionMessage);
    }

    @Test
    public void sortByStreamForDegeneratedArrayTest() {

        String actualExceptionMessage = null;
        try {
            userIntegerArray = arrayFactory.createUserIntegerArray(new int[]{});
            integerArraySimpleSortService.sortByStream(userIntegerArray);
        } catch (ProjectException projectException) {
            actualExceptionMessage = projectException.getMessage();
        }
        String expectedExceptionMessage = "Integer array is degenerated. " +
                "Method execution is not available.";
        assertEquals(expectedExceptionMessage, actualExceptionMessage);
    }
}
