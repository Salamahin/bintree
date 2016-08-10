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

    @Test
    public void testPivotLeft() throws Exception {
        final Node<Integer> original = BinTreeBuilder
                .fromRoot(5)
                .add(3)
                .add(8)
                .add(7)
                .add(10)
                .build();

        final Node<Integer> leftPivoted = BinTreeBuilder
                .fromRoot(8)
                .add(5)
                .add(10)
                .add(3)
                .add(7)
                .build();

        assertEquals(leftPivoted, leftPivot(original));
    }

    @Test
    public void testPivotRight() throws Exception {
        final Node<Integer> original = BinTreeBuilder
                .fromRoot(5)
                .add(3)
                .add(7)
                .add(4)
                .add(2)
                .build();

        final Node<Integer> rightPivoted = BinTreeBuilder
                .fromRoot(3)
                .add(2)
                .add(5)
                .add(4)
                .add(7)
                .build();

        assertEquals(rightPivoted, BinTreeTools.rightPivot(original));
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
                    .add(17)
                    .add(3)
                    .add(2)
                    .add(5)
                    .add(6)
                    .build();
        }

        @Test
        public void testNextElemIsRightChild() throws Exception {
            final Node<Integer> elem = find(4, root);
            final Node<Integer> nextElem = next(elem);

            assertNotNull(nextElem);
            assertEquals(5, (int) nextElem.getValue());
        }


        @Test
        public void testNextElemOfLeftSubtreeIsParent() throws Exception {
            final Node<Integer> elem = find(-1, root);
            final Node<Integer> nextElem = next(elem);

            assertNotNull(nextElem);
            assertEquals(1, (int) nextElem.getValue());
        }

        @Test
        public void testNextElemOfRightSubtreeIsTheVertexOfUpperLeftSubtree() throws Exception {
            final Node<Integer> elem = find(6, root);
            final Node<Integer> nextElem = next(elem);

            assertNotNull(nextElem);
            assertEquals(7, (int) nextElem.getValue());
        }

        @Test
        public void testNextElemOfRightLeafIsNull() throws Exception {
            final Node<Integer> elem = find(17, root);
            final Node<Integer> nextElem = next(elem);

            assertNull(nextElem);
        }
    }
}