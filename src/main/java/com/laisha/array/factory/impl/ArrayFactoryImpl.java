package com.laisha.array.factory.impl;

import com.laisha.array.entity.UserIntegerArray;
import com.laisha.array.exception.ProjectException;
import com.laisha.array.factory.ArrayFactory;

public class ArrayFactoryImpl implements ArrayFactory {

    private static final ArrayFactoryImpl instance = new ArrayFactoryImpl();

    private ArrayFactoryImpl() {

    }

    public static ArrayFactoryImpl getInstance() {

        return instance;
    }

    @Override
    public UserIntegerArray createUserIntegerArray() {

        return (new UserIntegerArray());
    }

    @Override
    public UserIntegerArray createUserIntegerArray(int... integerArray)
            throws ProjectException {

        UserIntegerArray userIntegerArray;
        try {
            userIntegerArray = new UserIntegerArray(integerArray);
        } catch (ProjectException projectException) {
            throw new ProjectException("Object creation is not available.",
                    projectException);
        }
        return userIntegerArray;
    }
}
