package com.laisha.array.filler.impl;

import com.laisha.array.entity.CustomArray;
import com.laisha.array.filler.CustomArrayFiller;
import com.laisha.array.repository.CustomArrayRepository;

import java.util.List;

public class CustomArrayRepositoryFiller implements CustomArrayFiller {

    private static final CustomArrayRepositoryFiller instance = new CustomArrayRepositoryFiller();

    private CustomArrayRepositoryFiller() {
    }

    public static CustomArrayRepositoryFiller getInstance() {
        return instance;
    }

    @Override
    public void fillAll(List<CustomArray> customArrays) {
        customArrays.forEach(this::fill);
    }

    @Override
    public void fill(CustomArray customArray) {

        CustomArrayRepository repository = CustomArrayRepository.getInstance();
        repository.add(customArray);
    }
}
