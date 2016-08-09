package com.company;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BinTreeToolsTest {
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


        System.out.println(new BinTreePrinter<>(i).printNode());

        final List<Integer> integers = BinTreeTools.toSortedList(i);
        assertSorted(integers);
    }

    @Test
    public void testNextElemIsInNearestSubtree() throws Exception {
        final Node<Integer> i = BinTreeBuilder
                .fromRoot(3)
                .add(2)
                .add(1)
                .add(-1)
                .add(1)
                .build();

        throw new AssertionError();
    }

    @Test(expected = NoSuchNode.class)
    public void testFindNotPresentElementThrowsExceptionElemIsInNearestSubtree() throws Exception {
        final Node<Integer> i = BinTreeBuilder
                .fromRoot(3)
                .add(2)
                .build();

        BinTreeTools.find(4, i);
    }

    @Test
    public void testFind() throws Exception {
        final Node<Integer> i = BinTreeBuilder
                .fromRoot(3)
                .add(2)
                .add(-1)
                .add(7)
                .build();

        final Node<Integer> node = BinTreeTools.find(7, i);

        assertEquals(7L, (int) node.getValue());
    }
}