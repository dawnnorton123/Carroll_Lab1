name := """c:\Users\dawn\Desktop\play2torial"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache,
  javaWs
)
//delete Ebean and paste it right above put a , and put it under JavaWs


libraryDependencies += "org.webjars" % "jquery" % "1.11.2"