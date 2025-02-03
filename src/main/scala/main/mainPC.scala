package com.zounon
package main

import examples.{Greet, MyActor}

import akka.actor.{Actor, ActorSystem, Props}

import scala.collection.parallel.CollectionConverters.*
import scala.concurrent.*
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration
import scala.util.*

@main
def mainPC(): Unit =
  println("mainPC\n")
  ///////////////////////////////////////// Utilisation de scala.collection.parallel.CollectionConverters._ /////////////////////////////////////////
  //val aList = (0 to 100).toList
  //val pList = aList.par
  //println(aList.reduce((x, y) => x - y))
  //println(pList.reduce((x, y) => x - y))
  //println(res.take(5))

  ///////////////////////////////////////// Utilisation des threads /////////////////////////////////////////
  //val thread = new Thread(() => {
  //  Thread.sleep(2000)
  //  println("Exécution sur un autre thread")
  //})
  //thread.start()

  //println("Exécution sur le thread principal")



  ///////////////////////////////////////// Utilisation des Futures /////////////////////////////////////////
  //val cList = (0 to 1000000).toList
  // Crée des Futures pour chaque élément de la liste et les exécute en parallèle
  //val futures = cList.map(x => Future {
  //  x * 2 // Exemple d'opération parallèle
  //})
  // Attends que tous les futurs soient terminés et récupère les résultats
  //val result = Future.sequence(futures)
  //println(result.isCompleted)
  //result.onComplete {
  //  case Success(values) => println(values.take(5)) // Affiche les 5 premiers résultats
  //  case Failure(exception) => println(s"Erreur: ${exception.getMessage}")
  //}
  //Thread.sleep(2000) // Pour s'assurer que les futures ont le temps d'être exécutées
  //Await.result(result, Duration.Inf)
  //println(result.isCompleted)


  ///////////////////////////////////////// Utilisation de Akka (Acteurs) /////////////////////////////////////////
  // Création du système d'acteurs
  //val system = ActorSystem("MySystem")

  // Création de l'acteur
  //val actor = system.actorOf(Props[MyActor], "myActor")

  // Envoi du message Greet à l'acteur
  //actor ! Greet

  // Arrêter l'ActorSystem après un délai pour que l'acteur ait le temps de répondre
  //system.terminate()


