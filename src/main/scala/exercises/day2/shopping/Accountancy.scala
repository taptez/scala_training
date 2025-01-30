package com.zounon
package exercises.day2.shopping

object Accountancy:

  def getShoppingAmount(list: List[(String, String, Double)]): Double =
    list.map(_._3).sum

  def getShoppingAmountByCategory(list: List[(String, String, Double)], category: String): Double =
    getShoppingAmount(list.filter(_._1 == category))


  def getShoppingAmountAllCategory(list: List[(String, String, Double)]): Map[String, Double] =
    var map: Map[String, Double] = Map()
    list.map(_._1).foreach(x => map += (x -> getShoppingAmountByCategory(list, x)) )
    map


  def getShoppingListCategory(list: List[(String, String, Double)]): Set[String] =
    list.map(_._1).toSet


  def getShoppingListWithMinValue(list: List[(String, String, Double)], value: Double): List[(String, String, Double)] =
    list.filter(_._3 <= value)


  def getShoppingListWithMaxValue(list: List[(String, String, Double)], value: Double): List[(String, String, Double)] =
    list.filter(_._3 >= value)
