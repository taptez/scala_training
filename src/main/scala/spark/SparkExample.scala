package com.zounon
package spark

/**
import org.apache.spark.sql.SparkSession

object SparkExample {
  def main(args: Array[String]): Unit = {
    // Créer une SparkSession (nécessaire pour utiliser DataFrames ou SQL)
    val spark = SparkSession.builder
      .appName("Spark Example")
      .master("local[*]") // Utilise toutes les cores locaux
      .getOrCreate()

    // Exemple d'utilisation des RDDs
    val data = Seq("hello", "world", "spark", "example")
    val rdd = spark.sparkContext.parallelize(data)

    // Transformation et action sur le RDD
    val wordCounts = rdd
      .map(word => (word, 1))
      .reduceByKey(_ + _)

    // Afficher les résultats
    wordCounts.collect().foreach(println)

    // Arrêter Spark
    spark.stop()
  }
}
*/