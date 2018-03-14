#!/usr/bin/env bash
mvn clean test -Dmy.listener.intercept=com.kostya.MethodInterceptor -Dmy.listener.load=com.kostya.AnnotationTransformer