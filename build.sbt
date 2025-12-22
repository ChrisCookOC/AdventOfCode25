ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.7.4"

lazy val root = (project in file("."))
  .settings(
    name := "Advent-of-Code-2025",
    libraryDependencies ++= testDeps
  )

val testDeps = Seq("org.scalatestplus" %% "mockito-5-18" % "3.2.19.0",
"org.scalatest" %% "scalatest" % "3.2.19").map(_ % "test")
