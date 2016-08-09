package com.company;

class Node<T> {
    private Node<T> parent;
    private Node<T> left;
    private Node<T> right;

    private final T value;

    Node(final T value) {
        this.value = value;
    }

    final T getValue() {
        return value;
    }

    final void addLeft(final Node<T> n) {
        n.parent = this;
        this.left = n;
    }

    final void addRight(final Node<T> n) {
        n.parent = this;
        this.right = n;
    }

    Node<T> getParent() {
        return parent;
    }

    Node<T> getLeft() {
        return left;
    }

    Node<T> getRight() {
        return right;
    }

    final boolean isRoot() {
        return parent == null;
    }

    final boolean isInRightSubtree() {
        return !isRoot() && parent.right == this;
    }

    final boolean isInLeftSubtree() {
        return !isRoot() && parent.left == this;
    }

    final boolean isLeaf() {
        return getLeft() == null && getRight() == null;
    }
}
