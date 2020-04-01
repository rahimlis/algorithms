package com.bakudynamics.sort;

public class BubbleSort implements Sort {

    @Override
    public void sort(Comparable[] a, Order order) {
        if (a == null || a.length == 0) return;
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i; j < a.length; j++) {
                if (isPreceding(a[j], a[i], order)) {
                    var temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
    }
}
