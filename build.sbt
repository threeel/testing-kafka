name := "Que"

version := "0.1"

scalaVersion := "2.12.3"

resolvers += "Typesafe Releases" at "https://repo.typesafe.com/typesafe/releases/"
resolvers += "Typesafe Simple Repository" at "http://repo.typesafe.com/typesafe/simple/maven-releases/"
resolvers += "Apache repo" at "https://repository.apache.org/content/repositories/releases"

val akka_actor = "com.typesafe.akka" %% "akka-actor" % "2.5.2"
val scalatest = "org.scalatest" %% "scalatest" % "3.0.1" % "test"
val kafka= "org.apache.kafka" % "kafka_2.12" % "0.11.0.1" exclude("javax.jms", "jms") exclude("com.sun.jdmk", "jmxtools") exclude("com.sun.jmx", "jmxri") exclude("org.slf4j", "slf4j-simple")
val json4sNative = "org.json4s" %% "json4s-native" % "3.6.0-M1"
val log4jApi = "org.apache.logging.log4j" % "log4j-api" % "2.9.1"
val log4jCore = "org.apache.logging.log4j" % "log4j-core" % "2.9.1"

libraryDependencies ++= Seq(
  akka_actor,
  scalatest,
  kafka,
  json4sNative,
  log4jApi,
  log4jCore
)



scalacOptions += "-deprecation"
