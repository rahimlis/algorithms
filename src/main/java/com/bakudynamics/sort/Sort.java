package com.bakudynamics.sort;

public interface Sort {

    void sort(int[] a);

    void sort(int[] a, Order order);

    enum Order {
        ASC,
        DESC
    }
}