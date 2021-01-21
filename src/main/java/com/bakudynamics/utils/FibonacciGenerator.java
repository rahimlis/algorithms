package com.bakudynamics.utils;

public class FibonacciGenerator {

    private final double FI = 1.61803;

    public long generate(int n) {
        double a = Math.pow(FI, n) / Math.sqrt(5);
        return Math.round(a);
    }
}
