package com.company;

import java.util.LinkedList;
import java.util.List;

final class BinTreeTools
{
  private BinTreeTools()
  {
    throw new AssertionError();
  }

  private static <T> Node<T> toRoot(Node<T> node)
  {
    while (!node.isRoot())
      node=node.getParent();
    return node;
  }

  private static <T> void appendToList(final Node<T> treeNode, final List<T> values)
  {
    if (treeNode.getLeft() != null)
      appendToList(treeNode.getLeft(), values);

    values.add(treeNode.getValue());

    if (treeNode.getRight() != null)
      appendToList(treeNode.getRight(), values);
  }

  static <T> List<T> toSortedList(final Node<T> anyTreeNode)
  {
    final Node<T> root=toRoot(anyTreeNode);

    final List<T> values=new LinkedList<>();
    appendToList(root, values);
    return values;
  }

  private static <T extends Comparable<T>> Node<T> findElem(final T elem, final Node<T> node)
  {
    if (node == null)
      throw new NoSuchNode();

    final int comparisionResult=elem.compareTo(node.getValue());

    if (comparisionResult == 0)
      return node;

    if (comparisionResult < 0)
      return findElem(elem, node.getLeft());

    return findElem(elem, node.getRight());
  }

  static <T extends Comparable<T>> Node<T> find(final T value, final Node<T> anyTreeNode)
  {
    final Node<T> root=toRoot(anyTreeNode);
    return findElem(value, root);

  }

  private static <T> Node<T> goUpTillInRightSubtree(final Node<T> node)
  {
    if (node.isRoot())
      return null;

    if (node.isInLeftSubtree())
      return node.getParent();

    return goUpTillInRightSubtree(node.getParent());
  }

  private static <T> Node<T> goDownToLeftSubtree(final Node<T> node)
  {
    if (node.getLeft() == null)
      return node;

    return goDownToLeftSubtree(node.getLeft());
  }

  static <T> Node<T> next(final Node<T> treeNode)
  {
    if (treeNode.getRight() != null)
      return goDownToLeftSubtree(treeNode.getRight());

    if (treeNode.isInLeftSubtree())
      return treeNode.getParent();

    if (treeNode.isInRightSubtree())
      return goUpTillInRightSubtree(treeNode);

    return null;
  }

  static <T> Node<T> leftPivot(final Node<T> root)
  {
    final Node<T> newRoot=root.getRight();

    root.setRight(newRoot.getLeft());
    newRoot.setLeft(root);

    return newRoot;
  }

  static <T> Node<T> rightPivot(final Node<T> root)
  {
    final Node<T> newRoot=root.getLeft();

    root.setLeft(newRoot.getRight());
    newRoot.setRight(root);

    return newRoot;
  }
}
