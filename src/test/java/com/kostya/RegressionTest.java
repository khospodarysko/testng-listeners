package com.kostya;

import org.testng.annotations.Test;

import java.util.concurrent.ThreadLocalRandom;

public class RegressionTest {
    @Test
    public void a() throws InterruptedException {
        int seconds = ThreadLocalRandom.current().nextInt(10);
        System.out.println(String.format("Thread %s waits %ds", Thread.currentThread().getId(), seconds));
        Thread.sleep(seconds * 1000);
    }

    @Test
    public void b() throws InterruptedException {
        int seconds = ThreadLocalRandom.current().nextInt(10);
        System.out.println(String.format("Thread %s waits %ds", Thread.currentThread().getId(), seconds));
        Thread.sleep(seconds * 1000);
    }
}
