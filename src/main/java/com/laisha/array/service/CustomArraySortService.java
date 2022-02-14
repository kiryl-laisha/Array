package com.laisha.array.service;

import com.laisha.array.entity.CustomArray;

import java.util.Optional;

public interface CustomArraySortService {

    Optional<CustomArray> sortByBubbleSorting(CustomArray customArray);

    Optional<CustomArray> sortBySelection(CustomArray customArray);

    Optional<CustomArray> sortByInsertion(CustomArray customArray);

    Optional<CustomArray> sortByStream(CustomArray customArray);
}
