package com.zounon

import exercises.todo_list.TodoList

import scala.io.Source


@main
def mainApp(): Unit =
  println("mainApp")

  val todoList = TodoList()
  todoList.start()


