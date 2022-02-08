package com.laisha.array.filler;

import com.laisha.array.entity.UserArray;

import java.util.List;

public interface UserArrayFiller {

    void fillAll(List<UserArray> userArrays);

    void fill(UserArray userArray);
}
