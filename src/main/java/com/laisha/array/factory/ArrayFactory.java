package com.laisha.array.factory;

import com.laisha.array.entity.UserIntegerArray;
import com.laisha.array.exception.ProjectException;

public interface ArrayFactory {

    UserIntegerArray createUserIntegerArray();

    UserIntegerArray createUserIntegerArray(int... integerArray)
            throws ProjectException;
}
