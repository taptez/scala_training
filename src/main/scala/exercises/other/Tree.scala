package com.zounon
package exercises.other

trait Tree:
  def sum(): Int


case class Node(rightNode: Tree, leftNode: Tree) extends Tree:
  def sum(): Int = rightNode.sum() + leftNode.sum()


case class Leaf(value: Int) extends Tree:
  def sum(): Int = value


object TreeFunction:
  def sumValueTree(t: Tree): Int =
    t match
      case Leaf(v) => v
      case Node(r, l) => r.sum() + l.sum()


  def deepLength: Tree => Int =
    case Leaf(0) => 0
    case Leaf(v) if v < 0 => -1
    case Leaf(v) if v > 0 => 1
    case Node(r, l) => deepLength(r) + deepLength(l)

