package com.laisha.array.entity;

import java.util.Optional;

public class CustomIntegerArrayStatistics extends CustomArrayStatistics {

    private final int minElement;
    private final int maxElement;
    private final long totalSum;
    private final int negativeElementQuantity;
    private final int zeroElementQuantity;

    private CustomIntegerArrayStatistics(int minElement,
                                         int maxElement,
                                         double averageValue,
                                         long totalSum,
                                         int negativeElementQuantity,
                                         int zeroElementQuantity) {
        super(averageValue);
        this.minElement = minElement;
        this.maxElement = maxElement;
        this.totalSum = totalSum;
        this.negativeElementQuantity = negativeElementQuantity;
        this.zeroElementQuantity = zeroElementQuantity;
    }

    public static class Builder {

        private int minElement;
        private int maxElement;
        private double averageValue;
        private long totalSum;
        private int negativeElementQuantity;
        private int zeroElementQuantity;
        private int initializedFieldsCounter;

        public Builder setMinElement(int minElement) {

            this.minElement = minElement;
            initializedFieldsCounter++;
            return this;
        }

        public Builder setMaxElement(int maxElement) {

            this.maxElement = maxElement;
            initializedFieldsCounter++;
            return this;
        }

        public Builder setAverageValue(double averageValue) {

            this.averageValue = averageValue;
            initializedFieldsCounter++;
            return this;
        }

        public Builder setTotalSum(long totalSum) {

            this.totalSum = totalSum;
            initializedFieldsCounter++;
            return this;
        }

        public Builder setNegativeElementQuantity(int negativeElementQuantity) {

            this.negativeElementQuantity = negativeElementQuantity;
            initializedFieldsCounter++;
            return this;
        }

        public Builder setZeroElementQuantity(int zeroElementQuantity) {

            this.zeroElementQuantity = zeroElementQuantity;
            initializedFieldsCounter++;
            return this;
        }

        public Optional<CustomArrayStatistics> build() {

            CustomArrayStatistics customArrayStatistics = null;
            if (initializedFieldsCounter == 6) {
                customArrayStatistics = new CustomIntegerArrayStatistics(
                        minElement,
                        maxElement,
                        averageValue,
                        totalSum,
                        negativeElementQuantity,
                        zeroElementQuantity);
            }
            cleanFieldsParameters();
            return customArrayStatistics != null ? Optional.of(customArrayStatistics) :
                    Optional.empty();
        }

        private void cleanFieldsParameters() {

            minElement = 0;
            maxElement = 0;
            averageValue = 0;
            totalSum = 0;
            negativeElementQuantity = 0;
            zeroElementQuantity = 0;
            initializedFieldsCounter = 0;
        }
    }

    public int getMinElement() {
        return minElement;
    }

    public int getMaxElement() {
        return maxElement;
    }

    public long getTotalSum() {
        return totalSum;
    }

    public int getNegativeElementQuantity() {
        return negativeElementQuantity;
    }

    public int getZeroElementQuantity() {
        return zeroElementQuantity;
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
        CustomIntegerArrayStatistics that = (CustomIntegerArrayStatistics) obj;
        return (minElement == that.minElement &&
                maxElement == that.maxElement &&
                Double.compare(getAverageValue(), that.getAverageValue()) == 0 &&
                totalSum == that.totalSum &&
                negativeElementQuantity == that.negativeElementQuantity &&
                zeroElementQuantity == that.zeroElementQuantity);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + minElement;
        result = prime * result + maxElement;
        result = prime * result + (int) getAverageValue();
        result = prime * result + (int) totalSum;
        result = prime * result + negativeElementQuantity;
        result = prime * result + negativeElementQuantity;
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Integer array statistics{")
                .append("minimum element = ")
                .append(minElement)
                .append(", maximum element = ")
                .append(maxElement)
                .append(", average value = ")
                .append(getAverageValue())
                .append(",\ntotal sum of elements = ")
                .append(totalSum)
                .append(", quantity of negative elements = ")
                .append(negativeElementQuantity)
                .append(", quantity of zero elements = ")
                .append(zeroElementQuantity)
                .append("}.");
        return stringBuilder.toString();
    }
}
