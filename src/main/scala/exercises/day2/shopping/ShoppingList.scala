package com.zounon
package exercises.day2.shopping

import scala.io.Source

class ShoppingList(val _shopFilePath: String):

  val shopList: List[(String, String, Double)] = loadListFromFile(_shopFilePath)

  private def loadListFromFile(filePath: String) : List[(String, String, Double)] =
    //val file = Source.fromFile(s"src/main/resources/$filePath")

    val file = Source.fromResource(filePath)
    val lines: Iterator[String] = file.getLines()

    lines.filter(line => line.trim != "" && line.split(";").length >= 3).
      toList.
      map(item => (item.split(";")(0), item.split(";")(1), item.split(";")(2).toDoubleOption.getOrElse(0.0)))
