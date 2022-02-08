package com.laisha.array.observer.impl;

import com.laisha.array.entity.UserArray;
import com.laisha.array.entity.UserArrayEvent;
import com.laisha.array.entity.UserArrayStatistics;
import com.laisha.array.observer.UserArrayObserver;
import com.laisha.array.creator.impl.UserIntegerArrayStatisticsCreator;
import com.laisha.array.warehouse.UserArrayWarehouse;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;
import java.util.UUID;

public class UserIntegerArrayObserverImpl implements UserArrayObserver {

    private static final Logger logger = LogManager.getLogger();
    private static final UserArrayWarehouse warehouse = UserArrayWarehouse.getInstance();
    private static final UserIntegerArrayStatisticsCreator arrayStatisticsCreator =
            UserIntegerArrayStatisticsCreator.getInstance();

    public void changeParameters(UserArrayEvent event) {

        UserArray userArray = event.getSource();
        Optional<UserArrayStatistics> userIntegerArrayStatistics =
                arrayStatisticsCreator.createUserArrayStatistics(userArray);
        UUID integerArrayId = userArray.getUserArrayId();
        if (userIntegerArrayStatistics.isPresent()) {
            warehouse.put(integerArrayId, userIntegerArrayStatistics.get());
        } else {
            warehouse.remove(integerArrayId);
            logger.log(Level.WARN, "Integer array statistics haven't been defined. " +
                    "User integer array object has been removed from warehouse.");
        }
    }
}

