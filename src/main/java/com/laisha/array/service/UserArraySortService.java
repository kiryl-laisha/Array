package com.laisha.array.service;

import com.laisha.array.entity.UserArray;

import java.util.Optional;

public interface UserArraySortService {

    Optional<UserArray> sortByBubbleSorting(UserArray userArray);

    Optional<UserArray> sortBySelection(UserArray userArray);

    Optional<UserArray> sortByInsertion(UserArray userArray);

    Optional<UserArray> sortByStream(UserArray userArray);
}
