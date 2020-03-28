package com.bakudynamics.input;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RandomGenerator {

    private final static Map<Integer, int[]> arrayCache = new HashMap<>();

    private final Random random = new Random();
    private final boolean persist;

    public RandomGenerator(boolean persist) {
        this.persist = persist;
    }

    public static RandomGenerator get(boolean persist) {
        return new RandomGenerator(persist);
    }

    public int intInRange(int min, int max) {
        return random.nextInt((max - min) + 1) + min;
    }

    public int[] intArrayInRange(int min, int max, int n) {
        if (persist && arrayCache.get(n) != null) {
            return arrayCache.get(n).clone();
        }
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = intInRange(min, max);
        }

        if (persist)
            arrayCache.put(n, a.clone());

        return a;
    }

    public int[] intArray(int n) {
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = intInRange(0, Integer.MAX_VALUE - 1);
        }
        return a;
    }

}
