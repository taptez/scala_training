package com.zounon
package exercises.other

trait Ord {
  def < (that: Any): Boolean
  def <=(that: Any): Boolean =  (this < that) || (this == that)
  def > (that: Any): Boolean = !(this <= that)
  def >=(that: Any): Boolean = !(this < that)
}

class MDate(y: Int, m: Int, d: Int) extends Ord {
  def year = y
  def month = m
  def day = d

  override def toString(): String = year + "-" + month + "-" + day

  override def equals(that: Any): Boolean =

    that.isInstanceOf[MDate] && { //méthode utilisée pour vérifier si un objet est une instance d'un type particulier
      val d = that.asInstanceOf[MDate]  // méthode est utilisée pour effectuer une conversion de type (cast) explicite
      d.day == day && d.month == month && d.year == year
    }

  def <(that: Any): Boolean = {
    if (!that.isInstanceOf[MDate])
      sys.error("on ne peut pas comparer " + that + " et une Date")

    val d = that.asInstanceOf[MDate]
    (year < d.year) ||
      (year == d.year && (month < d.month ||
        (month == d.month && day < d.day)))
  }

}
