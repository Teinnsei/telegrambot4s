name := "telegrambot4s"

version := "1.0-RC2"

scalaVersion := "2.12.7"

useGpg := true

updateOptions := updateOptions.value.withGigahorse(false)

val akkaVersion = "2.5.18"
val asyncHttpClientVersion = "2.6.0"
val jacksonVersion = "2.9.7"
val scalaJavaCompatVersion = "0.9.0"
val reflectionVersion = "0.9.11"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % akkaVersion,
  "com.typesafe.akka" %% "akka-stream" % akkaVersion,
  "org.asynchttpclient" % "async-http-client" % asyncHttpClientVersion,
  "com.fasterxml.jackson.core" % "jackson-core" % jacksonVersion,
  "com.fasterxml.jackson.core" % "jackson-databind" % jacksonVersion,
  "com.fasterxml.jackson.module" %% "jackson-module-scala" % jacksonVersion,
  "org.scala-lang.modules" %% "scala-java8-compat" % scalaJavaCompatVersion,
  "org.reflections" % "reflections" % reflectionVersion
)
