package com.laisha.array.warehouse;

import com.laisha.array.creator.impl.CustomArrayCreatorImpl;
import com.laisha.array.entity.CustomArray;
import com.laisha.array.entity.CustomIntegerArray;
import com.laisha.array.entity.CustomArrayStatistics;
import com.laisha.array.entity.CustomIntegerArrayStatistics;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomArrayWarehouseTest {

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

    @Test
    @DisplayName("Array Statistics object is replaced to warehouse.")
    void replacePositiveTest() {

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
        warehouse.replace(customArray.getCustomArrayId(), expectedArrayStatistics);
        ((CustomIntegerArray) customArray).setCustomIntegerArray(1, 3, 5);
        CustomArrayStatistics actualArrayStatistics = warehouse.get(customArray.getCustomArrayId());
        warehouse.remove(customArray.getCustomArrayId());
        assertEquals(expectedArrayStatistics, actualArrayStatistics);
    }
}