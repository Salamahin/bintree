package com.company;

import java.util.LinkedList;
import java.util.List;

class BinTreeBuilder<T extends Comparable<T>> {
    private final Node<T> root;

    private BinTreeBuilder(final Node<T> root) {
        this.root = root;
    }

    static <T extends Comparable<T>> BinTreeBuilder<T> fromRoot(final T value) {
        return new BinTreeBuilder<>(new Node<>(value));
    }

    private void addToSubtree(final Node<T> parent, final T value) {
        if (parent.getValue().compareTo(value) < 0)
            appendToRightSubtree(parent, value);
        else
            appendToLeftSubtree(parent, value);
    }

    private void appendToLeftSubtree(final Node<T> parent, final T value) {
        final Node<T> left = parent.getLeft();

        if (left != null)
            addToSubtree(left, value);
        else
            parent.addLeft(new Node<>(value));
    }

    private void appendToRightSubtree(final Node<T> parent, final T value) {
        final Node<T> right = parent.getRight();

        if (right != null)
            addToSubtree(right, value);
        else
            parent.addRight(new Node<>(value));
    }

    BinTreeBuilder<T> add(final T value) {
        addToSubtree(root, value);
        return this;
    }

    Node<T> build() {
        return root;
    }

    private static <T extends Comparable<T>> Node<T> toRoot(Node<T> node) {
        while (!node.isRoot())
            node = node.getParent();
        return node;
    }

    private static <T extends Comparable<T>> void appendToList(final Node<T> treeNode, final List<T> values) {
        if (treeNode.getLeft() != null)
            appendToList(treeNode.getLeft(), values);

        values.add(treeNode.getValue());

        if (treeNode.getRight() != null)
            appendToList(treeNode.getRight(), values);
    }

    static <T extends Comparable<T>> List<T> toSortedList(final Node<T> treeNode) {
        final Node<T> root = toRoot(treeNode);

        final List<T> values = new LinkedList<>();
        appendToList(root, values);
        return values;
    }
}
