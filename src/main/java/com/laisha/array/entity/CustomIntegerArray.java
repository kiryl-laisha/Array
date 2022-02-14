package com.laisha.array.entity;

import com.laisha.array.exception.ProjectException;

import java.util.Arrays;
import java.util.UUID;

public class CustomIntegerArray extends CustomArray {

    private int[] integerArray;

    public static Builder createBuilder() {
        return new CustomIntegerArray().new Builder();
    }

    public class Builder {

        private Builder() {
        }

        public Builder setIntegerArray(int[] integerArray) {
            CustomIntegerArray.this.integerArray =
                    Arrays.copyOf(integerArray, integerArray.length);
            return this;
        }

        public CustomIntegerArray build() {
            return CustomIntegerArray.this;
        }
    }

    public int[] getCustomIntegerArray() throws ProjectException {

        if (integerArray == null) {
            throw new ProjectException("Integer array is null.");
        }
        return Arrays.copyOf(integerArray, integerArray.length);
    }

    public void setCustomIntegerArray(int... integerArray) {

        if (integerArray != null) {
            this.integerArray = Arrays.copyOf(integerArray, integerArray.length);
        } else {
            this.integerArray = null;
        }
        notifyObservers();
    }

    public void setElementToCustomIntegerArray(int elementIndex, int elementValue)
            throws ProjectException {

        if (integerArray == null || integerArray.length == 0) {
            throw new ProjectException("Integer array hasn't been initialized " +
                    "or is degenerated. Element setting to array " +
                    "is not available.");
        }
        if (elementIndex < 0 || elementIndex >= integerArray.length) {
            throw new ProjectException("Provided element index is out of array " +
                    "bounds. Element setting to array is not available.");
        }
        integerArray[elementIndex] = elementValue;
        notifyObservers();
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
        CustomIntegerArray otherArray = (CustomIntegerArray) obj;
        if (otherArray.getCustomArrayId() == null) {
            return false;
        }
        UUID otherId = otherArray.getCustomArrayId();
        if (getCustomArrayId().getMostSignificantBits() !=
                otherId.getMostSignificantBits()
                || getCustomArrayId().getLeastSignificantBits() !=
                otherId.getLeastSignificantBits()) {
            return false;
        }
        if (integerArray == otherArray.integerArray) {
            return true;
        }
        if (integerArray == null || otherArray.integerArray == null) {
            return false;
        }
        if (integerArray.length != otherArray.integerArray.length) {
            return false;
        }
        if (integerArray.length == 0) {
            return true;
        }
        for (int i = 0; i < integerArray.length; i++) {
            if (integerArray[i] != otherArray.integerArray[i]) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long hilo = getCustomArrayId().getMostSignificantBits() ^
                getCustomArrayId().getLeastSignificantBits();
        result = prime * result + ((int) (hilo >> 32)) ^ (int) hilo;
        if (integerArray == null || integerArray.length == 0) {
            result = prime * result;
            return result;
        }
        for (int element : integerArray) {
            result = prime * result + element;
        }
        return result;
    }

    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder("Integer array{");
        stringBuilder.append("ID = ")
                .append(getCustomArrayId().toString())
                .append(";\n");
        if (integerArray == null) {
            stringBuilder.append("integer array hasn't been initialized}.");
            return stringBuilder.toString();
        }
        if (integerArray.length == 0) {
            stringBuilder.append("integer array has length = 0}.");
            return stringBuilder.toString();
        }
        for (int i = 0; i < integerArray.length; i++) {
            stringBuilder.append("[")
                    .append(i)
                    .append("] = ")
                    .append(integerArray[i]);
            if (i != integerArray.length - 1) {
                stringBuilder.append(", ");
            }
            if (i % 9 == 0) {
                stringBuilder.append("\n");
            }
        }
        stringBuilder.append("}.");
        return stringBuilder.toString();
    }
}