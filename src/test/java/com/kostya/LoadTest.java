package com.kostya;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.concurrent.ThreadLocalRandom;

@Listeners(AnnotationTransformer.class)
public class LoadTest {
    @Test
    public void loadTest() throws InterruptedException {
        int seconds = ThreadLocalRandom.current().nextInt(10) * 1000;
        System.out.println(String.format("Thread %s waits %dms", Thread.currentThread().getId(), seconds));
        Thread.sleep(seconds);
    }
}
