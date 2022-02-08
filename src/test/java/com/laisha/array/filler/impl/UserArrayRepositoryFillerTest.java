package com.laisha.array.filler.impl;

import com.laisha.array.entity.UserArray;
import com.laisha.array.factory.impl.UserArrayFactoryImpl;
import com.laisha.array.repository.UserArrayRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserArrayRepositoryFillerTest {

    static UserArrayFactoryImpl arrayFactory = UserArrayFactoryImpl.getInstance();
    static UserArrayRepository repository = UserArrayRepository.getInstance();
    static UserArrayRepositoryFiller repositoryFiller = UserArrayRepositoryFiller.getInstance();
    static List<UserArray> userArrays = new ArrayList<>();

    @AfterAll
    static void tearDownClass() {

        arrayFactory = null;
        repositoryFiller = null;
        repository = null;
        userArrays = null;
    }

    @Test
    @DisplayName("Objects have been added to repository.")
    void fillAllPositiveTest() {

        int size = repository.size();
        userArrays.add(arrayFactory.createUserArray(new int[]{1, 3}));
        userArrays.add(arrayFactory.createUserArray());
        userArrays.add(arrayFactory.createUserArray(new int[]{3, 6}));
        repositoryFiller.fillAll(userArrays);
        int expected = size + 3;//Three objects have been added to repository
        int actual = repository.size();
        repository.removeAll(userArrays);
        assertEquals(expected, actual);
    }
}