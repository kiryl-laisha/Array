package com.laisha.array.filler.impl;

import com.laisha.array.entity.CustomArray;
import com.laisha.array.factory.impl.CustomArrayFactoryImpl;
import com.laisha.array.repository.CustomArrayRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomArrayRepositoryFillerTest {

    static CustomArrayFactoryImpl arrayFactory = CustomArrayFactoryImpl.getInstance();
    static CustomArrayRepository repository = CustomArrayRepository.getInstance();
    static CustomArrayRepositoryFiller repositoryFiller = CustomArrayRepositoryFiller.getInstance();
    static List<CustomArray> customArrays = new ArrayList<>();

    @AfterAll
    static void tearDownClass() {

        arrayFactory = null;
        repositoryFiller = null;
        repository = null;
        customArrays = null;
    }

    @Test
    @DisplayName("Objects have been added to repository.")
    void fillAllPositiveTest() {

        int size = repository.size();
        customArrays.add(arrayFactory.createCustomArray(new int[]{1, 3}));
        customArrays.add(arrayFactory.createCustomArray());
        customArrays.add(arrayFactory.createCustomArray(new int[]{3, 6}));
        repositoryFiller.fillAll(customArrays);
        int expected = size + 3;//Three objects have been added to repository
        int actual = repository.size();
        repository.removeAll(customArrays);
        assertEquals(expected, actual);
    }
}