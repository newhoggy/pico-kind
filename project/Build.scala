import sbt._
import Keys._

object Multibuild extends Build {
  lazy val buildSettings = Seq(
      organization := "io.john-ky",
      scalacOptions := Seq(
        "-feature",
        "-deprecation",
        "-unchecked",
        "-Xlint",
        "-Yrangepos",
        "-encoding",
        "utf8"),
      scalacOptions in (console) += "-Yrangepos"
  )

  lazy val commonSettings = Defaults.defaultSettings ++ buildSettings

  lazy val `pico-kind` = Project(id = "pico-kind", base = file("pico-kind"))
    .settings(commonSettings: _*)
    .settings(libraryDependencies += "org.scalaz" %% "scalaz-core" % "7.1.2")
    .settings(addCompilerPlugin("org.spire-math" % "kind-projector" % "0.6.0" cross CrossVersion.binary))

  lazy val root = Project(id = "livefx", base = file("."))
    .aggregate(`pico-kind`)
    .settings(commonSettings: _*)
}
