package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class BinTreePrinter<T>
{

  private final StringBuilder sb;
  private final Node<T> root;

  BinTreePrinter(final Node<T> root)
  {
    this.root=root;
    sb=new StringBuilder();
  }

  String printNode()
  {
    printNodeInternal(Collections.singletonList(root), 1, maxLevel(root));
    return sb.toString();
  }

  private void printNodeInternal(final List<Node<T>> nodes, final int level, final int maxLevel)
  {
    if (nodes.isEmpty() || isAllElementsNull(nodes))
      return;

    int floor=maxLevel - level;
    int endgeLines=(int) Math.pow(2, (Math.max(floor - 1, 0)));
    int firstSpaces=(int) Math.pow(2, (floor)) - 1;
    int betweenSpaces=(int) Math.pow(2, (floor + 1)) - 1;

    printWhitespaces(firstSpaces);

    List<Node<T>> newNodes=new ArrayList<>();
    for (Node<T> node : nodes)
    {
      if (node != null)
      {
        sb.append(node.getValue());
        newNodes.add(node.getLeft());
        newNodes.add(node.getRight());
      }
      else
      {
        newNodes.add(null);
        newNodes.add(null);
        sb.append(" ");
      }

      printWhitespaces(betweenSpaces);
    }
    sb.append("\n");

    for (int i=1; i <= endgeLines; i++)
    {
      for (Node<T> node : nodes)
      {
        printWhitespaces(firstSpaces - i);
        if (node == null)
        {
          printWhitespaces(endgeLines + endgeLines + i + 1);
          continue;
        }

        if (node.getLeft() != null)
          sb.append("/");
        else
          printWhitespaces(1);

        printWhitespaces(i + i - 1);

        if (node.getRight() != null)
          sb.append("\\");
        else
          printWhitespaces(1);

        printWhitespaces(endgeLines + endgeLines - i);
      }

      sb.append("\n");
    }

    printNodeInternal(newNodes, level + 1, maxLevel);
  }

  private void printWhitespaces(int count)
  {
    for (int i=0; i < count; i++)
      sb.append(" ");
  }

  private int maxLevel(Node<T> node)
  {
    if (node == null)
      return 0;

    return Math.max(maxLevel(node.getLeft()), maxLevel(node.getRight())) + 1;
  }

  private boolean isAllElementsNull(List<?> list)
  {
    for (Object object : list)
      if (object != null)
        return false;

    return true;
  }
}