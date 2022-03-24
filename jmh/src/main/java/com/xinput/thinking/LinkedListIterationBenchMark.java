package com.xinput.thinking;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Threads;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author xinput
 * @since
 */
@State(Scope.Benchmark)
@OutputTimeUnit(TimeUnit.SECONDS)
@Threads(Threads.MAX)
public class LinkedListIterationBenchMark {

  private static final int SIZE = 10000;

  private List<String> list = new LinkedList();

  @Setup
  public void setUp() {
    for (int i = 0; i < SIZE; i++) {
      list.add(String.valueOf(i));
    }
  }

  @Benchmark
  @BenchmarkMode(Mode.Throughput)
  public void forIndexIterate() {
    for (int i = 0; i < list.size(); i++) {
      list.get(i);
      System.out.print("");
    }
  }

  @Benchmark
  @BenchmarkMode(Mode.Throughput)
  public void forEachIterate() {
    for (String s : list) {
      System.out.print("");
    }
  }

  public static void main(String[] args) throws RunnerException {
    Options options = new OptionsBuilder()
        .include(LinkedListIterationBenchMark.class.getSimpleName())
        //  forks(3)指的是做3轮测试，
        // 因为一次测试无法有效的代表结果，
        // 所以通过3轮测试较为全面的测试，
        // 而每一轮都是先预热，再正式计量。
        .forks(3)
        // 预热 2 轮
        .warmupIterations(2)
        // 代表正式计量测试做2轮，
        // 而每次都是先执行完预热再执行正式计量，
        // 内容都是调用标注了@Benchmark的代码。
        .measurementIterations(2)
        .output("./Benchmark.log")
        .build();

    new Runner(options).run();
  }
}
