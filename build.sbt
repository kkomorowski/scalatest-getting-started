scalaVersion := "3.3.1"

val circeVersion = "0.14.6"
val sttpVersion = "3.9.3"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.17" % "test"
libraryDependencies += "com.softwaremill.sttp.client3" %% "core" % sttpVersion
libraryDependencies += "com.softwaremill.sttp.client3" %% "circe" % sttpVersion
libraryDependencies += "io.circe" %% "circe-core" % circeVersion
libraryDependencies += "io.circe" %% "circe-generic" % circeVersion
libraryDependencies += "io.circe" %% "circe-parser" % circeVersion
