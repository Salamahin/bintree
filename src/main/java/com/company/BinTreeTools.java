package com.company;

import java.util.LinkedList;
import java.util.List;

final class BinTreeTools {
    private BinTreeTools() {
        throw new AssertionError();
    }

    private static <T> Node<T> toRoot(Node<T> node) {
        while (!node.isRoot())
            node = node.getParent();
        return node;
    }

    private static <T> void appendToList(final Node<T> treeNode, final List<T> values) {
        if (treeNode.getLeft() != null)
            appendToList(treeNode.getLeft(), values);

        values.add(treeNode.getValue());

        if (treeNode.getRight() != null)
            appendToList(treeNode.getRight(), values);
    }

    static <T> List<T> toSortedList(final Node<T> treeNode) {
        final Node<T> root = toRoot(treeNode);

        final List<T> values = new LinkedList<>();
        appendToList(root, values);
        return values;
    }

    private static <T extends Comparable<T>> Node<T> findElem(final T elem, final Node<T> node) {
        if (node == null)
            throw new NoSuchNode();

        final int comparisionResult = elem.compareTo(node.getValue());

        if (comparisionResult == 0)
            return node;

        if (comparisionResult < 0)
            return findElem(elem, node.getLeft());

        return findElem(elem, node.getRight());
    }

    static <T extends Comparable<T>> Node<T> find(final T value, final Node<T> treeNode) {
        final Node<T> root = toRoot(treeNode);
        return findElem(value, root);

    }

    static <T> Node<T> nextElem(final Node<T> treeNode) {
        if (treeNode.isInRightSubtree() && treeNode.isLeaf())
            return null;

        return null;
    }
}