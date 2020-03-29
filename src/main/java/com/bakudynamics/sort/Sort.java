package com.bakudynamics.sort;

public interface Sort {

    void sort(int[] a);

    void sort(int[] a, Order order);

    default String tag() {
        return getClass().getSimpleName();
    }

    enum Order {
        ASC,
        DESC
    }
}