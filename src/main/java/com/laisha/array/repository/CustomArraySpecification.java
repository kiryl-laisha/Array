package com.laisha.array.repository;

import com.laisha.array.entity.CustomArray;

@FunctionalInterface
public interface CustomArraySpecification {

    boolean specify(CustomArray customArray);
}
