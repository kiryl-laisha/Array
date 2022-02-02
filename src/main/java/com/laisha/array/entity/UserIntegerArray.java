package com.laisha.array.entity;

import com.laisha.array.exception.ProjectException;
import com.laisha.array.observer.IntegerArrayObserver;
import com.laisha.array.observer.Observable;
import com.laisha.array.util.EntityIdGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class UserIntegerArray implements Observable {

    private final UUID userIntegerArrayId;
    private int[] integerArray;
    private List<IntegerArrayObserver> observers = new ArrayList<>();

    {
        userIntegerArrayId = EntityIdGenerator.generateEntityId();
    }

    public UserIntegerArray() {
    }

    public UserIntegerArray(int... integerArray) throws ProjectException {

        if (integerArray == null) {
            throw new ProjectException("The provided to constructor " +
                    "integer array is null.");
        }
        this.integerArray = Arrays.copyOf(integerArray, integerArray.length);
    }

    public int[] getUserIntegerArray() {

        return Arrays.copyOf(integerArray, integerArray.length);
    }

    public void setUserIntegerArray(int[] integerArray) throws ProjectException {

        if (integerArray == null) {
            throw new ProjectException("The provided integer array is null.");
        }
        this.integerArray = Arrays.copyOf(integerArray, integerArray.length);
        notifyObservers();
    }

    public UUID getUserIntegerArrayId() {

        return userIntegerArrayId;
    }

    public void setIntegerArrayElement(int elementIndex, int elementValue)
            throws ProjectException {

        if (integerArray == null) {
            throw new ProjectException("Integer array hasn't been initialized.");
        }
        if (integerArray.length == 0) {
            throw new ProjectException("Integer array is degenerated. " +
                    "Array element setting is not available.");
        }
        if (elementIndex < 0 || elementIndex >= integerArray.length) {
            throw new ProjectException("Provided element index is out of array bounds. " +
                    "Array element setting is not available.");
        }
        integerArray[elementIndex] = elementValue;
        notifyObservers();
    }

    @Override
    public void attach(IntegerArrayObserver integerArrayObserver) {
        observers.add(integerArrayObserver);
    }

    @Override
    public void detach(IntegerArrayObserver integerArrayObserver) {
        observers.remove(integerArrayObserver);
    }

    @Override
    public void notifyObservers() throws ProjectException {
        if (!observers.isEmpty()) {
            for (IntegerArrayObserver observer : observers) {
                try {
                    observer.changeElements(this);
                } catch (ProjectException projectException) {
                    throw new ProjectException("Method execution is not available",
                            projectException);
                }
            }
        }
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        UserIntegerArray otherArray = (UserIntegerArray) obj;
        return (userIntegerArrayId == otherArray.userIntegerArrayId);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        if (integerArray != null) {
            for (int element : integerArray) {
                result = prime * result + element;
            }
        } else {
            result = prime * result;
        }
        result = prime * result + userIntegerArrayId.hashCode();
        return result;

    }

    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder("Integer array{");
        for (int i = 0; i < integerArray.length; i++) {
            stringBuilder.append("[");
            stringBuilder.append(i);
            stringBuilder.append("] = ");
            stringBuilder.append(integerArray[i]);
            if (i != integerArray.length - 1) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("}.");
        return stringBuilder.toString();
    }
}