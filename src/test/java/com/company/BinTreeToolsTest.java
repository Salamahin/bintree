package com.company;

import de.bechte.junit.runners.context.HierarchicalContextRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static com.company.BinTreeTools.*;
import static org.junit.Assert.*;

@RunWith(HierarchicalContextRunner.class)
public class BinTreeToolsTest {
    private <T extends Comparable<T>> void assertSorted(final List<T> list) throws Exception {
        for (int i = 0; i < list.size() - 1; i++)
            assertTrue(list.get(i).compareTo(list.get(i + 1)) <= 0);
    }

    @Test
    public void testToSortedArray() throws Exception {
        final Node<Integer> root = BinTreeBuilder
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


        final List<Integer> integers = toSortedList(root);
        assertSorted(integers);
    }

    public class NextElemContext {
        private Node<Integer> root;

        @Before
        public void setUp() throws Exception {
            root = BinTreeBuilder
                    .fromRoot(7)
                    .add(4)
                    .add(1)
                    .add(-1)
                    .add(0)
                    .add(17)
                    .add(3)
                    .add(2)
                    .add(5)
                    .build();

            System.out.println(new BinTreePrinter<>(root).printNode());
        }

        @Test
        public void testNextElemIsRightChild() throws Exception {
            final Node<Integer> elem = find(-1, root);
            final Node<Integer> nextElem = next(elem);

            assertNotNull(nextElem);
            assertEquals(0, (int) nextElem.getValue());
        }


        @Test
        public void testNextElemOfLeftSubtreeIsParent() throws Exception {
            final Node<Integer> elem = find(1, root);
            final Node<Integer> nextElem = next(elem);

            assertNotNull(nextElem);
            assertEquals(2, (int) nextElem.getValue());
        }

        @Test
        public void testNextElemOfRightSubtreeIsTheVertexOfUpperLeftSubtree() throws Exception {
            final Node<Integer> elem = find(3, root);
            final Node<Integer> nextElem = next(elem);

            assertNotNull(nextElem);
            assertEquals(4, (int) nextElem.getValue());
        }
    }


    @Test(expected = NoSuchNode.class)
    public void testFindNotPresentElementThrowsExceptionElemIsInNearestSubtree() throws Exception {
        final Node<Integer> root = BinTreeBuilder
                .fromRoot(3)
                .add(2)
                .build();

        find(4, root);
    }

    @Test
    public void testFind() throws Exception {
        final Node<Integer> root = BinTreeBuilder
                .fromRoot(3)
                .add(2)
                .add(-1)
                .add(7)
                .build();

        final Node<Integer> node = find(7, root);

        assertEquals(7L, (int) node.getValue());
    }
}