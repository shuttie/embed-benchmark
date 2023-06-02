# Inference benchmark suite for embedding models

Created as a part of article series about semantic search embedding models.

## Running the suite

You need to have SBT installed to build and run the suite.

The main benchmark code is in `EncoderBenchmark`. You may need to change
the `path` variable to point to a directory with ONNX encoded models.

To run the suite, do the following command:
```shell
sbt jmh:run
```

To run a specific model:
```shell
sbt "jmh:run -f 1 -p model=e5-small-v2 -p words=256"
```

## CPU results

For AMD Ryzen7 2700 with 8 physical cores:

```
[info] Benchmark                           (model)  (words)  Mode  Cnt    Score    Error  Units
[info] EncoderBenchmark.latency   all-MiniLM-L6-v2        4  avgt   15    3.542 ±  0.284  ms/op
[info] EncoderBenchmark.latency   all-MiniLM-L6-v2        8  avgt   15    3.874 ±  0.307  ms/op
[info] EncoderBenchmark.latency   all-MiniLM-L6-v2       16  avgt   15    5.095 ±  0.281  ms/op
[info] EncoderBenchmark.latency   all-MiniLM-L6-v2       32  avgt   15    9.510 ±  0.454  ms/op
[info] EncoderBenchmark.latency   all-MiniLM-L6-v2       64  avgt   15   14.148 ±  0.816  ms/op
[info] EncoderBenchmark.latency   all-MiniLM-L6-v2      128  avgt   15   24.393 ±  0.994  ms/op
[info] EncoderBenchmark.latency   all-MiniLM-L6-v2      256  avgt   15   50.041 ±  1.108  ms/op
[info] EncoderBenchmark.latency  all-mpnet-base-v2        4  avgt   15   17.623 ±  0.636  ms/op
[info] EncoderBenchmark.latency  all-mpnet-base-v2        8  avgt   15   19.373 ±  0.827  ms/op
[info] EncoderBenchmark.latency  all-mpnet-base-v2       16  avgt   15   26.519 ±  2.227  ms/op
[info] EncoderBenchmark.latency  all-mpnet-base-v2       32  avgt   15   47.147 ±  7.444  ms/op
[info] EncoderBenchmark.latency  all-mpnet-base-v2       64  avgt   15   70.433 ±  7.199  ms/op
[info] EncoderBenchmark.latency  all-mpnet-base-v2      128  avgt   15  115.497 ±  1.929  ms/op
[info] EncoderBenchmark.latency  all-mpnet-base-v2      256  avgt   15  264.828 ±  9.909  ms/op
[info] EncoderBenchmark.latency        e5-small-v2        4  avgt   15    6.782 ±  1.066  ms/op
[info] EncoderBenchmark.latency        e5-small-v2        8  avgt   15    7.161 ±  0.211  ms/op
[info] EncoderBenchmark.latency        e5-small-v2       16  avgt   15    9.869 ±  0.636  ms/op
[info] EncoderBenchmark.latency        e5-small-v2       32  avgt   15   18.267 ±  0.622  ms/op
[info] EncoderBenchmark.latency        e5-small-v2       64  avgt   15   25.395 ±  0.414  ms/op
[info] EncoderBenchmark.latency        e5-small-v2      128  avgt   15   46.265 ±  0.800  ms/op
[info] EncoderBenchmark.latency        e5-small-v2      256  avgt   15   97.547 ±  2.253  ms/op
[info] EncoderBenchmark.latency         e5-base-v2        4  avgt   15   17.341 ±  0.753  ms/op
[info] EncoderBenchmark.latency         e5-base-v2        8  avgt   15   18.860 ±  0.473  ms/op
[info] EncoderBenchmark.latency         e5-base-v2       16  avgt   15   26.774 ±  2.681  ms/op
[info] EncoderBenchmark.latency         e5-base-v2       32  avgt   15   47.014 ±  7.148  ms/op
[info] EncoderBenchmark.latency         e5-base-v2       64  avgt   15   72.257 ±  8.049  ms/op
[info] EncoderBenchmark.latency         e5-base-v2      128  avgt   15  114.695 ±  1.655  ms/op
[info] EncoderBenchmark.latency         e5-base-v2      256  avgt   15  255.714 ±  8.537  ms/op
[info] EncoderBenchmark.latency        e5-large-v2        4  avgt   15   55.901 ±  1.081  ms/op
[info] EncoderBenchmark.latency        e5-large-v2        8  avgt   15   63.532 ±  3.418  ms/op
[info] EncoderBenchmark.latency        e5-large-v2       16  avgt   15   81.554 ±  2.683  ms/op
[info] EncoderBenchmark.latency        e5-large-v2       32  avgt   15  141.388 ±  2.329  ms/op
[info] EncoderBenchmark.latency        e5-large-v2       64  avgt   15  222.953 ±  5.689  ms/op
[info] EncoderBenchmark.latency        e5-large-v2      128  avgt   15  390.867 ±  8.989  ms/op
[info] EncoderBenchmark.latency        e5-large-v2      256  avgt   15  873.997 ± 25.694  ms/op
```

## GPU results

For Nvidia RTX3060Ti:

```
[info] Benchmark                           (model)  (words)  Mode  Cnt   Score   Error  Units
[info] EncoderBenchmark.latency   all-MiniLM-L6-v2        4  avgt    5   1.237 ± 0.160  ms/op
[info] EncoderBenchmark.latency   all-MiniLM-L6-v2        8  avgt    5   1.136 ± 0.094  ms/op
[info] EncoderBenchmark.latency   all-MiniLM-L6-v2       16  avgt    5   1.254 ± 0.062  ms/op
[info] EncoderBenchmark.latency   all-MiniLM-L6-v2       32  avgt    5   1.268 ± 0.053  ms/op
[info] EncoderBenchmark.latency   all-MiniLM-L6-v2       64  avgt    5   1.293 ± 0.071  ms/op
[info] EncoderBenchmark.latency   all-MiniLM-L6-v2      128  avgt    5   1.611 ± 0.048  ms/op
[info] EncoderBenchmark.latency   all-MiniLM-L6-v2      256  avgt    5   2.620 ± 0.197  ms/op
[info] EncoderBenchmark.latency  all-mpnet-base-v2        4  avgt    5   2.389 ± 0.034  ms/op
[info] EncoderBenchmark.latency  all-mpnet-base-v2        8  avgt    5   2.435 ± 0.059  ms/op
[info] EncoderBenchmark.latency  all-mpnet-base-v2       16  avgt    5   2.675 ± 0.057  ms/op
[info] EncoderBenchmark.latency  all-mpnet-base-v2       32  avgt    5   2.926 ± 0.078  ms/op
[info] EncoderBenchmark.latency  all-mpnet-base-v2       64  avgt    5   3.437 ± 0.069  ms/op
[info] EncoderBenchmark.latency  all-mpnet-base-v2      128  avgt    5   4.817 ± 0.125  ms/op
[info] EncoderBenchmark.latency  all-mpnet-base-v2      256  avgt    5   9.410 ± 0.115  ms/op
[info] EncoderBenchmark.latency        e5-small-v2        4  avgt    5   2.130 ± 0.513  ms/op
[info] EncoderBenchmark.latency        e5-small-v2        8  avgt    5   2.037 ± 0.260  ms/op
[info] EncoderBenchmark.latency        e5-small-v2       16  avgt    5   2.163 ± 0.384  ms/op
[info] EncoderBenchmark.latency        e5-small-v2       32  avgt    5   2.319 ± 0.378  ms/op
[info] EncoderBenchmark.latency        e5-small-v2       64  avgt    5   2.292 ± 0.087  ms/op
[info] EncoderBenchmark.latency        e5-small-v2      128  avgt    5   2.828 ± 0.471  ms/op
[info] EncoderBenchmark.latency        e5-small-v2      256  avgt    5   4.663 ± 0.157  ms/op
[info] EncoderBenchmark.latency         e5-base-v2        4  avgt    5   2.392 ± 0.090  ms/op
[info] EncoderBenchmark.latency         e5-base-v2        8  avgt    5   2.427 ± 0.079  ms/op
[info] EncoderBenchmark.latency         e5-base-v2       16  avgt    5   2.569 ± 0.068  ms/op
[info] EncoderBenchmark.latency         e5-base-v2       32  avgt    5   2.826 ± 0.090  ms/op
[info] EncoderBenchmark.latency         e5-base-v2       64  avgt    5   3.414 ± 0.206  ms/op
[info] EncoderBenchmark.latency         e5-base-v2      128  avgt    5   4.916 ± 0.090  ms/op
[info] EncoderBenchmark.latency         e5-base-v2      256  avgt    5   9.050 ± 0.321  ms/op
[info] EncoderBenchmark.latency        e5-large-v2        4  avgt    5   5.594 ± 0.229  ms/op
[info] EncoderBenchmark.latency        e5-large-v2        8  avgt    5   5.669 ± 0.158  ms/op
[info] EncoderBenchmark.latency        e5-large-v2       16  avgt    5   6.232 ± 0.213  ms/op
[info] EncoderBenchmark.latency        e5-large-v2       32  avgt    5   6.398 ± 0.197  ms/op
[info] EncoderBenchmark.latency        e5-large-v2       64  avgt    5   8.579 ± 0.046  ms/op
[info] EncoderBenchmark.latency        e5-large-v2      128  avgt    5  14.359 ± 0.299  ms/op
[info] EncoderBenchmark.latency        e5-large-v2      256  avgt    5  29.497 ± 1.061  ms/op
```

### License

Apache 2.0