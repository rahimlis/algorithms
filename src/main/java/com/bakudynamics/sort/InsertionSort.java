package com.bakudynamics.sort;

public class InsertionSort implements Sort {

    @Override
    public void sort(int[] a) {
        sort(a, Order.ASC);
    }

    @Override
    public void sort(int[] a, Order order) {
        if (a == null || a.length == 0) return;
        for (int i = 1; i < a.length; i++) {
            int key = a[i];
            int j = i - 1;

            while (j >= 0 && direction(key, a[j], order)) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;
        }
    }

    private boolean direction(int key, int ai, Order order) {
        return order == Order.ASC ? key < ai : key > ai;
    }
}
