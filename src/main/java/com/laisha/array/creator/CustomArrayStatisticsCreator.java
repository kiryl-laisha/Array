package com.laisha.array.creator;

import com.laisha.array.entity.CustomArray;
import com.laisha.array.entity.CustomArrayStatistics;

import java.util.Optional;

public interface CustomArrayStatisticsCreator {

    Optional<CustomArrayStatistics> createCustomArrayStatistics(CustomArray customArray);
}
