package com.app.hannahcore.aop;

import com.blankj.utilcode.util.LogUtils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * Created by Nick on 2019-11-08.
 */
@Aspect
public class CommonAspect {


    @Pointcut("execution(@com.app.hannahcore.aop.TimeLog * *(..))")
    private void calculateTimePointcut(){}

    @Around("calculateTimePointcut()")
    public void caculateTime(ProceedingJoinPoint joinPoint) throws Throwable{
        long start = System.currentTimeMillis();
        joinPoint.proceed();
        long end = System.currentTimeMillis();
        LogUtils.i(String.format("当前方法耗时>>>> %1$sms",end-start));
    }

    private <T extends Annotation> T getMethodAnnotation(ProceedingJoinPoint joinPoint, Class<T> clazz) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        return method.getAnnotation(clazz);
    }
}
