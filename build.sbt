name := "persistence"

version := "0.1"

scalaVersion := "2.13.0"

parallelExecution in Test := false
fork := true

libraryDependencies ++= {
  val akkaVersion = "2.5.23"
  Seq(
    "com.typesafe.akka" %% "akka-actor" % akkaVersion,
    "com.typesafe.akka" %% "akka-persistence" % akkaVersion,
    "commons-io" % "commons-io" % "2.6" % Test,
    "com.typesafe.akka" %% "akka-testkit" % akkaVersion % Test,
    "org.scalatest" %% "scalatest" % "3.0.8" % Test,
    "org.iq80.leveldb" %% "leveldb" % "0.12" % Test,
    "org.fusesource.leveldbjni" %% "leveldbjni-all" % "1.8" % Test
  )
}
