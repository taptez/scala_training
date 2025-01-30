package com.zounon
package exercises.day1

import scala.annotation.tailrec

object FunctionalPratice:
  
  def factorial(n: Int): BigInt =
    def innerFactorial(innerN: Int, acc: BigInt): BigInt =
      if (innerN < 0) then throw ArithmeticException("On ne peut pas calculer le factoriel d'un nombre négatif")
      else if (innerN == 0) then acc
      else innerFactorial(innerN - 1, innerN * acc) // n * factorial(n - 1)

    innerFactorial(n, BigInt(1))


  def reverseList[T](list: List[T]): List[T] =
    //list.reverse
    //list.foldLeft(List[T]())((v1, v2) => v2::v1)
    var innerList: List[T] = List()
    for (i <- list.length - 1 to 0 by -1) do
      innerList = innerList :+ list(i)

    innerList

  //Reverse list avec du pattern matching
  def reverseListPatternMatching[T](list: List[T]): List[T] = list match
    case head :: tail => reverseListPatternMatching(tail) :+ head
    case _ => Nil


  def mapList[T](list: List[T], f: T => T): List[T] =
    //list.map
    //println(list.head :: list.tail)
    //println(list.tail)
    list match
      case head :: tail => f(head) :: mapList(tail, f)
      case _ => Nil


  def filterList[T](list: List[T], exp: T => Boolean): List[T] =
    //list.filter
    list match
      case head :: tail => if(exp(head)) then head :: filterList(tail, exp) else filterList(tail, exp)
      case _ => Nil

