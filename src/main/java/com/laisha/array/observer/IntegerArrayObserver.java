package com.laisha.array.observer;

import com.laisha.array.entity.UserIntegerArray;
import com.laisha.array.exception.ProjectException;

public interface IntegerArrayObserver {

    void changeElements(UserIntegerArray userIntegerArray) throws ProjectException;
}
