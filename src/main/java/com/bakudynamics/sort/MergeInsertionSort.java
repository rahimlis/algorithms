package com.bakudynamics.sort;

public class MergeInsertionSort extends MergeSort implements Sort {

    private final Sort insertionSort = new InsertionSort();
    private final int bucketSize;

    public MergeInsertionSort(int bucketSize) {
        this.bucketSize = bucketSize;
    }

    @Override
    public void sort(Comparable[] a, Order order) {
        if (a == null || a.length == 0) return;
        mergeSort(a, a.length, order);
    }

    private void mergeSort(Comparable[] a, int n, Order order) {
        if (n < 2) return;

        int mid = n / 2;
        var l = new Comparable[mid];
        var r = new Comparable[n - mid];

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

    @Override
    public String tag() {
        return String.format("%s-%d", super.tag(), bucketSize);
    }
}
