package com.laisha.array.filler.impl;

import com.laisha.array.entity.CustomArray;
import com.laisha.array.factory.impl.CustomArrayFactoryImpl;
import com.laisha.array.warehouse.CustomArrayWarehouse;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomArrayWarehouseFillerTest {

    static CustomArrayFactoryImpl arrayFactory = CustomArrayFactoryImpl.getInstance();
    static CustomArrayWarehouse warehouse = CustomArrayWarehouse.getInstance();
    static CustomArrayWarehouseFiller warehouseFiller = CustomArrayWarehouseFiller.getInstance();
    static List<CustomArray> customArrays;

    @BeforeEach
    void setUp() {
        customArrays = new ArrayList<>();
    }

    @AfterAll
    static void tearDownClass() {

        arrayFactory = null;
        warehouse = null;
        warehouseFiller = null;
        customArrays = null;
    }

    @Test
    @DisplayName("Objects have been added to repository.")
    void fillAllPositiveTest() {

        int size = warehouse.size();
        customArrays.add(arrayFactory.createCustomArray(new int[]{1, 3}));
        customArrays.add(arrayFactory.createCustomArray(new int[]{1, 5}));
        customArrays.add(arrayFactory.createCustomArray(new int[]{3, 6}));
        warehouseFiller.fillAll(customArrays);
        int expected = size + 3;//Three objects have been added to repository
        int actual = warehouse.size();
        customArrays.stream()
                .map(CustomArray::getCustomArrayId)
                .forEach(warehouse::remove);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @EmptySource
    @DisplayName("Objects haven't been added to repository. Integer array is empty.")
    void fillAllFirstNegativeTest(int... integerArray) {

        int expected = warehouse.size();
        customArrays.add(arrayFactory.createCustomArray(integerArray));
        warehouseFiller.fillAll(customArrays);
        int actual = warehouse.size();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Objects haven't been added to repository. Integer array is null.")
    void fillAllSecondNegativeTest() {

        int expected = warehouse.size();
        customArrays.add(arrayFactory.createCustomArray());
        warehouseFiller.fillAll(customArrays);
        int actual = warehouse.size();
        assertEquals(expected, actual);
    }
}