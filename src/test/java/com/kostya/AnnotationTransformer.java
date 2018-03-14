package com.kostya;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class AnnotationTransformer implements IAnnotationTransformer {
    private static final Logger logger = LoggerFactory.getLogger(AnnotationTransformer.class);

    @Override
    public void transform(ITestAnnotation annotation, Class aClass, Constructor constructor, Method method) {
        logger.info(getClass().getName());

        String toRunTest = System.getProperty("test");
        String processingTest = method.getDeclaringClass().getName() + "#" + method.getName();

        if (toRunTest != null) {
            if (!toRunTest.equals(processingTest)) {
                return;
            }
        }

        int threads = Integer.valueOf(System.getProperty("threads", "1"));
        int runs = Integer.valueOf(System.getProperty("runs", "1"));
        
        annotation.setThreadPoolSize(threads);
        annotation.setInvocationCount(runs);
        
        logger.info("Run method {}#{} with load: threads: {}, runs: {}",
            method.getDeclaringClass().getSimpleName(), 
            method.getName(), 
            threads, 
            runs
        );
    }
}
