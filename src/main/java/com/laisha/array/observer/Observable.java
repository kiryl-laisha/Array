package com.laisha.array.observer;

import com.laisha.array.exception.ProjectException;

public interface Observable {

    void attach(IntegerArrayObserver integerArrayObserver);

    void detach(IntegerArrayObserver integerArrayObserver);

    void notifyObservers() throws ProjectException;
}
