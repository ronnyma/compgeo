ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.8.2"

lazy val root = (project in file("."))
  .settings(
    name := "compgeo",
    idePackagePrefix := Some("ai.transfinite"),
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.19" % Test
  )
