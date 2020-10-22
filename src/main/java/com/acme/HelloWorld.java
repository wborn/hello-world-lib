package com.acme;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloWorld {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloWorld.class);

    public static void print() {
        System.out.println("Hello World!");
    }

    public static void log() {
        LOGGER.info("Hello World!");
    }

}
