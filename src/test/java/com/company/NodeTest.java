package com.company;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class NodeTest {
    private Node root;
    private Node rigth;
    private Node left;

    @Before
    public void setUp() throws Exception {
        root = new Node();
        rigth = root.addRight();
        left = root.addLeft();
    }

    @Test
    public void testNodeWithNoParentIsRoot() throws Exception {
        assertTrue(root.isRoot());
    }

    @Test
    public void testNodeWithParentIsNotRoot() throws Exception {
        assertFalse(left.isRoot());
        assertFalse(rigth.isRoot());
    }

    @Test
    public void testIsRight() throws Exception {
        assertTrue(rigth.isRight());
        assertFalse(left.isRight());
        assertFalse(root.isRight());
    }

    @Test
    public void testIsLeft() throws Exception {
        assertTrue(left.isLeft());
        assertFalse(rigth.isLeft());
        assertFalse(root.isLeft());
    }
}