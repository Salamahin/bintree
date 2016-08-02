package com.company;

import java.util.Optional;

class Node {
    private Node parent;
    private Node left;
    private Node right;

    final Node addLeft() {
        final Node leftNode = new Node();

        leftNode.parent = this;
        this.left = leftNode;

        return leftNode;
    }

    final Node addRight() {
        final Node rightNode = new Node();

        rightNode.parent = this;
        this.right = rightNode;

        return rightNode;
    }

    final Optional<Node> getParent() {
        return Optional.ofNullable(parent);
    }

    final Optional<Node> getLeft() {
        return Optional.ofNullable(left);
    }

    final Optional<Node> getRight() {
        return Optional.ofNullable(right);
    }

    final boolean isRoot() {
        return parent == null;
    }

    final boolean isRight() {
        return !isRoot() && parent.right == this;
    }

    final boolean isLeft() {
        return !isRoot() && parent.left == this;
    }
}
