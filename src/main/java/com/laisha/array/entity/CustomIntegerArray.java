package com.laisha.array.entity;

import java.util.Arrays;

public class CustomIntegerArray {

    private int[] integerArray;

    public CustomIntegerArray() {
    }

    public int[] getIntegerArray() {
        return integerArray;
    }

    public void setIntegerArray(int[] integerArray) {
        this.integerArray = integerArray;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CustomIntegerArray)) return false;
        CustomIntegerArray that = (CustomIntegerArray) o;
        return Arrays.equals(integerArray, that.integerArray);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(integerArray);
    }

    @Override
    public String toString() {
        return "CustomIntegerArray{" +
                "integerArray=" + Arrays.toString(integerArray) +
                '}';
    }
}