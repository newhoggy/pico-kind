import sbt._
import Keys._

object Multibuild extends Build with Version {
  implicit class ProjectOps(self: Project) {
    def standard: Project = {
      self
          .settings(organization := "io.john-ky")
          .settings(scalacOptions := Seq(
              "-feature",
              "-deprecation",
              "-unchecked",
              "-Xlint",
              "-Yrangepos",
              "-encoding",
              "utf8"))
          .settings(scalacOptions in (console) += "-Yrangepos")
    }

    def notPublished: Project = {
      self
          .settings(publish := {})
          .settings(publishArtifact := false)
    }

    def published: Project = {
      self
          .settings(publishTo := Some("Scalap Releases" at "s3://dl.john-ky.io/maven/releases"))
          .settings(isSnapshot := true)
    }

    def dependsOnAndAggregates(projects: Project*): Project = {
      val dependencies = projects.map(pr => pr: sbt.ClasspathDep[sbt.ProjectReference])
      val aggregates = projects.map(pr => pr: sbt.ProjectReference)
      self.dependsOn(dependencies: _*).aggregate(aggregates: _*)
    }
  }
  
  lazy val `pico-kind` = Project(id = "pico-kind", base = file("pico-kind"))
    .standard
    .published
    .settings(libraryDependencies += "org.scalaz" %% "scalaz-core" % "7.1.2")
    .settings(addCompilerPlugin("org.spire-math" % "kind-projector" % "0.6.0" cross CrossVersion.binary))

  lazy val root = Project(id = "all", base = file("."))
    .notPublished
    .aggregate(`pico-kind`)
}
