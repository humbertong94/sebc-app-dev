//[raken@cdh03 humberto]$ vi build.sbt
name := "SparkBatchExample"
version := "99893839.0" //SAD
scalaVersion := "2.11.8"
javacOptions ++= Seq("-source", "1.8", "-target", "1.8")

// ADD CLOUDERA REPO AND DEPENDENCIES FOR SPARK APPS

libraryDependencies += "org.scala-lang" % "scala-reflect" % "2.11"
libraryDependencies += "org.apache.spark" %% "spark-core" % "2.3.0.cloudera1"
libraryDependencies += "org.apache.spark" %% "spark-sql" % "2.3.0.cloudera1"
libraryDependencies += "org.apache.spark" %% "spark-streaming-flume" % "2.3.0.cloudera1"
libraryDependencies += "org.apache.spark" %% "spark-streaming" % "2.3.0.cloudera1"
resolvers += "Cloudera" at "https://repository.cloudera.com/artifactory/cloudera-repos/"
