package com.company;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NodeTest {
    private Node<Void> root;
    private Node<Void> right;
    private Node<Void> left;

    @Before
    public void setUp() throws Exception {
        root = getVoidNode();

        right = getVoidNode();
        root.setRight(right);

        left = getVoidNode();
        root.setLeft(left);
    }

    private Node<Void> getVoidNode() {
        return new Node<>(null);
    }

    @Test
    public void testNodeWithNoParentIsRoot() throws Exception {
        assertTrue(root.isRoot());
    }

    @Test
    public void testNodeWithParentIsNotRoot() throws Exception {
        assertFalse(left.isRoot());
        assertFalse(right.isRoot());
    }

    @Test
    public void testIsRight() throws Exception {
        assertTrue(right.isInRightSubtree());
        assertFalse(left.isInRightSubtree());
        assertFalse(root.isInRightSubtree());
    }

    @Test
    public void testIsLeft() throws Exception {
        assertTrue(left.isInLeftSubtree());
        assertFalse(right.isInLeftSubtree());
        assertFalse(root.isInLeftSubtree());
    }

    @Test
    public void testLeftIsLeaf() throws Exception {
        assertTrue(left.isLeaf());
    }

    @Test
    public void testRightIsLeaf() throws Exception {
        assertTrue(right.isLeaf());
    }

    @Test
    public void testNodeWithChildIsNotLeaf() throws Exception {
        final Node<Void> nodeWithChild = getVoidNode();
        nodeWithChild.setLeft(new Node<>(null));

        assertFalse(nodeWithChild.isLeaf());
    }

    @Test
    public void testEquals() throws Exception {
        final Node<Integer> tree = BinTreeBuilder
                .fromRoot(5)
                .add(3)
                .add(7)
                .add(8)
                .add(10)
                .build();

        final Node<Integer> anotherTree = BinTreeBuilder
                .fromRoot(5)
                .add(3)
                .add(7)
                .add(8)
                .add(10)
                .build();

        assertEquals(tree, anotherTree);
    }

    @Test
    public void testNotEquals() throws Exception {
        final Node<Integer> tree = BinTreeBuilder
                .fromRoot(5)
                .add(3)
                .add(7)
                .add(8)
                .add(10)
                .build();

        final Node<Integer> anotherTree = BinTreeBuilder
                .fromRoot(5)
                .add(3)
                .add(7)
                .add(8)
                .add(11)
                .build();

        assertNotEquals(tree, anotherTree);
    }
}