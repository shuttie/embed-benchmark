package com.github.shuttie.embedbench

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
    tokenizer: BertFullTokenizer,
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
    val tokens = IOUtils.toString(dic, StandardCharsets.UTF_8).split('\n')
    val vocab = DefaultVocabulary.builder().add(tokens.toList.asJava).build()
    val tokenizer = new BertFullTokenizer(vocab, true)
    val env = OrtEnvironment.getEnvironment("sbert")
    val opts = new SessionOptions()
    opts.setIntraOpNumThreads(Runtime.getRuntime.availableProcessors())
    opts.setOptimizationLevel(OptLevel.ALL_OPT)
    if (gpu) opts.addCUDA()
    val modelBytes = IOUtils.toByteArray(model)
    val session = env.createSession(modelBytes, opts)
    OnnxSession(env, session, tokenizer, dim)
  }

}
