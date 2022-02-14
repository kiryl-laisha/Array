package com.laisha.array.observer;

public interface Observable {

    void attach(CustomArrayObserver observer);

    void detach(CustomArrayObserver observer);

    void notifyObservers();
}
