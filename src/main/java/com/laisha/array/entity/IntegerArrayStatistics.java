package com.laisha.array.entity;

public class IntegerArrayStatistics {

    private int minElement;
    private int maxElement;
    private double averageValue;
    private long totalSum;
    private int negativeElementQuantity;
    private int notNegativeElementQuantity;

    public IntegerArrayStatistics(int minElement,
                                  int maxElement,
                                  double averageValue,
                                  long totalSum,
                                  int negativeElementQuantity,
                                  int notNegativeElementQuantity) {
        this.minElement = minElement;
        this.maxElement = maxElement;
        this.averageValue = averageValue;
        this.totalSum = totalSum;
        this.negativeElementQuantity = negativeElementQuantity;
        this.notNegativeElementQuantity = notNegativeElementQuantity;
    }

    public int getMinElement() {
        return minElement;
    }

    public void setMinElement(int minElement) {
        this.minElement = minElement;
    }

    public int getMaxElement() {
        return maxElement;
    }

    public void setMaxElement(int maxElement) {
        this.maxElement = maxElement;
    }

    public double getAverageValue() {
        return averageValue;
    }

    public void setAverageValue(double averageValue) {
        this.averageValue = averageValue;
    }

    public long getTotalSum() {
        return totalSum;
    }

    public void setTotalSum(long totalSum) {
        this.totalSum = totalSum;
    }

    public int getNegativeElementQuantity() {
        return negativeElementQuantity;
    }

    public void setNegativeElementQuantity(int negativeElementQuantity) {
        this.negativeElementQuantity = negativeElementQuantity;
    }

    public int getNotNegativeElementQuantity() {
        return notNegativeElementQuantity;
    }

    public void setNotNegativeElementQuantity(int notNegativeElementQuantity) {
        this.notNegativeElementQuantity = notNegativeElementQuantity;
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
        IntegerArrayStatistics that = (IntegerArrayStatistics) obj;
        return (minElement == that.minElement &&
                maxElement == that.maxElement &&
                Double.compare(averageValue, that.averageValue) == 0 &&
                totalSum == that.totalSum &&
                negativeElementQuantity == that.negativeElementQuantity &&
                notNegativeElementQuantity == that.notNegativeElementQuantity);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + minElement;
        result = prime * result + maxElement;
        result = prime * result + (int) averageValue;
        result = prime * result + (int) totalSum;
        result = prime * result + negativeElementQuantity;
        result = prime * result + negativeElementQuantity;
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder("Integer array statistics{");
        stringBuilder.append("minimum element = ");
        stringBuilder.append(minElement);
        stringBuilder.append(", maximum element = ");
        stringBuilder.append(maxElement);
        stringBuilder.append(", average value = ");
        stringBuilder.append(averageValue);
        stringBuilder.append(", total sum of elements = ");
        stringBuilder.append(totalSum);
        stringBuilder.append(", quantity of negative elements = ");
        stringBuilder.append(negativeElementQuantity);
        stringBuilder.append(", quantity of not negative elements = ");
        stringBuilder.append(notNegativeElementQuantity);
        stringBuilder.append(".");
        return stringBuilder.toString();
    }
}
