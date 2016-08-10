package com.company;

import java.util.Objects;

class Node<T> {
    private final T value;
    private Node<T> parent;
    private Node<T> left;
    private Node<T> right;

    Node(final T value) {
        this.value = value;
    }

    final T getValue() {
        return value;
    }

    Node<T> getParent() {
        return parent;
    }

    Node<T> getLeft() {
        return left;
    }

    final void setLeft(final Node<T> n) {
        this.left = n;
        n.parent = this;
    }

    Node<T> getRight() {
        return right;
    }

    final void setRight(final Node<T> n) {
        this.right = n;
        n.parent = this;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node<?> node = (Node<?>) o;
        return Objects.equals(left, node.left) &&
                Objects.equals(right, node.right) &&
                Objects.equals(value, node.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right, value);
    }
}
