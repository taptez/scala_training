package com.zounon

import exercises.day1.FunctionalPratice

import munit.*
import org.scalatest.funsuite.*

class FunctionnalPraticeTest extends AnyFunSuite {
  test("Test du factoriel(7)") {
    assert(FunctionalPratice.factorial(7) === 5040)
  }
}

class FunctionnalPraticeTest2 extends FunSuite {
  test("Test du factoriel(10)") {
    val obtained = FunctionalPratice.factorial(10)
    val expected = BigInt(3628800)
    assertEquals(obtained, expected)
  }
}
