package com.zounon


import munit.FunSuite

class ForComprehensionTest extends FunSuite {
  test("For Comprehension - Exercice 1") {
    val obtained = (1 to 10).map(x => x * 2)
    val expected = for {
      x <- 1 to 10
    } yield(x * 2)
    assertEquals(obtained, expected)
  }

  test("For Comprehension - Exercice 2") {
    val obtained = (1 to 10).flatMap(x => (10 to 1 by -1).map(y => x + y))
    val expected = for {
      x <- 1 to 10
      y <- 10 to 1 by -1
    } yield( x + y)
    assertEquals(obtained, expected)
  }

  test("For Comprehension - Exercice 3") {
    val obtained = (1 to 10).filter(x => x % 3 == 0).map(x => x * x)
    val expected = for {
      x <- 1 to 10
      if x % 3 == 0
    } yield(x * x)
    assertEquals(obtained, expected)
  }

  test("For Comprehension - Exercice 4") {
    val obtained = for {x <- 1 to 100} yield x/2
    val expected = (1 to 100).map(x => x / 2)
    assertEquals(obtained, expected)
  }

  test("For Comprehension - Exercice 5") {
    val obtained = for {x <- 1 to 100; if (x < 50)} yield x+50
    val expected = (1 to 100).filter(_ < 50).map(x => x + 50)
    assertEquals(obtained, expected)
  }

  test("For Comprehension - Exercice 6") {
    val obtained = for {
      x <- 1 to 50
      y <- x to 50
      if Math.sqrt(x*x + y*y).isValidInt
    } yield (x,y, Math.sqrt(x*x + y*y).toInt)
    val expected = (1 to 50).flatMap(x => (x to 50).map(y => (x, y, if Math.sqrt(x*x + y*y).isValidInt then Math.sqrt(x*x + y*y).toInt else -1 )))
      .filter(z => z._3 != -1)

    //println(obtained)
    //println(expected)
    assertEquals(obtained, expected)
  }
}
