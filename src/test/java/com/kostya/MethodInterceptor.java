package com.kostya;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import java.util.Comparator;
import java.util.List;

public class MethodInterceptor implements IMethodInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(MethodInterceptor.class);

    private static final Comparator<IMethodInstance> FULL_NAME = (m1, m2) -> {
        String s1 = m1.getMethod().getRealClass().getCanonicalName() + m1.getMethod().getMethodName();
        String s2 = m2.getMethod().getRealClass().getCanonicalName() + m2.getMethod().getMethodName();
        return s1.compareTo(s2);
    };

    private static final Comparator<IMethodInstance> TEST_NAME = (m1, m2) -> {
        String s1 = m1.getMethod().getMethodName();
        String s2 = m2.getMethod().getMethodName();
        return s1.compareTo(s2);
    };
    
    @Override
    public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext iTestContext) {
        logger.info(getClass().getName());
        
        methods.forEach(System.out::println);
        // methods.sort(fullName.reversed());
        methods.sort(TEST_NAME.reversed());
        methods.forEach(System.out::println);

        return methods;
    }
}
