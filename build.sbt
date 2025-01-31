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



//libraryDependencies ++= Seq(
//  "org.apache.spark" %% "spark-core" % "3.1.2",
//  "org.apache.spark" %% "spark-sql" % "3.1.2"
//)