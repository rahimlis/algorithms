package com.bakudynamics.sort;

public class BubbleSort implements Sort {

    @Override
    public void sort(int[] a) {
        sort(a, Order.ASC);
    }

    @Override
    public void sort(int[] a, Order order) {
        if (a == null || a.length == 0) return;
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i; j < a.length; j++) {
                if (direction(a[j], a[i], order)) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
    }

    private boolean direction(int a, int b, Order order) {
        return order == Order.ASC ? a < b : a > b;
    }
}
