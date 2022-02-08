package com.laisha.array.filler.impl;

import com.laisha.array.entity.UserArray;
import com.laisha.array.filler.UserArrayFiller;
import com.laisha.array.repository.UserArrayRepository;

import java.util.List;

public class UserArrayRepositoryFiller implements UserArrayFiller {

    private static final UserArrayRepositoryFiller instance = new UserArrayRepositoryFiller();

    private UserArrayRepositoryFiller() {
    }

    public static UserArrayRepositoryFiller getInstance() {
        return instance;
    }

    @Override
    public void fillAll(List<UserArray> userArrays) {

        userArrays.forEach(this::fill);
    }

    @Override
    public void fill(UserArray userArray) {

        UserArrayRepository repository = UserArrayRepository.getInstance();
        repository.add(userArray);
    }
}
