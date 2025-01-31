package com.zounon

import exercises.other.{Abs, Add, Arithmetic, Leaf, Mul, Node, TreeFunction, Value, X}

import java.time.LocalDate
import java.time.format.{DateTimeFormatter, FormatStyle}
import java.util.Locale.*

@main
def mainD3(): Unit =
  println("mainD3\n")

  //val expr: Arithmetic = Mul(Value(2), X)
  val expr: Arithmetic = Add(Mul(Value(2), Value(5)), Abs(Value(-3)))
  println(s"Expression : $expr")
  println(s"Evalution de l'expression : ${expr.eval()}")



  val now = LocalDate.now
  val df = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).withLocale(FRANCE)
  println(df.format(now))



  val t = Node(Node(Leaf(2), Leaf(3)), Leaf(5))
  println("sumValueTree(t) = " + TreeFunction.sumValueTree(t))
  println("f(t) = " + TreeFunction.deepLength(t))
