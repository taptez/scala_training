package com.zounon
package examples

object TestDoc:

  def divideWithOption(x: Double, y: Double): Option[Double] = if y != 0.0 then Some(x / y) else None

  def divideWithEither(x: Double, y: Double): Either[String, Double] = if y != 0.0 then Right(x / y) else Left("Division par 0 ????")

