package com.laisha.array.comparator;

import com.laisha.array.entity.UserArray;

import java.util.Comparator;

public class IdComparator implements Comparator<UserArray> {

    @Override
    public int compare(UserArray firstUserArray, UserArray secondUserArray) {
        return firstUserArray.getUserArrayId().compareTo(secondUserArray.getUserArrayId());
    }
}
