package com.laisha.array.comparator;

import com.laisha.array.entity.CustomArray;

import java.util.Comparator;

public class IdComparator implements Comparator<CustomArray> {

    @Override
    public int compare(CustomArray firstCustomArray, CustomArray secondCustomArray) {
        return firstCustomArray.getCustomArrayId().compareTo(secondCustomArray.getCustomArrayId());
    }
}
