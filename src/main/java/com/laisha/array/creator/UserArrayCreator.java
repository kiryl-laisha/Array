package com.laisha.array.creator;

import com.laisha.array.entity.UserArray;

public interface UserArrayCreator {

    UserArray createUserArray();

    UserArray createUserArray(int... integerArray);
}
