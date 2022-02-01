package com.laisha.array.service.impl;

import com.laisha.array.entity.UserIntegerArray;
import com.laisha.array.exception.ProjectException;
import com.laisha.array.factory.impl.ArrayFactoryImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IntegerArraySortServiceImplTest {

    private static final IntegerArraySortServiceImpl integerArraySortService =
            IntegerArraySortServiceImpl.getInstance();
    private static final ArrayFactoryImpl arrayFactory = ArrayFactoryImpl.getInstance();
    UserIntegerArray userIntegerArray;
    UserIntegerArray otherUserIntegerArray;

    @AfterEach
    void tearDown() {

        userIntegerArray = null;
        otherUserIntegerArray = null;
    }

    @Test
    public void sortByBubbleSorting() {

        int[] integerArray = new int[]{13, 6, -10, 100, -5};
        try {
            userIntegerArray = arrayFactory.createUserIntegerArray(integerArray);
            otherUserIntegerArray = integerArraySortService
                    .sortByBubbleSorting(userIntegerArray);
        } catch (ProjectException projectException) {
            projectException.printStackTrace();
        }
        int[] expectedIntegerArray = new int[]{-10, -5, 6, 13, 100};
        int[] actualIntegerArray = otherUserIntegerArray.getUserIntegerArray();
        assertArrayEquals(expectedIntegerArray, actualIntegerArray);
    }

    @Test
    public void sortByBubbleSortingForOneElementArray() {

        int[] expectedIntegerArray = new int[]{13};
        try {
            userIntegerArray = arrayFactory.createUserIntegerArray(expectedIntegerArray);
            otherUserIntegerArray = integerArraySortService
                    .sortByBubbleSorting(userIntegerArray);
        } catch (ProjectException projectException) {
            projectException.printStackTrace();
        }
        int[] actualIntegerArray = otherUserIntegerArray.getUserIntegerArray();
        assertArrayEquals(expectedIntegerArray, actualIntegerArray);
    }

    @Test
    public void sortByBubbleSortingForNotInitializedArray() {

        userIntegerArray = arrayFactory.createUserIntegerArray();
        String actualExceptionMessage = null;
        try {
            integerArraySortService.sortByBubbleSorting(userIntegerArray);
        } catch (ProjectException projectException) {
            actualExceptionMessage = projectException.getMessage();
        }
        String expectedExceptionMessage = "Integer array of this object is not" +
                "initialized. Method execution is not available.";
        assertEquals(expectedExceptionMessage, actualExceptionMessage);
    }

    @Test
    public void sortByBubbleSortingForDegeneratedArray() {

        String actualExceptionMessage = null;
        try {
            userIntegerArray = arrayFactory.createUserIntegerArray(new int[]{});
            integerArraySortService.sortByBubbleSorting(userIntegerArray);
        } catch (ProjectException projectException) {
            actualExceptionMessage = projectException.getMessage();
        }
        String expectedExceptionMessage = "Integer array is degenerated. " +
                "Method execution is not available.";
        assertEquals(expectedExceptionMessage, actualExceptionMessage);
    }

    @Test
    public void sortByBubbleSortingAndCheckArrayCoping() {

        UserIntegerArray otherUserIntegerArray = new UserIntegerArray();
        int[] integerArray = new int[]{13, 6, -10, 100, -5};
        try {
            userIntegerArray = arrayFactory.createUserIntegerArray(integerArray);
            otherUserIntegerArray = integerArraySortService
                    .sortByBubbleSorting(userIntegerArray);
        } catch (ProjectException projectException) {
            projectException.printStackTrace();
        }
        int[] expectedIntegerArray = userIntegerArray.getUserIntegerArray();
        int[] actualIntegerArray = otherUserIntegerArray.getUserIntegerArray();
        assertNotEquals(expectedIntegerArray, actualIntegerArray);
    }

    @Test
    public void sortBySelection() {

        int[] integerArray = new int[]{-33, 6, -10, 100, -105};
        try {
            userIntegerArray = arrayFactory.createUserIntegerArray(integerArray);
            otherUserIntegerArray = integerArraySortService
                    .sortBySelection(userIntegerArray);
        } catch (ProjectException projectException) {
            projectException.printStackTrace();
        }
        int[] expectedIntegerArray = new int[]{-105, -33, -10, 6, 100};
        int[] actualIntegerArray = otherUserIntegerArray.getUserIntegerArray();
        assertArrayEquals(expectedIntegerArray, actualIntegerArray);
    }

    @Test
    public void sortBySelectionForOneElementArray() {

        int[] expectedIntegerArray = new int[]{9};
        try {
            userIntegerArray = arrayFactory.createUserIntegerArray(expectedIntegerArray);
            otherUserIntegerArray = integerArraySortService
                    .sortBySelection(userIntegerArray);
        } catch (ProjectException projectException) {
            projectException.printStackTrace();
        }
        int[] actualIntegerArray = otherUserIntegerArray.getUserIntegerArray();
        assertArrayEquals(expectedIntegerArray, actualIntegerArray);
    }

    @Test
    public void sortBySelectionForNotInitializedArray() {

        userIntegerArray = arrayFactory.createUserIntegerArray();
        String actualExceptionMessage = null;
        try {
            integerArraySortService.sortBySelection(userIntegerArray);
        } catch (ProjectException projectException) {
            actualExceptionMessage = projectException.getMessage();
        }
        String expectedExceptionMessage = "Integer array of this object is not" +
                "initialized. Method execution is not available.";
        assertEquals(expectedExceptionMessage, actualExceptionMessage);
    }

    @Test
    public void sortBySelectionForDegeneratedArray() {

        String actualExceptionMessage = null;
        try {
            userIntegerArray = arrayFactory.createUserIntegerArray(new int[]{});
            integerArraySortService.sortBySelection(userIntegerArray);
        } catch (ProjectException projectException) {
            actualExceptionMessage = projectException.getMessage();
        }
        String expectedExceptionMessage = "Integer array is degenerated. " +
                "Method execution is not available.";
        assertEquals(expectedExceptionMessage, actualExceptionMessage);
    }

    @Test
    public void sortBySelectionAndCheckArrayCoping() {

        UserIntegerArray otherUserIntegerArray = new UserIntegerArray();
        int[] integerArray = new int[]{13, 6, -10, 100, -5};
        try {
            userIntegerArray = arrayFactory.createUserIntegerArray(integerArray);
            otherUserIntegerArray = integerArraySortService
                    .sortBySelection(userIntegerArray);
        } catch (ProjectException projectException) {
            projectException.printStackTrace();
        }
        int[] expectedIntegerArray = userIntegerArray.getUserIntegerArray();
        int[] actualIntegerArray = otherUserIntegerArray.getUserIntegerArray();
        assertNotEquals(expectedIntegerArray, actualIntegerArray);
    }

    @Test
    public void sortByInsertion() {

        int[] integerArray = new int[]{-10, 6, -33, 100, -15};
        try {
            userIntegerArray = arrayFactory.createUserIntegerArray(integerArray);
            otherUserIntegerArray = integerArraySortService
                    .sortByInsertion(userIntegerArray);
        } catch (ProjectException projectException) {
            projectException.printStackTrace();
        }
        int[] expectedIntegerArray = new int[]{-33, -15, -10, 6, 100};
        int[] actualIntegerArray = otherUserIntegerArray.getUserIntegerArray();
        assertArrayEquals(expectedIntegerArray, actualIntegerArray);
    }

    @Test
    public void sortByInsertionForOneElementArray() {

        int[] expectedIntegerArray = new int[]{9};
        try {
            userIntegerArray = arrayFactory.createUserIntegerArray(expectedIntegerArray);
            otherUserIntegerArray = integerArraySortService
                    .sortByInsertion(userIntegerArray);
        } catch (ProjectException projectException) {
            projectException.printStackTrace();
        }
        int[] actualIntegerArray = otherUserIntegerArray.getUserIntegerArray();
        assertArrayEquals(expectedIntegerArray, actualIntegerArray);
    }

    @Test
    public void sortByInsertionForNotInitializedArray() {

        userIntegerArray = arrayFactory.createUserIntegerArray();
        String actualExceptionMessage = null;
        try {
            integerArraySortService.sortByInsertion(userIntegerArray);
        } catch (ProjectException projectException) {
            actualExceptionMessage = projectException.getMessage();
        }
        String expectedExceptionMessage = "Integer array of this object is not" +
                "initialized. Method execution is not available.";
        assertEquals(expectedExceptionMessage, actualExceptionMessage);
    }

    @Test
    public void sortByInsertionForDegeneratedArray() {

        String actualExceptionMessage = null;
        try {
            userIntegerArray = arrayFactory.createUserIntegerArray(new int[]{});
            integerArraySortService.sortByInsertion(userIntegerArray);
        } catch (ProjectException projectException) {
            actualExceptionMessage = projectException.getMessage();
        }
        String expectedExceptionMessage = "Integer array is degenerated. " +
                "Method execution is not available.";
        assertEquals(expectedExceptionMessage, actualExceptionMessage);
    }

    @Test
    public void sortByInsertionAndCheckArrayCoping() {

        UserIntegerArray otherUserIntegerArray = new UserIntegerArray();
        int[] integerArray = new int[]{13, 6, -10, 100, -5};
        try {
            userIntegerArray = arrayFactory.createUserIntegerArray(integerArray);
            otherUserIntegerArray = integerArraySortService
                    .sortByInsertion(userIntegerArray);
        } catch (ProjectException projectException) {
            projectException.printStackTrace();
        }
        int[] expectedIntegerArray = userIntegerArray.getUserIntegerArray();
        int[] actualIntegerArray = otherUserIntegerArray.getUserIntegerArray();
        assertNotEquals(expectedIntegerArray, actualIntegerArray);
    }

    @Test
    public void sortByStream() {

        int[] integerArray = new int[]{10, 100, -13, 6, -15};
        try {
            userIntegerArray = arrayFactory.createUserIntegerArray(integerArray);
            otherUserIntegerArray = integerArraySortService
                    .sortByStream(userIntegerArray);
        } catch (ProjectException projectException) {
            projectException.printStackTrace();
        }
        int[] expectedIntegerArray = new int[]{-15, -13, 6, 10, 100};
        int[] actualIntegerArray = otherUserIntegerArray.getUserIntegerArray();
        assertArrayEquals(expectedIntegerArray, actualIntegerArray);
    }

    @Test
    public void sortByStreamForOneElementArray() {

        int[] expectedIntegerArray = new int[]{9};
        try {
            userIntegerArray = arrayFactory.createUserIntegerArray(expectedIntegerArray);
            otherUserIntegerArray = integerArraySortService
                    .sortByStream(userIntegerArray);
        } catch (ProjectException projectException) {
            projectException.printStackTrace();
        }
        int[] actualIntegerArray = otherUserIntegerArray.getUserIntegerArray();
        assertArrayEquals(expectedIntegerArray, actualIntegerArray);
    }

    @Test
    public void sortByStreamForNotInitializedArray() {

        userIntegerArray = arrayFactory.createUserIntegerArray();
        String actualExceptionMessage = null;
        try {
            integerArraySortService.sortByStream(userIntegerArray);
        } catch (ProjectException projectException) {
            actualExceptionMessage = projectException.getMessage();
        }
        String expectedExceptionMessage = "Integer array of this object is not" +
                "initialized. Method execution is not available.";
        assertEquals(expectedExceptionMessage, actualExceptionMessage);
    }

    @Test
    public void sortByStreamForDegeneratedArray() {

        String actualExceptionMessage = null;
        try {
            userIntegerArray = arrayFactory.createUserIntegerArray(new int[]{});
            integerArraySortService.sortByStream(userIntegerArray);
        } catch (ProjectException projectException) {
            actualExceptionMessage = projectException.getMessage();
        }
        String expectedExceptionMessage = "Integer array is degenerated. " +
                "Method execution is not available.";
        assertEquals(expectedExceptionMessage, actualExceptionMessage);
    }

    @Test
    public void sortByStreamAndCheckArrayCoping() {

        UserIntegerArray otherUserIntegerArray = new UserIntegerArray();
        int[] integerArray = new int[]{13, 6, -10, 100, -5};
        try {
            userIntegerArray = arrayFactory.createUserIntegerArray(integerArray);
            otherUserIntegerArray = integerArraySortService
                    .sortByStream(userIntegerArray);
        } catch (ProjectException projectException) {
            projectException.printStackTrace();
        }
        int[] expectedIntegerArray = userIntegerArray.getUserIntegerArray();
        int[] actualIntegerArray = otherUserIntegerArray.getUserIntegerArray();
        assertNotEquals(expectedIntegerArray, actualIntegerArray);
    }
}
