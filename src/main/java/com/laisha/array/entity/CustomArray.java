package com.laisha.array.entity;

import com.laisha.array.observer.CustomArrayObserver;
import com.laisha.array.observer.Observable;
import com.laisha.array.util.EntityIdGenerator;

import java.util.*;

public class CustomArray implements Observable {

    private final UUID customArrayId;
    private final List<CustomArrayObserver> observers = new ArrayList<>();

    CustomArray() {
        customArrayId = EntityIdGenerator.generateEntityId();
    }

    public UUID getCustomArrayId() {
        return customArrayId;
    }

    public List<CustomArrayObserver> getCustomArrayObservers() {
        return Collections.unmodifiableList(observers) ;
    }

    @Override
    public void attach(CustomArrayObserver observer) {
        observers.add(observer);
    }

    @Override
    public void detach(CustomArrayObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {

        CustomArrayEvent event = new CustomArrayEvent(this);
        if (!observers.isEmpty()) {
            for (CustomArrayObserver observer : observers) {
                observer.changeParameters(event);
            }
        }
    }
}
