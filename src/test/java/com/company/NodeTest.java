package com.company;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class NodeTest {
    private Node<Void> root;
    private Node<Void> right;
    private Node<Void> left;

    @Before
    public void setUp() throws Exception {
        root = getVoidNode();

        right = getVoidNode();
        root.addRight(right);

        left = getVoidNode();
        root.addLeft(left);
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
        assertTrue(right.isRight());
        assertFalse(left.isRight());
        assertFalse(root.isRight());
    }

    @Test
    public void testIsLeft() throws Exception {
        assertTrue(left.isLeft());
        assertFalse(right.isLeft());
        assertFalse(root.isLeft());
    }
}