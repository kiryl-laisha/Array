package com.laisha.array.filler.impl;

import com.laisha.array.creator.impl.CustomIntegerArrayStatisticsCreator;
import com.laisha.array.entity.CustomArray;
import com.laisha.array.entity.CustomArrayStatistics;
import com.laisha.array.filler.CustomArrayFiller;
import com.laisha.array.warehouse.CustomArrayWarehouse;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class CustomArrayWarehouseFiller implements CustomArrayFiller {

    private static final CustomArrayWarehouseFiller instance = new CustomArrayWarehouseFiller();
    private static final CustomIntegerArrayStatisticsCreator userIntegerArrayStatisticsCreator =
            CustomIntegerArrayStatisticsCreator.getInstance();

    private CustomArrayWarehouseFiller() {
    }

    public static CustomArrayWarehouseFiller getInstance() {
        return instance;
    }

    @Override
    public void fillAll(List<CustomArray> customArrays) {
        customArrays.forEach(this::fill);
    }

    @Override
    public void fill(CustomArray customArray) {

        CustomArrayWarehouse warehouse = CustomArrayWarehouse.getInstance();
        Optional<CustomArrayStatistics> statistics =
                userIntegerArrayStatisticsCreator.createCustomArrayStatistics(customArray);
        UUID userArrayId = customArray.getCustomArrayId();
        statistics.ifPresent(s -> warehouse.put(userArrayId, s));
    }
}
