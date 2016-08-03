package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

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
}