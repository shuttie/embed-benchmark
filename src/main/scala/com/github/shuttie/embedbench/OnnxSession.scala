package com.github.shuttie.embedbench

import ai.djl.huggingface.tokenizers.HuggingFaceTokenizer
import ai.djl.modality.nlp.DefaultVocabulary
import ai.djl.modality.nlp.bert.BertFullTokenizer
import ai.onnxruntime.OrtSession.SessionOptions
import ai.onnxruntime.OrtSession.SessionOptions.OptLevel
import ai.onnxruntime.{OrtEnvironment, OrtLoggingLevel, OrtSession}
import org.apache.commons.io.{FileUtils, IOUtils}

import scala.jdk.CollectionConverters._
import java.io.InputStream
import java.nio.charset.StandardCharsets

case class OnnxSession(
    env: OrtEnvironment,
    session: OrtSession,
    tokenizer: HuggingFaceTokenizer,
    dim: Int
) {
  def close(): Unit = {
    session.close()
    env.close()
  }
}

object OnnxSession {

  def load(
      model: InputStream,
      dic: InputStream,
      dim: Int,
      gpu: Boolean
  ): OnnxSession = {
    val tokenizer = HuggingFaceTokenizer.newInstance(
      dic,
      Map("padding" -> "true", "truncation" -> "true").asJava
    )
    val env = OrtEnvironment.getEnvironment("sbert")
    val opts = new SessionOptions()
    //opts.setIntraOpNumThreads(Runtime.getRuntime.availableProcessors())
    opts.setOptimizationLevel(OptLevel.ALL_OPT)
    //opts.setIntraOpNumThreads(1)
    //opts.setInterOpNumThreads(1)
    if (gpu) opts.addCUDA()
    val modelBytes = IOUtils.toByteArray(model)
    val session = env.createSession(modelBytes, opts)
    OnnxSession(env, session, tokenizer, dim)
  }

}
