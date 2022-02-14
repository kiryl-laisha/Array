package com.laisha.array.creator;

import com.laisha.array.entity.CustomArray;

public interface CustomArrayCreator {

    CustomArray createCustomArray();

    CustomArray createCustomArray(int... integerArray);
}
