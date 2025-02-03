package com.zounon
package main

//import org.apache.spark.{SparkConf, SparkContext}


@main
def mainSpark(): Unit=
  println("mainSpark")

  // val conf = SparkConf().setMaster("local").setAppName("Spark Test with Scala")
  // val sc = new SparkContext(conf)

  // val dataTest = sc.textFile("src/main/resources/file_spark.txt") // RDD
  // val dataTest = spark.read.textFile("src/main/resources/file_spark.txt") // DataFrame
  // val dataTest = spark.read.textFile("src/main/resources/file_spark.txt").as[String] // DataFrame


  // dataTest.count()
  // dataTest.first()
  // dataTest.take(5)
  // dataTest.collect() // Une partie du contenu
  // dataTest.show(5) // Show ne fonctionne pas sur les RDDs

  // val linesWithDoll = dataTest.filter(line => line.contains("poupée"))
  // linesWithDoll.take(2)

  // val linesLength = dataTest.map(l => l.length)
  // linesLength.take(5)

  // dataTest.filter(l => l.contains("poupée")).count()

  // dataTest.map(l => l.length).reduce((a, b) => a + b)

  // dataTest.flatMap(line => line.split(" ")).show()
  // val delimiters = "[ .;,?!--()_]"
  // val wordsDataTest = dataTest.flatMap(line => line.split(delimiters))
  // wordsDataTest.persist() // conservation du résultat
  // wordsDataTest.show()

  // val wordsNumber = wordsDataTest.groupByKey(identity).count()
  // wordsNumber.show(30)

  // val wordNumberPerLine = dataTest.map(l => l.split(delimiters).size)
  // wordNumberPerLine.persist()
  // val lMax = wordNumberPerLine.reduce((a, b) => if (a > b) a else b)
  // val lAvg = wordNumberPerLine.reduce((a, b) => a + b) / dataTest.count()

  // dataTest.printSchema()

  // Création d'une vue SQL temporaire "mots"
  // dataTest.createOrReplaceTempView("mots")
  // spark.sql("SELECT value FROM mots WHERE value LIKE '%une%'").show(false)
  // Application d'une requête SQL sur la vue temporaire
  // val tableT = spark.sql("SELECT value FROM mots WHERE value > 't'") // DataFrame contenant les mots qui viennent après la lettre t dans le dictionnaire
  // tableT.show()

