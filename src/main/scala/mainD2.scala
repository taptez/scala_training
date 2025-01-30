package com.zounon

import exercises.day2.shopping.{Accountancy, ShoppingList}

import com.zounon.examples.TestDoc

import scala.util.{Try, Success, Failure}

import scala.collection.parallel.CollectionConverters._


@main
def mainD2(): Unit =
  val sl = ShoppingList("courses.txt")
  //println(sl.getClass)
  //println("Fichier de course               : " + sl._shopFilePath)
  //println("Liste de course                 : " + sl.shopList)
  //println("Montant des courses             : " + Accountancy.getShoppingAmount(sl.shopList))
  //println("Montant des produits frais      : " + Accountancy.getShoppingAmountByCategory(sl.shopList, "Frais"))
  //println("Montant par category            : " + Accountancy.getShoppingAmountAllCategory(sl.shopList))
  //println("Montant par category            : " + Accountancy.getShoppingListCategory(sl.shopList))
  //println("Element moins de 5e             : " + Accountancy.getShoppingListWithMinValue(sl.shopList, 5))
  println("Element plus de 5e              : " + Accountancy.getShoppingListWithMaxValue(sl.shopList, 5))


  //Option et erreur
  //println(TestDoc.divideWithOption(3, 4))
  //println(TestDoc.divideWithOption(3, 0))
  //println(TestDoc.divideWithEither(3, 4))
  //println(TestDoc.divideWithEither(3, 0))


  //Gestion des erreurs - Usage de Try
  //val result = Try { 5 / 0 }
  //result match
  //  case Success(value) => println(value)
  //  case Failure(e:NullPointerException) => println(e.getMessage)
  //  case Failure(_) => println("Unknow Exception")
