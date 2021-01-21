package com.bakudynamics.sort;

public class MergeSort implements Sort {

    @Override
    public <T> void sort(Comparable<T>[] a, Order order) {
        if (isNullOrEmpty(a)) return;
        mergeSort(a, a.length, order);
    }

    private <T> void mergeSort(Comparable<T>[] a, int n, Order order) {
        if (n < 2) return;

        int mid = n / 2;
        Comparable<T>[] l = new Comparable[mid];
        Comparable<T>[] r = new Comparable[n - mid];

        System.arraycopy(a, 0, l, 0, mid);
        System.arraycopy(a, mid, r, 0, n - mid);


        mergeSort(l, mid, order);
        mergeSort(r, n - mid, order);

        // merge sorted parts
        merge(a, l, r, mid, n - mid, order);

    }

    protected <T> void merge(Comparable<T>[] a,
                             Comparable<T>[] l, Comparable<T>[] r,
                             int leftLength, int rightLength,
                             Order order) {

        int leftIndex = 0, rightIndex = 0, arrayIndex = 0;

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

    @Override
    public void sort(int[] a, Order order) {
        if (isNullOrEmpty(a)) return;
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

    protected void merge(int[] a,
                         int[] l, int[] r,
                         int leftLength, int rightLength,
                         Order order) {

        int leftIndex = 0, rightIndex = 0, arrayIndex = 0;

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
