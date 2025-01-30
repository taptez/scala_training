ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.3.5"

val AkkaVersion = "2.10.1"

lazy val root = (project in file("."))
  .settings(
    name := "formation",
    idePackagePrefix := Some("com.zounon"),

  )

resolvers += "Akka library repository".at("https://repo.akka.io/maven")

libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.19" % Test
libraryDependencies += "org.scalameta" %% "munit" % "1.1.0" % Test

libraryDependencies += "org.scala-lang.modules" %% "scala-parallel-collections" % "1.2.0"

libraryDependencies += "com.typesafe.akka" %% "akka-actor-typed" % AkkaVersion
libraryDependencies += "com.typesafe.akka" %% "akka-actor-testkit-typed" % AkkaVersion % Test

libraryDependencies += "org.slf4j" % "slf4j-api" % "1.7.32"  // Version SLF4J
libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.2.6"  // Version Logback
libraryDependencies += "ch.qos.logback" % "logback-core" % "1.2.6"  // Version Logback Core
