package com.xinput.jvm.ch2;

import java.util.ArrayList;
import java.util.List;

/**
 * 运行时常量池溢出
 * VM Args: -XX:PermSize=10M -XX:MaxPermSize=10M
 */
public class RuntimeConstantPoolOOM {
  public static void main(String[] args) {
    // 使用 List 保持着常量池引用，避免 Full GC 回收常量池行为
    List<String> lists = new ArrayList();
    // 10MB 的 PermSize 在 interger 范围内足够产生 OOM 了
    int i = 0;
    while (true) {
      lists.add(String.valueOf(i).intern());
    }
  }
}
