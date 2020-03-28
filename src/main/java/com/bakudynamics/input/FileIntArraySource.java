package com.bakudynamics.input;

import java.util.Iterator;

public class FileIntArraySource implements Iterator<int[]> {

    private final int[] fileInputSizes = new int[]{10, 100, 1000, 10000};
    private int current = 0;

    @Override
    public boolean hasNext() {
        return current < fileInputSizes.length;
    }

    @Override
    public int[] next() {
        int inputSize = fileInputSizes[current++];
        String inputFilename = String.format("input%d.txt", inputSize);
        return InputReader.readIntArray(inputFilename);
    }
}
