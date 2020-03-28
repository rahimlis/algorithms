package com.bakudynamics.input;

import java.util.Iterator;

public class RandomIntArraySource implements Iterator<int[]> {
    private final RandomGenerator randomGenerator = RandomGenerator.get(true);
    private final int maxInputSize;
    private final int increment;
    private int currentSize;

    public RandomIntArraySource(int minInputSize, int maxInputSize, int increment) {
        this.currentSize = minInputSize;
        this.maxInputSize = maxInputSize;
        this.increment = increment;
    }

    @Override
    public boolean hasNext() {
        return currentSize < maxInputSize;
    }

    @Override
    public int[] next() {
        currentSize += increment;
        return randomGenerator.intArrayInRange(0, 100, currentSize);
    }

}
