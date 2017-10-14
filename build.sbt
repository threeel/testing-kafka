name := "Que"

version := "0.1"

scalaVersion := "2.12.3"

resolvers += "Typesafe Releases" at "https://repo.typesafe.com/typesafe/releases/"
resolvers += "Typesafe Simple Repository" at "http://repo.typesafe.com/typesafe/simple/maven-releases/"
resolvers += "Apache repo" at "https://repository.apache.org/content/repositories/releases"

libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.5.2"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1" % "test"
libraryDependencies +="org.apache.kafka" % "kafka_2.12" % "0.11.0.1" exclude("javax.jms", "jms") exclude("com.sun.jdmk", "jmxtools") exclude("com.sun.jmx", "jmxri") exclude("org.slf4j", "slf4j-simple")
scalacOptions += "-deprecation"
