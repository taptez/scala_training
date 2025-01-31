package com.zounon
package exercises.other

trait Arithmetic:
  def eval(): Double


// Classe pour les additions
case class Add(a: Arithmetic, b: Arithmetic) extends Arithmetic:
  def eval(): Double = a.eval() + b.eval()


// Classe pour les multiplications
case class Mul(a: Arithmetic, b: Arithmetic) extends Arithmetic:
  def eval(): Double = a.eval() * b.eval()

// Classe pour les valeurs absolue
case class Abs(a: Arithmetic) extends Arithmetic:
  def eval(): Double = math.abs(a.eval())


// Classe pour les valeurs fini sans opération
case class Value(a: Double) extends Arithmetic:
  def eval(): Double = a


// Classe pour x
case object X extends Arithmetic:
  def eval(): Double = throw new UnsupportedOperationException("Pas possible d'évaluer ca")

