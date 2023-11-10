version := "0.1.0-SNAPSHOT"

scalaVersion := "2.13.12"

name := "embed-benchmark"

enablePlugins(JmhPlugin)

libraryDependencies ++= Seq(
  "ai.djl" % "api" % "0.22.1",
  "ai.djl.huggingface" % "tokenizers" % "0.22.1",
  "com.microsoft.onnxruntime" % "onnxruntime" % "1.16.2",
  "commons-io" % "commons-io" % "2.11.0"
)
