package com.zounon
package examples

import scala.annotation.tailrec

object Functional:
  def notRecursiveExample(n: Int): Unit =
    for (i <- 0 until n) do
      println("Code here")


  def recursiveExample(n: Int): Unit =
    if(n <= 0) then
      return
    else
      println("Code here")
      recursiveExample(n - 1)


  //@tailrec
  def recursiveLengthNT[T](item: List[T]): Int =
    if(item.isEmpty) 0 else 1 + recursiveLengthNT(item.tail)


  def recursiveLengthRT(range: Range): Int =
    def innerLength(innerRange: Range, acc: Int): Int =
      if (innerRange.isEmpty) acc
      else innerLength(innerRange.tail, acc + 1)

    innerLength(range, 0)


  def sum(x:Int, y: Int, z:Int) = x + y + z
  def curryfieldSum(x: Int)(y: Int)(z: Int) = x + y + z
  def partialSum1 = curryfieldSum(10)_             //definit une fonction (Int , Int ) => Int qui calcule 10 + y + z
  def partialSum2 = curryfieldSum(10)(10)_         //definit une fonction Int => Int qui calcule 10 + 10 + z

