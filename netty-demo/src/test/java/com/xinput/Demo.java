package com.xinput;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * TODO
 *
 * @author yuan.lai
 * @since
 */
public class Demo {
  public static void main(String[] args) {
    int tagNum = 10;
    List<String> tagClouds = new ArrayList<String>(tagNum);
    for (int i = 0; i < tagNum; i++) {
      tagClouds.add(String.valueOf(i));
    }

    for (String s : tagClouds) {
      System.out.println(s);
    }

    Collections.shuffle(tagClouds);
    for (String s : tagClouds) {
      System.out.println(s);
    }
  }
}
