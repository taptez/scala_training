package com.zounon
package exercises.other

import exercises.other.Time.fromMinutes

case class Time(hours: Int = 0, minutes : Int = 0):
  require(hours >= 0 && hours <= 23 && minutes >= 0 && minutes <= 59, s"Impossible d'initialiser le temps avec ${hours}h et ${minutes}m")

  val asMinutes: Int = (hours * 60) + minutes

  //override def toString: String = s"${hours}h${minutes}"

  def minus(t: Time): Int =
    if asMinutes - t.asMinutes >= 0 then asMinutes - t.asMinutes else 0

  def -(t: Time): Int =
    minus(t)

  def giveTime(minTime: Int): Time = fromMinutes(minTime)



object Time:
  def fromMinutes(minTime: Int): Time = Time((minTime / 60), minTime - ((minTime / 60) * 60))

