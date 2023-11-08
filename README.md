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

## Quantization

### QInt8, no AVX-VNNI

```
[info] Benchmark                 (gpu)           (model)  (quantized)  (words)  Mode  Cnt    Score    Error  Units
[info] EncoderBenchmark.latency  false  e5-small-v2-onnx         true        4  avgt   30    5.056 ±  0.328  ms/op
[info] EncoderBenchmark.latency  false  e5-small-v2-onnx         true        8  avgt   30    6.188 ±  0.312  ms/op
[info] EncoderBenchmark.latency  false  e5-small-v2-onnx         true       16  avgt   30    9.475 ±  0.291  ms/op
[info] EncoderBenchmark.latency  false  e5-small-v2-onnx         true       32  avgt   30   18.114 ±  0.729  ms/op
[info] EncoderBenchmark.latency  false  e5-small-v2-onnx         true       64  avgt   30   27.633 ±  1.524  ms/op
[info] EncoderBenchmark.latency  false  e5-small-v2-onnx         true      128  avgt   30   49.595 ±  1.263  ms/op
[info] EncoderBenchmark.latency  false  e5-small-v2-onnx         true      256  avgt   30   96.119 ±  2.950  ms/op
[info] EncoderBenchmark.latency  false  e5-small-v2-onnx        false        4  avgt   30    6.774 ±  0.299  ms/op
[info] EncoderBenchmark.latency  false  e5-small-v2-onnx        false        8  avgt   30    7.699 ±  0.304  ms/op
[info] EncoderBenchmark.latency  false  e5-small-v2-onnx        false       16  avgt   30   10.854 ±  0.627  ms/op
[info] EncoderBenchmark.latency  false  e5-small-v2-onnx        false       32  avgt   30   20.046 ±  0.795  ms/op
[info] EncoderBenchmark.latency  false  e5-small-v2-onnx        false       64  avgt   30   29.415 ±  1.626  ms/op
[info] EncoderBenchmark.latency  false  e5-small-v2-onnx        false      128  avgt   30   51.847 ±  1.471  ms/op
[info] EncoderBenchmark.latency  false  e5-small-v2-onnx        false      256  avgt   30  104.012 ±  5.958  ms/op
[info] EncoderBenchmark.latency  false   e5-base-v2-onnx         true        4  avgt   30   10.101 ±  0.339  ms/op
[info] EncoderBenchmark.latency  false   e5-base-v2-onnx         true        8  avgt   30   12.989 ±  0.462  ms/op
[info] EncoderBenchmark.latency  false   e5-base-v2-onnx         true       16  avgt   30   20.710 ±  0.729  ms/op
[info] EncoderBenchmark.latency  false   e5-base-v2-onnx         true       32  avgt   30   41.481 ±  1.322  ms/op
[info] EncoderBenchmark.latency  false   e5-base-v2-onnx         true       64  avgt   30   68.744 ±  2.724  ms/op
[info] EncoderBenchmark.latency  false   e5-base-v2-onnx         true      128  avgt   30  108.107 ±  3.234  ms/op
[info] EncoderBenchmark.latency  false   e5-base-v2-onnx         true      256  avgt   30  242.078 ±  7.595  ms/op
[info] EncoderBenchmark.latency  false   e5-base-v2-onnx        false        4  avgt   30   18.318 ±  0.627  ms/op
[info] EncoderBenchmark.latency  false   e5-base-v2-onnx        false        8  avgt   30   20.901 ±  1.241  ms/op
[info] EncoderBenchmark.latency  false   e5-base-v2-onnx        false       16  avgt   30   27.631 ±  1.168  ms/op
[info] EncoderBenchmark.latency  false   e5-base-v2-onnx        false       32  avgt   30   47.793 ±  1.643  ms/op
[info] EncoderBenchmark.latency  false   e5-base-v2-onnx        false       64  avgt   30   76.249 ±  4.037  ms/op
[info] EncoderBenchmark.latency  false   e5-base-v2-onnx        false      128  avgt   30  120.735 ±  4.239  ms/op
[info] EncoderBenchmark.latency  false   e5-base-v2-onnx        false      256  avgt   30  255.839 ±  6.584  ms/op
[info] EncoderBenchmark.latency  false  e5-large-v2-onnx         true        4  avgt   30   29.147 ±  0.984  ms/op
[info] EncoderBenchmark.latency  false  e5-large-v2-onnx         true        8  avgt   30   39.321 ±  1.286  ms/op
[info] EncoderBenchmark.latency  false  e5-large-v2-onnx         true       16  avgt   30   64.002 ±  2.810  ms/op
[info] EncoderBenchmark.latency  false  e5-large-v2-onnx         true       32  avgt   30  131.581 ±  4.094  ms/op
[info] EncoderBenchmark.latency  false  e5-large-v2-onnx         true       64  avgt   30  201.466 ± 12.138  ms/op
[info] EncoderBenchmark.latency  false  e5-large-v2-onnx         true      128  avgt   30  353.541 ± 11.863  ms/op
[info] EncoderBenchmark.latency  false  e5-large-v2-onnx         true      256  avgt   30  775.755 ± 15.869  ms/op
[info] EncoderBenchmark.latency  false  e5-large-v2-onnx        false        4  avgt   30   58.246 ±  1.295  ms/op
[info] EncoderBenchmark.latency  false  e5-large-v2-onnx        false        8  avgt   30   65.960 ±  2.660  ms/op
[info] EncoderBenchmark.latency  false  e5-large-v2-onnx        false       16  avgt   30   86.411 ±  2.908  ms/op
[info] EncoderBenchmark.latency  false  e5-large-v2-onnx        false       32  avgt   30  150.251 ±  2.868  ms/op
[info] EncoderBenchmark.latency  false  e5-large-v2-onnx        false       64  avgt   30  227.753 ±  5.515  ms/op
[info] EncoderBenchmark.latency  false  e5-large-v2-onnx        false      128  avgt   30  398.923 ± 11.870  ms/op
[info] EncoderBenchmark.latency  false  e5-large-v2-onnx        false      256  avgt   30  871.132 ± 20.903  ms/op
```

### QInt8, with AVX-VNNI

```
[info] Benchmark                 (gpu)           (model)  (quantized)  (words)  Mode  Cnt    Score    Error  Units
[info] EncoderBenchmark.latency  false  e5-small-v2-onnx         true        4  avgt   30    1.726 ±  0.050  ms/op
[info] EncoderBenchmark.latency  false  e5-small-v2-onnx         true        8  avgt   30    2.051 ±  0.057  ms/op
[info] EncoderBenchmark.latency  false  e5-small-v2-onnx         true       16  avgt   30    2.863 ±  0.094  ms/op
[info] EncoderBenchmark.latency  false  e5-small-v2-onnx         true       32  avgt   30    5.102 ±  0.158  ms/op
[info] EncoderBenchmark.latency  false  e5-small-v2-onnx         true       64  avgt   30    7.426 ±  0.359  ms/op
[info] EncoderBenchmark.latency  false  e5-small-v2-onnx         true      128  avgt   30   13.004 ±  0.619  ms/op
[info] EncoderBenchmark.latency  false  e5-small-v2-onnx         true      256  avgt   30   23.801 ±  0.194  ms/op
[info] EncoderBenchmark.latency  false  e5-small-v2-onnx        false        4  avgt   30    3.167 ±  0.387  ms/op
[info] EncoderBenchmark.latency  false  e5-small-v2-onnx        false        8  avgt   30    2.894 ±  0.245  ms/op
[info] EncoderBenchmark.latency  false  e5-small-v2-onnx        false       16  avgt   30    4.182 ±  0.229  ms/op
[info] EncoderBenchmark.latency  false  e5-small-v2-onnx        false       32  avgt   30    7.297 ±  0.119  ms/op
[info] EncoderBenchmark.latency  false  e5-small-v2-onnx        false       64  avgt   30   12.136 ±  1.416  ms/op
[info] EncoderBenchmark.latency  false  e5-small-v2-onnx        false      128  avgt   30   22.553 ±  2.545  ms/op
[info] EncoderBenchmark.latency  false  e5-small-v2-onnx        false      256  avgt   30   41.167 ±  3.994  ms/op
[info] EncoderBenchmark.latency  false   e5-base-v2-onnx         true        4  avgt   30    3.655 ±  0.531  ms/op
[info] EncoderBenchmark.latency  false   e5-base-v2-onnx         true        8  avgt   30    4.202 ±  0.462  ms/op
[info] EncoderBenchmark.latency  false   e5-base-v2-onnx         true       16  avgt   30    5.572 ±  0.425  ms/op
[info] EncoderBenchmark.latency  false   e5-base-v2-onnx         true       32  avgt   30    8.767 ±  0.079  ms/op
[info] EncoderBenchmark.latency  false   e5-base-v2-onnx         true       64  avgt   30   14.252 ±  1.272  ms/op
[info] EncoderBenchmark.latency  false   e5-base-v2-onnx         true      128  avgt   30   23.057 ±  2.247  ms/op
[info] EncoderBenchmark.latency  false   e5-base-v2-onnx         true      256  avgt   30   52.650 ±  4.567  ms/op
[info] EncoderBenchmark.latency  false   e5-base-v2-onnx        false        4  avgt   30   12.693 ±  1.863  ms/op
[info] EncoderBenchmark.latency  false   e5-base-v2-onnx        false        8  avgt   30   12.746 ±  1.826  ms/op
[info] EncoderBenchmark.latency  false   e5-base-v2-onnx        false       16  avgt   30   14.428 ±  0.092  ms/op
[info] EncoderBenchmark.latency  false   e5-base-v2-onnx        false       32  avgt   30   23.002 ±  1.478  ms/op
[info] EncoderBenchmark.latency  false   e5-base-v2-onnx        false       64  avgt   30   37.776 ±  5.601  ms/op
[info] EncoderBenchmark.latency  false   e5-base-v2-onnx        false      128  avgt   30   53.990 ±  1.942  ms/op
[info] EncoderBenchmark.latency  false   e5-base-v2-onnx        false      256  avgt   30  150.256 ± 23.328  ms/op
[info] EncoderBenchmark.latency  false  e5-large-v2-onnx         true        4  avgt   30   14.164 ±  2.431  ms/op
[info] EncoderBenchmark.latency  false  e5-large-v2-onnx         true        8  avgt   30   15.473 ±  2.058  ms/op
[info] EncoderBenchmark.latency  false  e5-large-v2-onnx         true       16  avgt   30   18.127 ±  2.286  ms/op
[info] EncoderBenchmark.latency  false  e5-large-v2-onnx         true       32  avgt   30   26.344 ±  2.518  ms/op
[info] EncoderBenchmark.latency  false  e5-large-v2-onnx         true       64  avgt   30   32.557 ±  1.190  ms/op
[info] EncoderBenchmark.latency  false  e5-large-v2-onnx         true      128  avgt   30   62.558 ±  8.472  ms/op
[info] EncoderBenchmark.latency  false  e5-large-v2-onnx         true      256  avgt   30  126.842 ± 11.528  ms/op
[info] EncoderBenchmark.latency  false  e5-large-v2-onnx        false        4  avgt   30   39.614 ±  3.823  ms/op
[info] EncoderBenchmark.latency  false  e5-large-v2-onnx        false        8  avgt   30   43.939 ±  5.708  ms/op
[info] EncoderBenchmark.latency  false  e5-large-v2-onnx        false       16  avgt   30   52.877 ±  6.923  ms/op
[info] EncoderBenchmark.latency  false  e5-large-v2-onnx        false       32  avgt   30   90.087 ± 14.461  ms/op
[info] EncoderBenchmark.latency  false  e5-large-v2-onnx        false       64  avgt   30  117.197 ± 17.545  ms/op
[info] EncoderBenchmark.latency  false  e5-large-v2-onnx        false      128  avgt   30  176.686 ±  4.437  ms/op
[info] EncoderBenchmark.latency  false  e5-large-v2-onnx        false      256  avgt   30  419.281 ± 58.563  ms/op
```

### License

Apache 2.0