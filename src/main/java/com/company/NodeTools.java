package com.company;

public final class NodeTools {
    private NodeTools() {
        throw new AssertionError();
    }

    static boolean isRoot(final Node n) {
        return !n.getParent().isPresent();
    }

    static boolean isRight(final Node n) {
        return n.getParent()
                .flatMap(Node::getRight)
                .map(right -> right == n)
                .orElse(false);
    }

    static boolean isLeft(final Node n) {
        return n.getParent()
                .flatMap(Node::getLeft)
                .map(left -> left == n)
                .orElse(false);
    }

}
