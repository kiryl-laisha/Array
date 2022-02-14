package com.laisha.array.factory.impl;

import com.laisha.array.entity.CustomArray;
import com.laisha.array.entity.CustomIntegerArray;
import com.laisha.array.factory.ArrayFactory;

public class CustomArrayFactoryImpl implements ArrayFactory {

    private static final CustomArrayFactoryImpl instance = new CustomArrayFactoryImpl();

    private CustomArrayFactoryImpl() {
    }

    public static CustomArrayFactoryImpl getInstance() {
        return instance;
    }

    @Override
    public CustomArray createCustomArray() {
        return CustomIntegerArray
                .createBuilder()
                .build();
    }

    @Override
    public CustomArray createCustomArray(int[] integerArray) {
        return CustomIntegerArray
                .createBuilder()
                .setIntegerArray(integerArray)
                .build();
    }
}
