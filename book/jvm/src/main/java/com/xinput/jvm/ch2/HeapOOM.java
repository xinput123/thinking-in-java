package com.xinput.jvm.ch2;

import java.util.ArrayList;
import java.util.List;

/**
 * Java 堆栈溢出 示例
 * 限制Java堆的大小为20MB，不可扩展（将堆的最小值-Xms参数与最大值-Xmx参数设置为一样即可避免堆自动扩展
 * 通过参数 -XX：+HeapDump OnOutOfMemoryError 可以让虚拟机在出现内存溢出异常时Dump出当前的内存堆转储快照
 * <p>
 * VM Args: -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 */
public class HeapOOM {

  static class OOMObject {

  }

  public static void main(String[] args) {
    List<OOMObject> lists = new ArrayList();
    while (true) {
      lists.add(new OOMObject());
    }
  }
}
