package com.bakudynamics.sort;

public class MergeInsertionSort extends MergeSort implements Sort {

    private final Sort insertionSort = new InsertionSort();
    private final int bucketSize;

    public MergeInsertionSort(int bucketSize) {
        this.bucketSize = bucketSize;
    }

    @Override
    public <T> void sort(Comparable<T>[] a, Order order) {
        if (isNullOrEmpty(a)) return;
        mergeInsertionSort(a, a.length, order);
    }

    private <T> void mergeInsertionSort(Comparable<T>[] a, int n, Order order) {
        if (n < 2) return;

        int mid = n / 2;
        var l = new Comparable[mid];
        var r = new Comparable[n - mid];

        System.arraycopy(a, 0, l, 0, mid);
        System.arraycopy(a, mid, r, 0, n - mid);


        if (n <= bucketSize) {
            insertionSort.sort(l, order);
        } else {
            mergeInsertionSort(l, mid, order);
        }

        if (n <= bucketSize) {
            insertionSort.sort(r, order);
        } else {
            mergeInsertionSort(r, n - mid, order);
        }

        // merge sorted parts
        merge(a, l, r, mid, n - mid, order);

    }

    @Override
    public void sort(int[] a, Order order) {
        if (isNullOrEmpty(a)) return;
        mergeInsertionSort(a, a.length, order);
    }

    private void mergeInsertionSort(int[] a, int n, Order order) {
        if (n < 2) return;

        int mid = n / 2;
        var l = new int[mid];
        var r = new int[n - mid];

        System.arraycopy(a, 0, l, 0, mid);
        System.arraycopy(a, mid, r, 0, n - mid);


        if (n <= bucketSize) {
            insertionSort.sort(l, order);
        } else {
            mergeInsertionSort(l, mid, order);
        }

        if (n <= bucketSize) {
            insertionSort.sort(r, order);
        } else {
            mergeInsertionSort(r, n - mid, order);
        }

        // merge sorted parts
        merge(a, l, r, mid, n - mid, order);

    }

    @Override
    public String tag() {
        return String.format("%s-%d", super.tag(), bucketSize);
    }
}
