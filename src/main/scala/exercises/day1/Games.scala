package com.zounon
package exercises.day1

import scala.io.StdIn
import scala.util.Random

object Games:

  def plusOrMinus(): Unit =
    var iter = 0

    // Fonction pour lire en auto
    def readKeyBoardPM(): Int =
      var consoleNumber = 0
      while (consoleNumber < 1 || consoleNumber > 100) {
        print("Entrez un nombre entre 1 et 100 : ")
        consoleNumber = StdIn.readLine().toIntOption.getOrElse(0)
        iter += 1
      }
      consoleNumber

    // Programme principale
    println("Bienvenue dans le jeu du plus ou moins")
    val number = Random.nextInt(100) + 1
    //println(s"Pour test, il nombre est $number")

    var curNumber = readKeyBoardPM()

    while(curNumber != number) do
      if(curNumber < number) then
        println("Le nombre à deviner est plus grand")
      else
        println("Le nombre à deviner est plus petit")

      curNumber = readKeyBoardPM()

    println(s"Vous avez trouvez le bon nombre: $number en $iter itération(s)")
