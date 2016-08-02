package com.company;

import java.util.Optional;

public class Node {
    private Node parent;
    private Node left;
    private Node right;

    private Node(Node parent) {
        this.parent = parent;
    }

    public static Node root() {
        return new Node(null);
    }

    public Node addLeft() {
        final Node leftNode = new Node(this);
        this.left = leftNode;
        return leftNode;
    }

    public Node addRight() {
        final Node rightNode = new Node(this);
        this.right = rightNode;
        return rightNode;
    }

    public Optional<Node> getParent() {
        return Optional.ofNullable(parent);
    }

    public Optional<Node> getLeft() {
        return Optional.ofNullable(left);
    }

    public Optional<Node> getRight() {
        return Optional.ofNullable(right);
    }
}
