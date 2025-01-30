package com.zounon
package examples

import akka.actor._

case object Greet

class MyActor extends Actor  {
  val log = akka.event.Logging(context.system, this) // Création du logger Akka

  def receive = {
    case Greet =>
      log.info("Hello from the actor!") // Log un message à l'intérieur de l'acteur
  }
}