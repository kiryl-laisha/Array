package com.laisha.array.repository;

import com.laisha.array.entity.UserArray;

@FunctionalInterface
public interface UserArraySpecification {

    boolean specify(UserArray userArray);
}
