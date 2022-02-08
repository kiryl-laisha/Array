package com.laisha.array.warehouse;

import com.laisha.array.creator.impl.UserArrayCreatorImpl;
import com.laisha.array.entity.UserArray;
import com.laisha.array.entity.UserArrayStatistics;
import com.laisha.array.entity.UserIntegerArray;
import com.laisha.array.entity.UserIntegerArrayStatistics;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserArrayWarehouseTest {

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

    @Test
    @DisplayName("Array Statistics object is replaced to warehouse.")
    void replacePositiveTest() {

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
        warehouse.replace(userArray.getUserArrayId(), expectedArrayStatistics);
        ((UserIntegerArray) userArray).setUserIntegerArray(1, 3, 5);
        UserArrayStatistics actualArrayStatistics = warehouse.get(userArray.getUserArrayId());
        warehouse.remove(userArray.getUserArrayId());
        assertEquals(expectedArrayStatistics, actualArrayStatistics);
    }
}