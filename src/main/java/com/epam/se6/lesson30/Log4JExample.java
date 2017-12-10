package com.epam.se6.lesson30;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4JExample {

    private final static Logger LOG = LogManager.getLogger(Log4JExample.class);

    public static void main(String[] args) {
        LOG.error("Main started", new Exception());
        LOG.fatal("Main started: fatal");
    }
}
