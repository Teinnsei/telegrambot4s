ThisBuild / organization := "io.halahutskyi.telegrambot4s"
ThisBuild / organizationName := "telegrambot4s"
ThisBuild / organizationHomepage := Some(url("https://halahutskyi.io/"))

ThisBuild / scmInfo := Some(
  ScmInfo(
    url("https://github.com/Teinnsei/telegrambot4s"),
    "scm:git@github.com:Teinnsei/telegrambot4s.git"
  )
)
ThisBuild / developers := List(
  Developer(
    id    = "teinnsei",
    name  = "Oleksandr Halahutskyi",
    email = "halahutskyi@protonmail.com",
    url   = url("http://halahutskyi.io")
  )
)

ThisBuild / description := "TelegramBot4s"
ThisBuild / licenses := List("Apache 2" -> new URL("http://www.apache.org/licenses/LICENSE-2.0.txt"))
ThisBuild / homepage := Some(url("http://telegrambot4s.halahutskyi.io"))

ThisBuild / pomIncludeRepository := { _ => false }
ThisBuild / publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (isSnapshot.value) Some("snapshots" at nexus + "content/repositories/snapshots")
  else Some("releases" at nexus + "service/local/staging/deploy/maven2")
}
ThisBuild / publishMavenStyle := true

ThisBuild / credentials += Credentials(Path.userHome / ".sbt" / "sonatype_credential")
