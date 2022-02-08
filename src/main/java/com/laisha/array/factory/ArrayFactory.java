package com.laisha.array.factory;

import com.laisha.array.entity.UserArray;

public interface ArrayFactory {

    UserArray createUserArray();

    UserArray createUserArray(int[] integerArray);
}
