package com.bakudynamics.sort;

public interface Sort {

    default void sort(Comparable[] a) {
        sort(a, Order.ASC);
    }

    void sort(Comparable[] a, Order order);

    /**
     * @param a     first comparable
     * @param b     second comparable
     * @param order of sorting
     * @return true if a preceeds b for given order, false otherwise
     */
    default boolean isPreceding(Comparable a, Comparable b, Order order) {
        int difference = a.compareTo(b);
        return order == Order.ASC ? difference < 0 : difference > 0;
    }

    default String tag() {
        return getClass().getSimpleName();
    }

    enum Order {
        ASC,
        DESC
    }
}