package com.github.shuttie.embedbench

import java.io.{File, FileInputStream}

object Main {
  val path = "/home/shutty/code/metarank-huggingface"
  val model = "all-MiniLM-L6-v2"
  def main(args: Array[String]): Unit = {
    val session = OnnxSession.load(
      model = new FileInputStream(new File(s"$path/$model/pytorch_model.onnx")),
      dic = new FileInputStream(new File(s"$path/$model/vocab.txt")),
      dim = 384,
      gpu = true
    )
    val encoder = OnnxBiEncoder(session)
    encoder.embed(Array("hello, world"))
  }
}
