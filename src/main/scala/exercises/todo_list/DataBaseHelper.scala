package com.zounon
package exercises.todo_list

import java.sql.{Connection, DriverManager, ResultSet, Statement}
import scala.io.Source

object DataBaseHelper:

  private val host = "localhost"
  private val port = "5432"
  private val database = "todo_app"
  private val url = s"jdbc:postgresql://$host:$port/$database"

  private val username = getCredentials._1
  private val password = getCredentials._2

  private val connection: Connection = initConnection()
  private val statement: Statement = connection.createStatement()

  private def getCredentials: (String, String) =
    val file = Source.fromResource("db/connection.txt")
    val lines: Iterator[String] = file.getLines()
    lines.toList.map(x => (x.split(";")(0), x.split(";")(1))).head

  private def initConnection(): Connection =
    try {
      DriverManager.getConnection(url, username, password)
    } catch
      case e: Exception => println("La connexion à la base de données a échouée")  ; null

  def readInDatabase(query: String): ResultSet =
    statement.executeQuery(query)

  def writeInDatabase(query: String): Boolean =
    //val query = "INSERT INTO table_exemple (colonne1, colonne2) VALUES (?, ?)"
    //statement = connection.prepareStatement(query)
    //statement.setString(1, "valeur1")
    //val rowsAffected = statement.executeUpdate()

    try
      //println(query)
      val rs = statement.executeUpdate(query)
      rs > 0
    catch
      case e: Exception => false

  def isConnected: Boolean = statement != null && connection != null

  def closeDBConnection(): Unit =
    if (statement != null) statement.close()
    if (connection != null) connection.close()