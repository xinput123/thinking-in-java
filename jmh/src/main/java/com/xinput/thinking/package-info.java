/**
 * Java 的基准测试需要注意的几个点:
 * <p>
 * 测试前需要预热
 * 防止无用代码进入测试方法中
 * 并发测试
 * 测试结果呈现
 * <p>
 * JMH 的使用场景
 * 1、定量分析某个热点函数的优化效率
 * 2、想定量地知道某个函数需要执行多长时间
 * 3、第一笔一个函数的多个实现方式
 * <p>
 * 相关注解
 *
 * @BenchmarkMode 注解参数
 * Throughput  每段时间执行的次数，一般是秒
 * AverageTime	平均时间，每次操作的平均耗时
 * SampleTime	在测试中，随机进行采样执行的时间
 * SingleShotTime	在每次执行中计算耗时
 * All	所有模式
 * <p>
 * @Warmup 预热
 * iterations = 3就是指预热轮数
 * <p>
 * @Measurement 正式度量计算的轮数
 * iterations 进行测试的轮次
 * time 每轮进行的时长
 * timeUnit时长单位
 * <p>
 * @Threads 每个线程中的测试线程
 * <p>
 * @fork 进行 fork 的次数。
 * value = 3，则 JMH 会 fork 出3个进程来进行测试。
 * <p>
 * @OutputTimeUnit 基准测试结果的时间类型。一般选择秒、毫秒、微秒。
 * <p>
 * @Benchmark 方法级注解，表示该方法是需要进行 benchmark 的对象，用法和 JUnit 的 @Test 类似。
 * <p>
 * @Param 属性级注解，@Param 可以用来指定某项参数的多种情况。特别适合用来测试一个函数在不同的参数输入的情况下的性能。
 * <p>
 * @Setup 方法级注解，这个注解的作用就是我们需要在测试之前进行一些准备工作 ，比如对一些数据的初始化之类的。
 * <p>
 * @TearDown 方法级注解，这个注解的作用就是我们需要在测试之后进行一些结束工作 ，比如关闭线程池，数据库连接等的，主要用于资源的回收等。
 * <p>
 * @State 当使用@Setup参数的时候，必须在类上加这个参数，不然会提示无法运行。
 * State 用于声明某个类是一个“状态”，然后接受一个 Scope 参数用来表示该状态的共享范围。因为很多 benchmark 会需要一些表示状态的类，JMH 允许你把这些类以依赖注入的方式注入到 benchmark 函数里。Scope 主要分为三种。
 * Thread: 该状态为每个线程独享。
 * Group: 该状态为同一个组里面所有线程共享。
 * Benchmark: 该状态在所有线程间共享。
 */
package com.xinput.thinking;