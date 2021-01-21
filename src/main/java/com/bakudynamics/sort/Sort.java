package com.bakudynamics.sort;

public interface Sort {

    default <T> void sort(Comparable<T>[] a) {
        sort(a, Order.ASC);
    }

    /**
     * Sort array of Comparable objects in given order
     * Sort is going to be in-place.
     * @param a array to sort.
     * @param order of sort
     */
    <T> void sort(Comparable<T>[] a, Order order);


    /**
     * Sort array of primitive int in ascending order
     * Sort is going to be in-place.
     * @param a array to sort.
     */
    default void sort(int[] a) {
        sort(a, Order.ASC);
    }

    /**
     * Sort array of primitive int in given order
     * Sort is going to be in-place.
     * @param a array to sort.
     */
    void sort(int[] a, Order order);

    /**
     * @param a     first comparable
     * @param b     second comparable
     * @param order of sorting
     * @return true if a preceeds b for given order, false otherwise
     */
    default boolean isPreceding(int a, int b, Order order) {
        return order == Order.ASC ? a < b : a > b;
    }

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

    default <T> boolean isNullOrEmpty(T[] a) {
        return a == null || a.length == 0;
    }

    default boolean isNullOrEmpty(int[] a) {
        return a == null || a.length == 0;
    }

    enum Order {
        ASC,
        DESC
    }
}