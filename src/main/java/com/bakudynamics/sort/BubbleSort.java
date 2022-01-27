package com.bakudynamics.sort;

public class BubbleSort implements Sort {

    @Override
    public <T> void sort(Comparable<T>[] a, Order order) {
        if (isNullOrEmpty(a)) return;
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i; j < a.length; j++) {
                if (isPreceding(a[j], a[i], order)) {
                    swap(a, i, j);
                }
            }
        }
    }

    @Override
    public void sort(int[] a, Order order) {
        if (isNullOrEmpty(a)) return;
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i; j < a.length; j++) {
                if (isPreceding(a[j], a[i], order)) {
                    swap(a, i, j);
                }
            }
        }
    }

    private <T> void swap(Comparable<T>[] a, int i, int j) {
        var temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private void swap(int[] a, int i, int j) {
        var temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
