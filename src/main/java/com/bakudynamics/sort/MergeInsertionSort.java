package com.bakudynamics.sort;

public class MergeInsertionSort implements Sort {

    private final Sort insertionSort = new InsertionSort();
    private final int bucketSize;

    public MergeInsertionSort(int bucketSize) {
        this.bucketSize = bucketSize;
    }

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


        if (n <= bucketSize) {
            insertionSort.sort(l, order);
        } else {
            mergeSort(l, mid, order);
        }

        if (n <= bucketSize) {
            insertionSort.sort(r, order);
        } else {
            mergeSort(r, n - mid, order);
        }

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

    @Override
    public String tag() {
        return String.format("%s-%d", Sort.super.tag(), bucketSize);
    }
}
