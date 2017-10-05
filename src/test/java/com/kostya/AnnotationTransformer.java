package com.kostya;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class AnnotationTransformer implements IAnnotationTransformer {
    @Override
    public void transform(ITestAnnotation annotation, Class aClass, Constructor constructor, Method method) {
        System.out.println(getClass().getName());
        
        int threads = Integer.valueOf(System.getProperty("threads"));
        int runs = Integer.valueOf(System.getProperty("runs"));
        
        annotation.setThreadPoolSize(threads);
        annotation.setInvocationCount(runs);
        
        System.out.println(String.format("Run method %s#%s with load: threads: %d, runs: %d", 
            aClass.getSimpleName(), method.getName(), threads, runs));
    }
}
