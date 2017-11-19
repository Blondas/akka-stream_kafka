name := "akka-stream_kafka"

version := "0.1"

scalaVersion := "2.12.4"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % "2.5.6",
  "com.typesafe.akka" %% "akka-testkit" % "2.5.6" % Test,
  "org.scalatest" % "scalatest_2.12" % "3.0.4" % "test",
  "com.typesafe.akka" %% "akka-stream-kafka" % "0.17"
)