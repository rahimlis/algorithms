package com.bakudynamics.sort;

import com.bakudynamics.utils.Logger;

public class InsertionSort implements Sort {

    @Override
    public void sort(int[] a) {
        sort(a, Order.ASC);
    }

    @Override
    public void sort(int[] a, Order order) {
        for (int i = 1; i < a.length; i++) {
            int key = a[i];
            int j = i - 1;

            Logger.debug(a);
            Logger.debug("i=%d, a[i] = key = %d; j = %d\n", i, key, j);
            Logger.debug("swapping...");
            while (j >= 0 && direction(key, a[j], order)) {
                Logger.debug("j = %d; a[j]=%d, a[j+1]=%d\n", j, a[j], a[j + 1]);
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;
            Logger.debug("swap done");
            Logger.debug(a);
            Logger.debug("");
        }
    }

    private boolean direction(int key, int ai, Order order) {
        return order == Order.ASC ? key < ai : key > ai;
    }
}
