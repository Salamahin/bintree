package com.company;

final class BinTreeBuilder<T extends Comparable<T>> {
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
            parent.setLeft(new Node<>(value));
    }

    private void appendToRightSubtree(final Node<T> parent, final T value) {
        final Node<T> right = parent.getRight();

        if (right != null)
            addToSubtree(right, value);
        else
            parent.setRight(new Node<>(value));
    }

    BinTreeBuilder<T> add(final T value) {
        addToSubtree(root, value);
        return this;
    }

    Node<T> build() {
        return root;
    }
}
