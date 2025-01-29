package com.zounon
package exercices.jour1

trait Vehicle:
  def makeNoise(): Unit

  def fix(): Unit = println("C'est réparé")

trait CanFly:
  def takeOff(): Unit = println("Ca décolle")

class Car extends Vehicle:
  override def makeNoise(): Unit = println("VroumVroum")

class Moto extends Vehicle:
  override def makeNoise(): Unit = println("BroumBroum")

class Bicycle extends Vehicle:
  override def makeNoise(): Unit = println("DringDring")

class Plane extends Vehicle with CanFly:
  override def makeNoise(): Unit = println("Vraoum")

object Driver:
  def drive(vehicle: Vehicle): Unit = vehicle.makeNoise()