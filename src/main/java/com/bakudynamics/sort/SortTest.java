package com.bakudynamics.sort;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

@RunWith(Parameterized.class)
public class SortTest {
    private final int[] input;
    private final int[] expected;
    private final Sort.Order order;

    public SortTest(int[] input, int[] expected, Sort.Order order) {
        this.input = input;
        this.expected = expected;
        this.order = order;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return List.of(new Object[][]{
                {new int[]{3, 2, 1}, new int[]{1, 2, 3}, Sort.Order.ASC},
                {new int[]{0}, new int[]{0}, Sort.Order.ASC},
                {new int[]{}, new int[]{}, Sort.Order.ASC},
                {new int[]{-1, -2, -3, 0, 3, 2, 1}, new int[]{-3, -2, -1, 0, 1, 2, 3}, Sort.Order.ASC},
                {null, null, Sort.Order.ASC},
                {new int[]{5, 2, 4, 6, 1, 3}, new int[]{1, 2, 3, 4, 5, 6}, Sort.Order.ASC},
                {new int[]{5, 2, 4, 6, 1, 3}, new int[]{6, 5, 4, 3, 2, 1}, Sort.Order.DESC}
        });
    }

    @Test
    public void test() {
        Sort sort = new InsertionSort();
        sort.sort(input, order);
        assertArrayEquals(input, expected);
    }
}
