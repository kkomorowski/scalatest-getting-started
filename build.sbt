scalaVersion := "3.5.0"

val circeVersion = "0.14.10"
val sttpVersion = "3.9.8"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.19" % "test"
libraryDependencies += "com.softwaremill.sttp.client3" %% "core" % sttpVersion
libraryDependencies += "com.softwaremill.sttp.client3" %% "circe" % sttpVersion
libraryDependencies += "io.circe" %% "circe-core" % circeVersion
libraryDependencies += "io.circe" %% "circe-generic" % circeVersion
libraryDependencies += "io.circe" %% "circe-parser" % circeVersion
