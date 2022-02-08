package com.laisha.array.observer.impl;

import com.laisha.array.creator.impl.UserArrayCreatorImpl;
import com.laisha.array.entity.UserArray;
import com.laisha.array.entity.UserArrayStatistics;
import com.laisha.array.entity.UserIntegerArray;
import com.laisha.array.entity.UserIntegerArrayStatistics;
import com.laisha.array.warehouse.UserArrayWarehouse;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class UserIntegerArrayObserverImplTest {

    static UserArrayCreatorImpl arrayCreator = UserArrayCreatorImpl.getInstance();
    static UserArrayWarehouse warehouse = UserArrayWarehouse.getInstance();
    UserArray userArray;

    @AfterEach
    void tearDown() {
        userArray = null;
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

        userArray = arrayCreator.createUserArray(integerArray);
        int size = warehouse.size();
        ((UserIntegerArray) userArray).setUserIntegerArray(0, 2, 4);
        int expected = size + 1;//object is added to warehouse
        int actual = warehouse.size();
        warehouse.remove(userArray.getUserArrayId());
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Array Statistics object is replaced to warehouse after " +
            "correct integer array is set.")
    void changeParametersSecondPositiveTest() {

        Optional<UserArrayStatistics> userArrayStatistics =
                new UserIntegerArrayStatistics.Builder()
                        .setMinElement(1)
                        .setMaxElement(5)
                        .setAverageValue(3)
                        .setTotalSum(9)
                        .setNegativeElementQuantity(0)
                        .setZeroElementQuantity(0)
                        .build();
        UserArrayStatistics expectedArrayStatistics = null;
        if (userArrayStatistics.isPresent()) {
            expectedArrayStatistics = userArrayStatistics.get();
        }
        int[] integerArray = {0, 2, 4};
        userArray = arrayCreator.createUserArray(integerArray);
        ((UserIntegerArray) userArray).setUserIntegerArray(1, 3, 5);
        UserArrayStatistics actualArrayStatistics = warehouse.get(userArray.getUserArrayId());
        warehouse.remove(userArray.getUserArrayId());
        assertEquals(expectedArrayStatistics, actualArrayStatistics);
    }

    @Test
    @DisplayName("Array Statistics object is replaced to warehouse after " +
            "correct integer array is set. Warehouse size is immutable.")
    void changeParametersThirdPositiveTest() {

        int[] integerArray = {0, 2, 4};
        userArray = arrayCreator.createUserArray(integerArray);
        int expected = warehouse.size();
        ((UserIntegerArray) userArray).setUserIntegerArray(1, 3, 5);
        int actual = warehouse.size();
        warehouse.remove(userArray.getUserArrayId());
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @EmptySource
    @DisplayName("Array Statistics object is removed to warehouse after " +
            "empty array for integer array is set.")
    void changeParametersFirstNegativeTest(int... integerArray) {

        int[] firstIntegerArray = {0, 2, 4};
        userArray = arrayCreator.createUserArray(firstIntegerArray);
        int size = warehouse.size();
        ((UserIntegerArray) userArray).setUserIntegerArray(integerArray);
        int expected = size - 1;//object is removed from warehouse
        int actual = warehouse.size();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Array Statistics object is put to warehouse after " +
            "correct integer array is set. Warehouse size is changed.")
    void changeParametersSecondNegativeTest() {

        int[] integerArray = {};
        userArray = arrayCreator.createUserArray(integerArray);
        int expected = warehouse.size();
        ((UserIntegerArray) userArray).setUserIntegerArray(1, 3, 5);
        int actual = warehouse.size();
        warehouse.remove(userArray.getUserArrayId());
        assertNotEquals(expected, actual);
    }
}