package com.company;

import org.junit.Before;
import org.junit.Test;

import static com.company.NodeTools.isLeft;
import static com.company.NodeTools.isRight;
import static com.company.NodeTools.isRoot;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class NodeToolsTest {
    private Node root;
    private Node rigth;
    private Node left;

    @Before
    public void setUp() throws Exception {
        root = Node.root();
        rigth = root.addRight();
        left = root.addLeft();
    }

    @Test
    public void testNodeWithNoParentIsRoot() throws Exception {
        assertFalse(root.getParent().isPresent());
        assertTrue(isRoot(root));
    }

    @Test
    public void testNodeWithParentIsNotRoot() throws Exception {
        assertTrue(left.getParent().isPresent());
        assertFalse(isRoot(left));
    }

    @Test
    public void testIsRight() throws Exception {
        assertTrue(isRight(rigth));
        assertFalse(isLeft(rigth));
    }

    @Test
    public void testIsLeft() throws Exception {
        assertTrue(isLeft(left));
        assertFalse(isRight(left));
    }
}