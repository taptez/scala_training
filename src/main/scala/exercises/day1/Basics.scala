package com.zounon
package exercises.day1

object Basics:

  def fizzBuzz(number: Int = 10): Unit =
    (1 to number).map(x => if (x % 3 == 0 && x % 5 == 0) then println("FizzBuzz") else if(x % 3 == 0) then println("Fizz") else println(x))

  def savings(beginAmount: Double, endAmount: Double, ratesInterest: Double): Int =
    (endAmount / (beginAmount + (beginAmount * ratesInterest))).toInt

  def pairIntNumbers(list: List[Int]): Int =
    list.count(x => x % 2 == 0)

  def syracuse(number: Int): Unit =
    if (number < 1 || number > 100) then
      println(s"Le nombre $number n'est pas pris en compte")
    else if (number == 1) then
      println(s"On est à 1")
    else
      var newNumber = number

      while(newNumber > 1) do
        if (newNumber % 2 == 0) then
          println(s"$newNumber est pair, on prend la moitié, on trouve " + (newNumber / 2))
          newNumber = newNumber / 2
        else
          println(s"$newNumber est impair, on prend le triple et on ajoute 1, on trouve " + ((newNumber * 3) + 1))
          newNumber = (newNumber * 3) + 1

      println(s"On est à 1")

  def primaryNumber(number: Int): Boolean =
    number > 1 && (2 to Math.sqrt(number).toInt).forall(number % _ != 0)

  def eratosthene(number: Int): Unit =
    (1 to number).map(x => if(primaryNumber(x)) then println(x))

  def fibonacciPos(number: Int): BigInt =
    if(number == 0) then
      0
    else if(number == 1) then
      1
    else
      var v1: BigInt = 0
      var v2: BigInt = 1
      var temp: BigInt = v1 + v2
      for(i <- 2 to number) do
        temp = v1 + v2
        v1 = v2
        v2 = temp

      temp
