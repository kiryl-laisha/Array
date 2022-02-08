package com.laisha.array.filler.impl;

import com.laisha.array.entity.UserArray;
import com.laisha.array.factory.impl.UserArrayFactoryImpl;
import com.laisha.array.warehouse.UserArrayWarehouse;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserArrayWarehouseFillerTest {

    static UserArrayFactoryImpl arrayFactory = UserArrayFactoryImpl.getInstance();
    static UserArrayWarehouse warehouse = UserArrayWarehouse.getInstance();
    static UserArrayWarehouseFiller warehouseFiller = UserArrayWarehouseFiller.getInstance();
    static List<UserArray> userArrays;

    @BeforeEach
    void setUp() {
        userArrays = new ArrayList<>();
    }

    @AfterAll
    static void tearDownClass() {

        arrayFactory = null;
        warehouse = null;
        warehouseFiller = null;
        userArrays = null;
    }

    @Test
    @DisplayName("Objects have been added to repository.")
    void fillAllPositiveTest() {

        int size = warehouse.size();
        userArrays.add(arrayFactory.createUserArray(new int[]{1, 3}));
        userArrays.add(arrayFactory.createUserArray(new int[]{1, 5}));
        userArrays.add(arrayFactory.createUserArray(new int[]{3, 6}));
        warehouseFiller.fillAll(userArrays);
        int expected = size + 3;//Three objects have been added to repository
        int actual = warehouse.size();
        userArrays.stream()
                .map(UserArray::getUserArrayId)
                .forEach(warehouse::remove);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @EmptySource
    @DisplayName("Objects haven't been added to repository. Integer array is empty.")
    void fillAllFirstNegativeTest(int... integerArray) {

        int expected = warehouse.size();
        userArrays.add(arrayFactory.createUserArray(integerArray));
        warehouseFiller.fillAll(userArrays);
        int actual = warehouse.size();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Objects haven't been added to repository. Integer array is null.")
    void fillAllSecondNegativeTest() {

        int expected = warehouse.size();
        userArrays.add(arrayFactory.createUserArray());
        warehouseFiller.fillAll(userArrays);
        int actual = warehouse.size();
        assertEquals(expected, actual);
    }
}