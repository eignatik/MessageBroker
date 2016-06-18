package com.deveignatik.MessageBroker;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * 1:48 PM.
 */
public class Log {
    public static final Logger log = LogManager.getLogger("MessageBroker");
    public static void loggerTest(){
        log.error("log...");
    }
}
