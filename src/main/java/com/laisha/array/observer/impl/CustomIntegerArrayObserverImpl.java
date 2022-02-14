package com.laisha.array.observer.impl;

import com.laisha.array.entity.CustomArray;
import com.laisha.array.entity.CustomArrayEvent;
import com.laisha.array.entity.CustomArrayStatistics;
import com.laisha.array.observer.CustomArrayObserver;
import com.laisha.array.creator.impl.CustomIntegerArrayStatisticsCreator;
import com.laisha.array.warehouse.CustomArrayWarehouse;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;
import java.util.UUID;

public class CustomIntegerArrayObserverImpl implements CustomArrayObserver {

    private static final Logger logger = LogManager.getLogger();
    private static final CustomArrayWarehouse warehouse = CustomArrayWarehouse.getInstance();
    private static final CustomIntegerArrayStatisticsCreator statisticsCreator =
            CustomIntegerArrayStatisticsCreator.getInstance();

    public void changeParameters(CustomArrayEvent event) {

        CustomArray customArray = event.getSource();
        Optional<CustomArrayStatistics> statistics =
                statisticsCreator.createCustomArrayStatistics(customArray);
        UUID integerArrayId = customArray.getCustomArrayId();
        if (statistics.isPresent()) {
            warehouse.put(integerArrayId, statistics.get());
        } else {
            warehouse.remove(integerArrayId);
            logger.log(Level.WARN, "Integer array statistics haven't been defined. " +
                    "User integer array object has been removed from warehouse.");
        }
    }
}

