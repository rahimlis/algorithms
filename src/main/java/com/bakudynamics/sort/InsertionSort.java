package com.bakudynamics.sort;

public class InsertionSort implements Sort {

    @Override
    public <T> void sort(Comparable<T>[] a, Order order) {
        if (isNullOrEmpty(a)) return;
        for (int i = 1; i < a.length; i++) {
            var key = a[i];
            int j = i - 1;

            while (j >= 0 && isPreceding(key, a[j], order)) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;
        }
    }

    @Override
    public void sort(int[] a, Order order) {
        if (isNullOrEmpty(a)) return;
        for (int i = 1; i < a.length; i++) {
            var key = a[i];
            int j = i - 1;

            while (j >= 0 && isPreceding(key, a[j], order)) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;
        }
    }
}
