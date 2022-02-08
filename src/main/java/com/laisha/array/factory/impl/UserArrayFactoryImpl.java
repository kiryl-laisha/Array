package com.laisha.array.factory.impl;

import com.laisha.array.entity.UserArray;
import com.laisha.array.entity.UserIntegerArray;
import com.laisha.array.factory.ArrayFactory;

public class UserArrayFactoryImpl implements ArrayFactory {

    private static final UserArrayFactoryImpl instance = new UserArrayFactoryImpl();

    private UserArrayFactoryImpl() {
    }

    public static UserArrayFactoryImpl getInstance() {
        return instance;
    }

    @Override
    public UserArray createUserArray() {
        return UserIntegerArray
                .createBuilder()
                .build();
    }

    @Override
    public UserArray createUserArray(int[] integerArray) {
        return UserIntegerArray
                .createBuilder()
                .integerArray(integerArray)
                .build();
    }
}
