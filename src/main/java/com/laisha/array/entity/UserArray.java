package com.laisha.array.entity;

import com.laisha.array.observer.UserArrayObserver;
import com.laisha.array.observer.Observable;
import com.laisha.array.util.EntityIdGenerator;

import java.util.*;

public abstract class UserArray implements Observable {

    private final UUID userArrayId;
    private final List<UserArrayObserver> userArrayObservers = new ArrayList<>();

    UserArray() {
        userArrayId = EntityIdGenerator.generateEntityId();
    }

    public UUID getUserArrayId() {
        return userArrayId;
    }

    public List<UserArrayObserver> getArrayObservers() {
        return userArrayObservers;
    }

    @Override
    public void attach(UserArrayObserver userArrayObserver) {
        userArrayObservers.add(userArrayObserver);
    }

    @Override
    public void detach(UserArrayObserver userArrayObserver) {
        userArrayObservers.remove(userArrayObserver);
    }

    @Override
    public void notifyObservers() {

        UserArrayEvent event = new UserArrayEvent(this);
        if (!userArrayObservers.isEmpty()) {
            for (UserArrayObserver observer : userArrayObservers) {
                observer.changeParameters(event);
            }
        }
    }
}
