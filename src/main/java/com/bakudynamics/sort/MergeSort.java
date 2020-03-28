package com.bakudynamics.sort;

public class MergeSort implements Sort {

    @Override
    public void sort(int[] a) {
        sort(a, Order.ASC);
    }

    @Override
    public void sort(int[] a, Order order) {
        if (a == null || a.length == 0) return;
        mergeSort(a, a.length, order);
    }

    private void mergeSort(int[] a, int n, Order order) {
        if (n < 2) return;

        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        System.arraycopy(a, 0, l, 0, mid);
        System.arraycopy(a, mid, r, 0, n - mid);


        mergeSort(l, mid, order);
        mergeSort(r, n - mid, order);

        // merge sorted parts
        merge(a, l, r, mid, n - mid, order);

    }

    private void merge(int[] a, int[] l, int[] r, int leftLength, int rightLength, Order order) {
        int leftIndex = 0;
        int rightIndex = 0;
        int arrayIndex = 0;

        while (leftIndex < leftLength && rightIndex < rightLength) {
            if (l[leftIndex] < r[rightIndex]) {
                a[arrayIndex++] = order == Order.ASC ? l[leftIndex++] : r[rightIndex++];
            } else {
                a[arrayIndex++] = order == Order.ASC ? r[rightIndex++] : l[leftIndex++];
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
