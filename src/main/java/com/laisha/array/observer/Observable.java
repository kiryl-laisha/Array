package com.laisha.array.observer;

public interface Observable {

    void attach(UserArrayObserver userArrayObserver);

    void detach(UserArrayObserver userArrayObserver);

    void notifyObservers();
}
