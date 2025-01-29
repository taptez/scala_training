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
