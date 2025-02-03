package com.zounon
package exercises.todo_list

import exercises.todo_list.TodoState.BASE

class ToDoItem(private val _id: Int, private var _name: String, private var _content: String, private val _createdDate : String, private var _updatedDate: String, private val _owner: String, private val _internalId: Int = 0):
  private var state: TodoState = BASE

  def getState: TodoState = this.state
  def updateState(todoState: TodoState): Unit = state = todoState

  def id: Int = _id

  def name: String = _name
  def name_=(newName: String): Unit =
    if (newName.nonEmpty) _name = newName

  def content: String = _content
  def content_=(newContent: String): Unit =
    if (newContent.nonEmpty) _content = newContent

  def createdDate: String = _createdDate

  def updatedDate: String = _updatedDate
  def updatedDate_=(newUpdateDate: String): Unit =
    if (newUpdateDate.nonEmpty) _updatedDate = newUpdateDate

  def owner: String = _owner

  def internalId: Int = _internalId
