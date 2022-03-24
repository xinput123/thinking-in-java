package com.xinput.jvm.ch2;

/**
 * 创建线程导致内存溢出异常
 * VM Args: -Xss128k
 */
public class JavaVMStackSOF {

  private int stackLength = 1;

  public void stackLeak() {
    stackLength++;
    stackLeak();
  }

  public static void main(String[] args) {
    JavaVMStackSOF oom = new JavaVMStackSOF();
    try {
      oom.stackLeak();
    } catch (Throwable e) {
      System.out.println("stack length: " + oom.stackLength);
      throw e;
    }
  }
}
