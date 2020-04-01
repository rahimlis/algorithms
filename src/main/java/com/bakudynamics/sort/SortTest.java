package com.bakudynamics.sort;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

@RunWith(Parameterized.class)
public class SortTest {
    private final Comparable[] input;
    private final Comparable[] expected;
    private final Sort.Order order;
    private final List<Sort> sortingAlgorithms =
            List.of(new InsertionSort(),
                    new BubbleSort(),
                    new MergeInsertionSort(16),
                    new MergeSort());

    public SortTest(Comparable[] input, Comparable[] expected, Sort.Order order) {
        this.input = input;
        this.expected = expected;
        this.order = order;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return List.of(new Object[][]{
                {new String[]{"abc", "bcd", "cde", "dec"}, new String[]{"dec", "cde", "bcd", "abc"}, Sort.Order.DESC},
                {new Integer[]{3, 2, 1}, new Integer[]{1, 2, 3}, Sort.Order.ASC},
                {new Integer[]{4, 1, 17, 9, 32, 3, -21}, new Integer[]{-21, 1, 3, 4, 9, 17, 32}, Sort.Order.ASC},
                {new Integer[]{0}, new Integer[]{0}, Sort.Order.ASC},
                {new Integer[]{}, new Integer[]{}, Sort.Order.ASC},
                {new Integer[]{-1, -2, -3, 0, 3, 2, 1}, new Integer[]{-3, -2, -1, 0, 1, 2, 3}, Sort.Order.ASC},
                {null, null, Sort.Order.ASC},
                {new Integer[]{5, 2, 4, 6, 1, 3}, new Integer[]{1, 2, 3, 4, 5, 6}, Sort.Order.ASC},
                {new Integer[]{5, 2, 4, 6, 1, 3}, new Integer[]{6, 5, 4, 3, 2, 1}, Sort.Order.DESC},
        });
    }

    @Test
    public void test() {
        for (Sort sortingAlgorithm : sortingAlgorithms) {
            test(sortingAlgorithm);
        }
    }

    private void test(Sort sort) {
        sort.sort(input, order);
        assertArrayEquals("Verifying " + sort.tag(), input, expected);
    }
}
