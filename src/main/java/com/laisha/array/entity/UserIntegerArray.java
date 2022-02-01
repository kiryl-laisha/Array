package com.laisha.array.entity;

import com.laisha.array.exception.ProjectException;
import com.laisha.array.util.EntityIdGenerator;

import java.util.Arrays;
import java.util.UUID;

public class UserIntegerArray {

    private final UUID userIntegerArrayId;
    private int[] integerArray;

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
        this.integerArray = integerArray;
    }

    public int[] getUserIntegerArray() {

        return Arrays.copyOf(integerArray, integerArray.length);
    }

    public void setUserIntegerArray(int[] integerArray) throws ProjectException {

        if (integerArray == null) {
            throw new ProjectException("The provided integer array is null.");
        }
        this.integerArray = Arrays.copyOf(integerArray, integerArray.length);
    }

    public UUID getUserIntegerArrayId() {

        return userIntegerArrayId;
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