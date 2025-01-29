package com.zounon
package exercises.day1

import scala.io.StdIn
import scala.util.Random

object Games:

  def plusOrMinus(): Unit =
    var iter = 1

    // Fonction pour lire en auto
    def readKeyBoardPM(): (Int, Int) =
      var consoleNumber = 0
      var innerIter = 0
      while (consoleNumber < 1 || consoleNumber > 100) {
        print("Entrez un nombre entre 1 et 100 : ")
        consoleNumber = StdIn.readLine().toIntOption.getOrElse(0)
        innerIter += 1
      }
      (consoleNumber, innerIter)

    // Programme principale
    println("Bienvenue dans le jeu du plus ou moins")
    val number = Random.nextInt(100) + 1
    //println(s"Pour test, il nombre est $number")

    var keyboardOutput = readKeyBoardPM()

    while(keyboardOutput._1 != number) do
      if(keyboardOutput._1 < number) then
        println("Le nombre à deviner est plus grand")
      else
        println("Le nombre à deviner est plus petit")

      iter += keyboardOutput._2
      keyboardOutput = readKeyBoardPM()

    println(s"Vous avez trouvez le bon nombre: $number en $iter itération(s)")
