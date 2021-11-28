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
    javaJpa,
    "mysql" % "mysql-connector-java" % "5.1.41",
    "org.hibernate" % "hibernate-core" % "5.4.30.Final",
    javaWs % "test",
    "org.awaitility" % "awaitility" % "4.0.1" % "test",
    "org.assertj" % "assertj-core" % "3.14.0" % "test",
    "org.mockito" % "mockito-core" % "3.1.0" % "test",
)
Test / testOptions += Tests.Argument(TestFrameworks.JUnit, "-a", "-v")
PlayKeys.externalizeResourcesExcludes += baseDirectory.value / "conf" / "META-INF" / "persistence.xml"
