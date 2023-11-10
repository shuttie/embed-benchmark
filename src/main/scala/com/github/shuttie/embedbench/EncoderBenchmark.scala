package com.github.shuttie.embedbench

import org.openjdk.jmh.annotations._

import java.io.{File, FileInputStream}
import java.util.concurrent.TimeUnit

@BenchmarkMode(Array(Mode.AverageTime))
@Warmup(iterations = 5, time = 1)
@Measurement(iterations = 5, time = 1)
@Fork(1)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Benchmark)
class EncoderBenchmark {

  val TEXT =
    """5D DIY Diamond Painting is the new popular product Can be used in the Bedroom, Dinning Room,
      |Bathroom, Washroom, Kitchen, Study, Home, Office Hotel, Restaurant and Bar,shining in the light ,
      |is currently most popular DIY decorations,Wealth and Good Fortune Diamond Painting Embroidery Home
      |Decoration.very shining and bling.Make your house looks more pretty. DIY Diamond painting instruction
      |steps 1.Take out the diamond painting kits 2.Please only need to lift a small part of the release
      |paper, in order to avoid other regional sticky dust affect. 3.Find the corresponding diamond bag
      |according to the numbers or letters, put the diamonds into the tray and shake. 4.Use the penpoint
      |to adsorb the painting muds and diamond, press it to the canvas's corresponding position. 5.Press
      |diamonds on the canvas with book or hand to make them more fixed. then 5d diamond paintings is done.
      |Package Included 1 x Canvas 1 x set Resin Diamonds 1 x Diamond painting pen 1 x Diamond tray
      |1×Painting Muds SPECIFICATION Diamond Size: 0.1inch Diamond part: Full drill Pattern: Home Letter Cavas
      |Size: 15.8×11.8 inch/ 40*30cm Pasting Area: Full Drill Diamond Shape: Round Use: Entertainment,Gifts,Decoration
      |Note:Normally the diamonds is add 30%, if the diamonds is not enough,pls contact us we will send the
      |diamonds for you Product Description 5D DIY Diamond Painting is the new popular product Can be used
      |in the Bedroom, Dinning Room, Bathroom, Washroom, Kitchen, Study, Home, Office Hotel, Restaurant and
      |Bar,shining in the light , is currently most popular DIY decorations,Wealth and Good Fortune Diamond
      |Painting Embroidery Home Decoration.very shining and bling.Make your house looks more pretty.
      |DIY Diamond painting instruction steps 1.Take out the diamond painting kits 2.Please only need to lift
      |a small part of the release paper, in order to avoid other regional sticky dust affect. 3.Find the
      |corresponding diamond bag according to the numbers or letters, put the diamonds into the tray and shake.
      |4.Use the penpoint to adsorb the painting muds and diamond, press it to the canvas's corresponding
      |position. 5.Press diamonds on the canvas with book or hand to make them more fixed. then 5d diamond
      |paintings is done. Package Included 1 x Canvas 1 x set Resin Diamonds 1 x Diamond painting pen 1 x
      |""".stripMargin

  val path = "/home/shutty/code/nixiesearch-hf"

  @Param(Array("4", "8", "16", "32", "64", "128", "256"))
  var words: String = _

  @Param(
    Array(
      //"all-MiniLM-L6-v2-onnx"
      //"all-mpnet-base-v2",
      "e5-small-v2-onnx",
      "e5-base-v2-onnx",
      "e5-large-v2-onnx"
    )
  )
  var model: String = _

  @Param(Array("true", "false"))
  var gpu: String = _

  @Param(Array("QInt8", "QUInt8", "Float16", "Float32"))
  var tpe: String = _

  @Param(Array("0", "1", "2", "99"))
  var opt: String = _

  var encoder: OnnxBiEncoder = _
  var evalString: String = _
  var gpuFlag: Boolean = _
  var quantFlag: Boolean = _

  @Setup
  def setup = {
    gpuFlag = gpu.toBoolean
    val modelFile =
      if (opt == "0") "model.onnx" else s"model_opt${opt}_${tpe}.onnx"
    val session = OnnxSession.load(
      model = new FileInputStream(new File(s"$path/$model/$modelFile")),
      dic = new FileInputStream(new File(s"$path/$model/tokenizer.json")),
      dim = model match {
        case "e5-small-v2-onnx" => 384
        case "e5-base-v2-onnx"  => 768
        case "e5-large-v2-onnx" => 1024
      },
      gpu = gpuFlag
    )
    encoder = OnnxBiEncoder(session)
    evalString = TEXT.split(Array(' ', '.')).take(words.toInt).mkString(" ")
  }

  @Benchmark
  def latency() = {
    encoder.embed(Array(evalString))
  }

}
