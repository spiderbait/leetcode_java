package test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyLogger {

    private static final Logger loggerAlpha = LoggerFactory.getLogger(MyLogger.class);
//    private static final Logger loggerBeta = LoggerFactory.getLogger(MyLogger.class);
    public void test() {
        System.out.println("method test() called.");
        loggerAlpha.debug("I am logger alpha.");
//        loggerBeta.debug("I am logger beta.");
    }

    public static void main(String[] args) {
        MyLogger myLogger = new MyLogger();

        myLogger.test();
    }

}
