package org.xinput.thinking.common.util;

import org.slf4j.Logger;

/**
 * TODO
 *
 * @author yuan.lai
 * @since
 */
public class LogDemo {

  private static final Logger logger = Logs.get();

  public static void main(String[] args) {
    for (int i = 0; i < 100; i++) {
      logger.debug("debug. " + i);
      logger.warn("warn. " + i);
      logger.info("info. " + i);
      logger.error("error. " + i);
    }
  }
}
