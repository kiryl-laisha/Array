package com.laisha.array.filler.impl;

import com.laisha.array.entity.UserArray;
import com.laisha.array.entity.UserArrayStatistics;
import com.laisha.array.filler.UserArrayFiller;
import com.laisha.array.creator.impl.UserIntegerArrayStatisticsCreator;
import com.laisha.array.warehouse.UserArrayWarehouse;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class UserArrayWarehouseFiller implements UserArrayFiller {

    private static final UserArrayWarehouseFiller instance = new UserArrayWarehouseFiller();
    private static final UserIntegerArrayStatisticsCreator userIntegerArrayStatisticsCreator =
            UserIntegerArrayStatisticsCreator.getInstance();

    private UserArrayWarehouseFiller() {
    }

    public static UserArrayWarehouseFiller getInstance() {
        return instance;
    }

    @Override
    public void fillAll(List<UserArray> userArrays) {

        userArrays.forEach(this::fill);
    }

    @Override
    public void fill(UserArray userArray) {

        UserArrayWarehouse warehouse = UserArrayWarehouse.getInstance();
        Optional<UserArrayStatistics> userIntegerArrayStatistics =
                userIntegerArrayStatisticsCreator.createUserArrayStatistics(userArray);
        UUID userArrayId = userArray.getUserArrayId();
        userIntegerArrayStatistics.ifPresent(s -> warehouse.put(userArrayId, s));
    }
}
