package com.laisha.array.observer.impl;

import com.laisha.array.creator.impl.CustomArrayCreatorImpl;
import com.laisha.array.entity.CustomArray;
import com.laisha.array.entity.CustomIntegerArray;
import com.laisha.array.entity.CustomArrayStatistics;
import com.laisha.array.entity.CustomIntegerArrayStatistics;
import com.laisha.array.warehouse.CustomArrayWarehouse;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class CustomIntegerArrayObserverImplTest {

    static CustomArrayCreatorImpl arrayCreator = CustomArrayCreatorImpl.getInstance();
    static CustomArrayWarehouse warehouse = CustomArrayWarehouse.getInstance();
    CustomArray customArray;

    @AfterEach
    void tearDown() {
        customArray = null;
    }

    @AfterAll
    static void tearDownClass() {

        arrayCreator = null;
        warehouse = null;
    }

    @ParameterizedTest
    @EmptySource
    @DisplayName("Array Statistics object is put to warehouse after " +
            "correct integer array is set.")
    void changeParametersFirstPositiveTest(int... integerArray) {

        customArray = arrayCreator.createCustomArray(integerArray);
        int size = warehouse.size();
        ((CustomIntegerArray) customArray).setCustomIntegerArray(0, 2, 4);
        int expected = size + 1;//object is added to warehouse
        int actual = warehouse.size();
        warehouse.remove(customArray.getCustomArrayId());
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Array Statistics object is replaced to warehouse after " +
            "correct integer array is set.")
    void changeParametersSecondPositiveTest() {

        Optional<CustomArrayStatistics> userArrayStatistics =
                new CustomIntegerArrayStatistics.Builder()
                        .setMinElement(1)
                        .setMaxElement(5)
                        .setAverageValue(3)
                        .setTotalSum(9)
                        .setNegativeElementQuantity(0)
                        .setZeroElementQuantity(0)
                        .build();
        CustomArrayStatistics expectedArrayStatistics = null;
        if (userArrayStatistics.isPresent()) {
            expectedArrayStatistics = userArrayStatistics.get();
        }
        int[] integerArray = {0, 2, 4};
        customArray = arrayCreator.createCustomArray(integerArray);
        ((CustomIntegerArray) customArray).setCustomIntegerArray(1, 3, 5);
        CustomArrayStatistics actualArrayStatistics = warehouse.get(customArray.getCustomArrayId());
        warehouse.remove(customArray.getCustomArrayId());
        assertEquals(expectedArrayStatistics, actualArrayStatistics);
    }

    @Test
    @DisplayName("Array Statistics object is replaced to warehouse after " +
            "correct integer array is set. Warehouse size is immutable.")
    void changeParametersThirdPositiveTest() {

        int[] integerArray = {0, 2, 4};
        customArray = arrayCreator.createCustomArray(integerArray);
        int expected = warehouse.size();
        ((CustomIntegerArray) customArray).setCustomIntegerArray(1, 3, 5);
        int actual = warehouse.size();
        warehouse.remove(customArray.getCustomArrayId());
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @EmptySource
    @DisplayName("Array Statistics object is removed to warehouse after " +
            "empty array for integer array is set.")
    void changeParametersFirstNegativeTest(int... integerArray) {

        int[] firstIntegerArray = {0, 2, 4};
        customArray = arrayCreator.createCustomArray(firstIntegerArray);
        int size = warehouse.size();
        ((CustomIntegerArray) customArray).setCustomIntegerArray(integerArray);
        int expected = size - 1;//object is removed from warehouse
        int actual = warehouse.size();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Array Statistics object is put to warehouse after " +
            "correct integer array is set. Warehouse size is changed.")
    void changeParametersSecondNegativeTest() {

        int[] integerArray = {};
        customArray = arrayCreator.createCustomArray(integerArray);
        int expected = warehouse.size();
        ((CustomIntegerArray) customArray).setCustomIntegerArray(1, 3, 5);
        int actual = warehouse.size();
        warehouse.remove(customArray.getCustomArrayId());
        assertNotEquals(expected, actual);
    }
}