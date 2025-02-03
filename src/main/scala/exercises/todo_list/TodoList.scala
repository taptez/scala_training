package com.zounon
package exercises.todo_list

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import scala.io.StdIn

class TodoList:
  private val aTable: String = "todo_app.todo_list"
  private val aOwner: String = "postgres"
  private var aList: List[ToDoItem] = loadListFromDataBase(aTable)


  private def loadListFromDataBase(table: String): List[ToDoItem] =
    val result = DataBaseHelper.readInDatabase(s"SELECT * FROM $table")
    var subList: List[ToDoItem] = List()
    var count: Int = 0
    while(result.next) do
      count = count + 1
      val toDo = ToDoItem(result.getInt("id"),
        result.getString("name"),
        result.getString("content"),
        result.getString("created_date"),
        result.getString("updated_date"),
        result.getString("owner"),
        count)

      subList = subList :+ toDo

    subList

  private def showList(list: List[ToDoItem]): Unit =
    var i = 0
    list.foreach(x => {
      if x.getState != TodoState.DELETE then
        println(x.internalId + " - [" + x.name + "] : " + x.content + " ## créée le " + x.createdDate)
    })

  private def createToDo(owner: String, internalId: Int): ToDoItem =
    print("\nEntrer le nom de la TODO : ")
    val nameKBOutput = StdIn.readLine()
    print("Entrer le contenu de la TODO : ")
    val contentKBOutput = StdIn.readLine()

    val today = LocalDate.now()
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
    val formattedDate = today.format(formatter)

    val todo = ToDoItem(0, nameKBOutput.trim, contentKBOutput.trim, formattedDate, "", owner, internalId)
    todo.updateState(TodoState.CREATED)
    todo


  private def searchInList(list: List[ToDoItem], text: String): Unit =
    val subList = list.filter(x => x.name.toLowerCase.contains(text.toLowerCase) || x.content.toLowerCase.contains(text.toLowerCase()) )
    showList(subList)


  private def deleteToDo(list: List[ToDoItem], position: Int): Boolean =
    if(list.isDefinedAt(position)) then
      list(position).updateState(TodoState.DELETE)
      true
    else false


  private def updatedList(list: List[ToDoItem]): Boolean =
    print("\nEntrer le numéro de ToDo à modifier : ")
    val pos = StdIn.readLine().toIntOption.getOrElse(0) - 1
    if (list.isDefinedAt(pos))
      print(s"\nEntrer le nom de la TODO (${list(pos).name}) : ")
      val nameKBOutput = StdIn.readLine()
      print(s"Entrer le contenu de la TODO (${list(pos).content}) : ")
      val contentKBOutput = StdIn.readLine()

      if(nameKBOutput.trim.nonEmpty) list(pos).name = nameKBOutput.trim
      if(contentKBOutput.trim.nonEmpty) list(pos).content = contentKBOutput.trim

      val today = LocalDate.now()
      val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
      val formattedDate = today.format(formatter)

      list(pos).updatedDate = formattedDate
      if (list(pos).getState == TodoState.BASE) then list(pos).updateState(TodoState.UPDATED)
      true
    else false


  private def saveListInDataBase(list: List[ToDoItem], table: String, owner: String): Unit =
    //var queries = StringBuilder()
    var query: String = ""
    for (item <- list) do
      item.getState match
        case TodoState.BASE => query = ""
        case TodoState.CREATED => query = s"INSERT INTO $table (name, content, created_date, owner) " +
                                          s"VALUES ('${item.name}', '${item.content}', '${item.createdDate}', '${owner}')"
        case TodoState.UPDATED => query = s"UPDATE $table " +
                                          s"SET name = '${item.name}', content = '${item.content}'," +
                                          s"updated_date = '${item.updatedDate}' " +
                                          s"WHERE id = '${item.id}'"
        case TodoState.DELETE => query = s"DELETE FROM $table WHERE id = '${item.id}'"

      if(query.nonEmpty) DataBaseHelper.writeInDatabase(query)


  def start(): Unit =
    if(DataBaseHelper.isConnected) then
      var keyboardOutput = 0
      while(keyboardOutput >= 0 && keyboardOutput <= 5) do
        println("\n\nBienvenue dans la TODO-List")
        println("1 - Afficher les TODOs")
        println("2 - Ajouter une TODO")
        println("3 - Rechercher une TODO")
        println("4 - Modifier une TODO")
        println("5 - Supprimer une TODO")
        println("0 - Enregistrer et Quitter")
        print("Que voulez-vous faire : ")
        keyboardOutput = StdIn.readLine().toIntOption.getOrElse(100)

        keyboardOutput match
          case 0 => keyboardOutput = -1
          case 1 => showList(aList)
          case 2 => aList = aList :+ createToDo(aOwner, aList.last.internalId + 1); println("ToDo ajoutée")
          case 3 =>
            print("\nEntrer le texte de recherche : ")
            val textSearch = StdIn.readLine()
            searchInList(aList, textSearch.trim)
          case 4 => if(updatedList(aList)) println("ToDo modifié") else println("Rien n'a été modifié")
          case 5 =>
            print("\nEntrer le numéro de ToDo à supprimer : ")
            val pos = StdIn.readLine().toIntOption.getOrElse(0)
            if(deleteToDo(aList, pos - 1)) println("ToDo supprimé") else println("Rien n'a été supprimé")
          case _ => keyboardOutput = 0

      println("******** Enregistrement en base de données ********")
      saveListInDataBase(aList, aTable, aOwner)
      DataBaseHelper.closeDBConnection()

