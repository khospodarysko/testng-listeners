package com.kostya;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.util.concurrent.ThreadLocalRandom;

public class RegressionTest {
    private static final Logger logger = LoggerFactory.getLogger(RegressionTest.class);

    @Test
    public void a() throws InterruptedException {
        int seconds = ThreadLocalRandom.current().nextInt(10);
        logger.info("Thread {} waits {}s", Thread.currentThread().getId(), seconds);
        Thread.sleep(seconds * 1000);
    }

    @Test
    public void b() throws InterruptedException {
        int seconds = ThreadLocalRandom.current().nextInt(10);
        logger.info("Thread {} waits {}s", Thread.currentThread().getId(), seconds);
        Thread.sleep(seconds * 1000);
    }
}
