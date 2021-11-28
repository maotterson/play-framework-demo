name := """play-framework-demo"""
organization := "com.example"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.13.6"

libraryDependencies ++= Seq(
    guice,
    jdbc,
    javaJdbc,
    javaWs,
    "mysql" % "mysql-connector-java" % "5.1.41"
)
