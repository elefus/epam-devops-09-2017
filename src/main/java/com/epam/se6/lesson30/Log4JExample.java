package com.epam.se6.lesson30;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4JExample {

    private final static Logger LOG = LogManager.getLogger(Log4JExample.class);

    public static void main(String[] args) {
        LOG.fatal("Fatal message");
        LOG.error("Error message with exception", new IllegalArgumentException("No params"));
        LOG.warn("Warning message");
        LOG.info("Info message");
        LOG.debug("Debug message");
        LOG.trace("Trace message");
    }
}
