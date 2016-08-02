package com.company;


import java.util.Optional;

class ComparableNode<T extends Comparable<T>> {
    private final Node node;
    private final T value;

    private ComparableNode(final Node node, final T value) {
        this.node = node;
        this.value = value;
    }

    public static <T extends Comparable<T>> ComparableNode<T> root(final T value) {
        return new ComparableNode<T>(new Node(), value);
    }

    public ComparableNode<T> addChild(final T value) {
        if (this.value.compareTo(value) >= 0)
            return new ComparableNode<T>(node.addRight(), value);
        else
            return new ComparableNode<T>(node.addLeft(), value);
    }

    public Optional<Node> getParent() {
        return node.getParent();
    }

    public Optional<Node> getLeft() {
        return node.getLeft();
    }

    public Optional<Node> getRight() {
        return node.getRight();
    }

    public boolean isRoot() {
        return node.isRoot();
    }

    public boolean isRight() {
        return node.isRight();
    }

    public boolean isLeft() {
        return node.isLeft();
    }
}
