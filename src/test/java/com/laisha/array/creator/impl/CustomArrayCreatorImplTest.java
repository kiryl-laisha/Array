package com.laisha.array.creator.impl;

import com.laisha.array.entity.CustomArray;
import com.laisha.array.entity.CustomIntegerArray;
import com.laisha.array.exception.ProjectException;
import com.laisha.array.observer.CustomArrayObserver;
import com.laisha.array.repository.CustomArrayRepository;
import com.laisha.array.warehouse.CustomArrayWarehouse;
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

class CustomArrayCreatorImplTest {

    static CustomArrayCreatorImpl arrayCreator = CustomArrayCreatorImpl.getInstance();
    static CustomArrayRepository repository = CustomArrayRepository.getInstance();
    static CustomArrayWarehouse warehouse = CustomArrayWarehouse.getInstance();
    static CustomArray customArray;

    @AfterEach
    void tearDown() {
        customArray = null;
    }

    @AfterAll
    static void tearDownClass() {

        arrayCreator = null;
        repository = null;
        warehouse = null;
    }

    @Test
    @DisplayName("Integer array hasn't been initialized.")
    void createCustomArrayFirstNegativeTest() {

        customArray = arrayCreator.createCustomArray();
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
    @DisplayName("Object has been added to repository.")
    void createCustomArrayFirstPositiveTest() {

        int size = repository.size();
        customArray = arrayCreator.createCustomArray();
        int expected = size + 1;//One object has been added to repository
        int actual = repository.size();
        repository.remove(customArray);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Array observer has been added to custom array object.")
    void createCustomArraySecondPositiveTest() {

        customArray = arrayCreator.createCustomArray();
        int expected = 1;
        int actual = customArray.getCustomArrayObservers().size();
        CustomArrayObserver arrayObserver = customArray.getCustomArrayObservers().get(0);
        customArray.detach(arrayObserver);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @NullSource
    @DisplayName("Integer array hasn't been initialized.")
    void createCustomArrayFirstNegativeTest(int... integerArray) {

        customArray = arrayCreator.createCustomArray(integerArray);
        String expectedExceptionMessage = "Integer array is null.";
        String actualExceptionMessage = null;
        try {
            ((CustomIntegerArray) customArray).getCustomIntegerArray();
        } catch (ProjectException e) {
            actualExceptionMessage = e.getMessage();
        }
        assertEquals(expectedExceptionMessage, actualExceptionMessage);
    }

    @ParameterizedTest
    @EmptySource
    @DisplayName("Integer array is initialized by empty source.")
    void createCustomArrayFirstPositiveTest(int... integerArray) {

        customArray = CustomIntegerArray
                .createBuilder()
                .setIntegerArray(integerArray)
                .build();
        int[] expectedIntegerArray = {};
        int[] actualIntegerArray = null;
        try {
            actualIntegerArray = ((CustomIntegerArray) customArray).getCustomIntegerArray();
        } catch (ProjectException e) {
            e.printStackTrace();
        }
        assertArrayEquals(expectedIntegerArray, actualIntegerArray);
    }

    @Test
    @DisplayName("Integer array is initialized by valid array.")
    void createCustomArrayThirdPositiveTest() {

        int[] expectedIntegerArray = {1, 4, 6};
        customArray = CustomIntegerArray
                .createBuilder()
                .setIntegerArray(expectedIntegerArray)
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
    @DisplayName("Object has been added to repository.")
    void createCustomArrayFourthPositiveTest() {

        int[] integerArray = {1, 4, 6};
        int size = repository.size();
        customArray = arrayCreator.createCustomArray(integerArray);
        int expected = size + 1;//One object has been added to repository
        int actual = repository.size();
        repository.remove(customArray);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Array observer has been added to custom array object.")
    void createCustomArrayFifthPositiveTest() {

        int[] integerArray = {1, 4, 6};
        customArray = arrayCreator.createCustomArray(integerArray);
        int expected = 1;//One observer has been added to list
        int actual = customArray.getCustomArrayObservers().size();
        CustomArrayObserver arrayObserver = customArray.getCustomArrayObservers().get(0);
        customArray.detach(arrayObserver);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("Object hasn't been added to warehouse. Integer array is null or empty.")
    void createCustomArraySecondNegativeTest(int... integerArray) {

        int expected = warehouse.size();
        customArray = arrayCreator.createCustomArray(integerArray);
        int actual = warehouse.size();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Object has been added to warehouse.")
    void createCustomArraySixthPositiveTest() {

        int[] integerArray = {1, 4, 6};
        int size = warehouse.size();
        customArray = arrayCreator.createCustomArray(integerArray);
        int expected = size + 1;//One object has been added to warehouse
        int actual = warehouse.size();
        warehouse.remove(customArray.getCustomArrayId());
        assertEquals(expected, actual);
    }
}