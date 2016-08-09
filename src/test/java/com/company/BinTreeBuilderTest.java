package com.company;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BinTreeBuilderTest {

    @Test
    public void testBinTreeBuilder() {
        final Node<Integer> root = BinTreeBuilder.fromRoot(5)
                .add(3)
                .add(9)
                .add(12)
                .add(8)
                .build();

        assertEquals(Integer.valueOf(5), root.getValue());
        assertEquals(Integer.valueOf(3), root.getLeft().getValue());

        final Node<Integer> right = root.getRight();
        assertEquals(Integer.valueOf(9), right.getValue());

        assertEquals(Integer.valueOf(12), right.getRight().getValue());
        assertEquals(Integer.valueOf(8), right.getLeft().getValue());
    }

    private <T extends Comparable<T>> void assertSorted(final List<T> list) throws Exception {
        for (int i = 0; i < list.size() - 1; i++)
            assertTrue(list.get(i).compareTo(list.get(i + 1)) <= 0);
    }

    @Test
    public void testToSortedArray() throws Exception {
        final Node<Integer> i = BinTreeBuilder
                .fromRoot(3)
                .add(5)
                .add(2)
                .add(6)
                .add(8)
                .add(7)
                .add(0)
                .add(15)
                .add(15)
                .add(44)
                .add(-2)
                .build();

        final List<Integer> integers = BinTreeBuilder.toSortedList(i);
        assertSorted(integers);
    }
}