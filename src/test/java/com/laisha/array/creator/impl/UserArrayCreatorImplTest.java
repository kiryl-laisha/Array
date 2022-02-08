package com.laisha.array.creator.impl;

import com.laisha.array.entity.UserArray;
import com.laisha.array.entity.UserIntegerArray;
import com.laisha.array.exception.ProjectException;
import com.laisha.array.observer.UserArrayObserver;
import com.laisha.array.repository.UserArrayRepository;
import com.laisha.array.warehouse.UserArrayWarehouse;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class UserArrayCreatorImplTest {

    static UserArrayCreatorImpl arrayCreator = UserArrayCreatorImpl.getInstance();
    static UserArrayRepository repository = UserArrayRepository.getInstance();
    static UserArrayWarehouse warehouse = UserArrayWarehouse.getInstance();
    static UserArray userArray;

    @AfterEach
    void tearDown() {
        userArray = null;
    }

    @AfterAll
    static void tearDownClass() {

        arrayCreator = null;
        repository = null;
        warehouse = null;
    }

    @Test
    @DisplayName("Integer array hasn't been initialized.")
    void createUserArrayFirstNegativeTest() {

        userArray = arrayCreator.createUserArray();
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
    @DisplayName("Object has been added to repository.")
    void createUserArrayFirstPositiveTest() {

        int size = repository.size();
        userArray = arrayCreator.createUserArray();
        int expected = size + 1;//One object has been added to repository
        int actual = repository.size();
        repository.remove(userArray);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Array observer has been added to user array object.")
    void createUserArraySecondPositiveTest() {

        userArray = arrayCreator.createUserArray();
        int expected = 1;
        int actual = userArray.getArrayObservers().size();
        UserArrayObserver arrayObserver = userArray.getArrayObservers().get(0);
        userArray.detach(arrayObserver);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @NullSource
    @DisplayName("Integer array hasn't been initialized.")
    void createUserArrayFirstNegativeTest(int... integerArray) {

        userArray = arrayCreator.createUserArray(integerArray);
        String expectedExceptionMessage = "Integer array is null.";
        String actualExceptionMessage = null;
        try {
            ((UserIntegerArray) userArray).getUserIntegerArray();
        } catch (ProjectException e) {
            actualExceptionMessage = e.getMessage();
        }
        assertEquals(expectedExceptionMessage, actualExceptionMessage);
    }

    @ParameterizedTest
    @EmptySource
    @DisplayName("Integer array is initialized by empty source.")
    void createUserArrayFirstPositiveTest(int... integerArray) {

        userArray = UserIntegerArray
                .createBuilder()
                .integerArray(integerArray)
                .build();
        int[] expectedIntegerArray = {};
        int[] actualIntegerArray = null;
        try {
            actualIntegerArray = ((UserIntegerArray) userArray).getUserIntegerArray();
        } catch (ProjectException e) {
            e.printStackTrace();
        }
        assertArrayEquals(expectedIntegerArray, actualIntegerArray);
    }

    @Test
    @DisplayName("Integer array is initialized by valid array.")
    void createUserArrayThirdPositiveTest() {

        int[] expectedIntegerArray = {1, 4, 6};
        userArray = UserIntegerArray
                .createBuilder()
                .integerArray(expectedIntegerArray)
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
    @DisplayName("Object has been added to repository.")
    void createUserArrayFourthPositiveTest() {

        int[] integerArray = {1, 4, 6};
        int size = repository.size();
        userArray = arrayCreator.createUserArray(integerArray);
        int expected = size + 1;//One object has been added to repository
        int actual = repository.size();
        repository.remove(userArray);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Array observer has been added to user array object.")
    void createUserArrayFifthPositiveTest() {

        int[] integerArray = {1, 4, 6};
        userArray = arrayCreator.createUserArray(integerArray);
        int expected = 1;//One observer has been added to list
        int actual = userArray.getArrayObservers().size();
        UserArrayObserver arrayObserver = userArray.getArrayObservers().get(0);
        userArray.detach(arrayObserver);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("Object hasn't been added to warehouse. Integer array is null or empty.")
    void createUserArraySecondNegativeTest(int... integerArray) {

        int expected = warehouse.size();
        userArray = arrayCreator.createUserArray(integerArray);
        int actual = warehouse.size();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Object has been added to warehouse.")
    void createUserArraySixthPositiveTest() {

        int[] integerArray = {1, 4, 6};
        int size = warehouse.size();
        userArray = arrayCreator.createUserArray(integerArray);
        int expected = size + 1;//One object has been added to warehouse
        int actual = warehouse.size();
        warehouse.remove(userArray.getUserArrayId());
        assertEquals(expected, actual);
    }
}