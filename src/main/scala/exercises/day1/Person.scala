package com.zounon
package exercises.day1

class Person(_name: String, _gender: String, _birthYear: Int) :
  val name: String = _name
  private var gender: String = _gender
  private val birthYear: Int = _birthYear

  def isOlder(person: Person): Boolean = this.birthYear > person.birthYear

  protected def getGender: String = gender


class VeryImportantPerson(_name: String, _gender: String, _birthYear: Int) extends Person(_name, _gender, _birthYear):

  override def isOlder(person: Person): Boolean = false

  override def getGender: String = super.getGender

object Person:
  def apply(_name: String, _gender: String, _birthYear: Int): Person = Person(_name: String, _gender: String, _birthYear: Int)