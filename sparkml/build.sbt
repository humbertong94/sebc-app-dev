//[raken@cdh03 humberto]$ vi build.sbt
name := "SparkMLExample"
version := "1.0"
scalaVersion := "2.11.8"

javacOptions ++= Seq("-source", "1.8", "-target", "1.8")

// ADD CLOUDERA REPO AND DEPENDENCIES FOR SPARK APPS
libraryDependencies ++= Seq("org.apache.spark" %% "spark-core" % "2.3.0.cloudera2" % "provided")
libraryDependencies ++= Seq("org.apache.spark" %% "spark-sql" % "2.3.0.cloudera2" % "provided")
libraryDependencies ++= Seq("org.apache.spark" %% "spark-streaming-flume" % "2.3.0.cloudera2" % "provided")
libraryDependencies ++= Seq("org.apache.spark" %% "spark-streaming" % "2.3.0.cloudera2" % "provided")
libraryDependencies ++= Seq("org.apache.spark" %% "spark-mllib" % "2.3.0.cloudera2" % "provided")