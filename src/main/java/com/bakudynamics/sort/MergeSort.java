package com.bakudynamics.sort;

public class MergeSort implements Sort {

    @Override
    public void sort(Comparable[] a, Order order) {
        if (a == null || a.length == 0) return;
        mergeSort(a, a.length, order);
    }

    private void mergeSort(Comparable[] a, int n, Order order) {
        if (n < 2) return;

        int mid = n / 2;
        Comparable[] l = new Comparable[mid];
        Comparable[] r = new Comparable[n - mid];

        System.arraycopy(a, 0, l, 0, mid);
        System.arraycopy(a, mid, r, 0, n - mid);


        mergeSort(l, mid, order);
        mergeSort(r, n - mid, order);

        // merge sorted parts
        merge(a, l, r, mid, n - mid, order);

    }

    protected void merge(Comparable[] a, Comparable[] l, Comparable[] r, int leftLength, int rightLength, Order order) {
        int leftIndex = 0;
        int rightIndex = 0;
        int arrayIndex = 0;

        while (leftIndex < leftLength && rightIndex < rightLength) {
            if (isPreceding(l[leftIndex], r[rightIndex], order)) {
                a[arrayIndex++] = l[leftIndex++];
            } else {
                a[arrayIndex++] = r[rightIndex++];
            }
        }

        while (leftIndex < leftLength) {
            a[arrayIndex++] = l[leftIndex++];
        }

        while (rightIndex < rightLength) {
            a[arrayIndex++] = r[rightIndex++];
        }

    }

}
