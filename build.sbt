version := "0.1.0-SNAPSHOT"

scalaVersion := "2.13.10"

name := "embed-benchmark"

enablePlugins(JmhPlugin)

libraryDependencies ++= Seq(
  "ai.djl" % "api" % "0.22.1",
  //"com.microsoft.onnxruntime" % "onnxruntime" % "1.15.0",
  "com.microsoft.onnxruntime" % "onnxruntime_gpu" % "1.15.0"
)
