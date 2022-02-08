package com.laisha.array.repository.impl;

import com.laisha.array.entity.UserArray;

import java.util.UUID;
import java.util.function.Predicate;

public class IdMorePredicate implements Predicate<UserArray> {

    private final UUID providedUserArrayId;

    public IdMorePredicate(UUID providedUserArrayId) {
        this.providedUserArrayId = providedUserArrayId;
    }

    @Override
    public boolean test(UserArray userArray) {

        int result = userArray.getUserArrayId().compareTo(providedUserArrayId);
        return result > 0;
    }
}
