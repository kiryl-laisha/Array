package com.laisha.array.factory;

import com.laisha.array.entity.CustomArray;

public interface ArrayFactory {

    CustomArray createCustomArray();

    CustomArray createCustomArray(int[] integerArray);
}
