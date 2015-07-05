scalaVersion in ThisBuild := "2.11.6"

crossScalaVersions := Seq("2.10.5", "2.11.6")

resolvers in ThisBuild ++= Seq(
    "bintray/non" at "http://dl.bintray.com/non/maven",
    "Scalap Releases" at "s3://dl.john-ky.io/maven/snapshots")

version in ThisBuild := buildVersion
