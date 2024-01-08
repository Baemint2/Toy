package com.luv2code.springboot.thymeleafdemo.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class DemoLoggingAspect {


    // setup logger
    private Logger myLogger = Logger.getLogger(getClass().getName());

    //setup pointcut decleartions
    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.controller.*.*(..))")
    private void forControllerPackage() {}

    // do the same for service and dao
    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.service.*.*(..))")
    private void forServicePackage() {}

    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.dao.*.*(..))")
    private void forDaoPackage() {}

    @Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
    private void forAppFlow() {}

    // add @Before device
    @Before("forAppFlow()")
    public void before(JoinPoint theJoinPoint) {

        //display method we are calling
        String theMethod = theJoinPoint.getSignature().toShortString();
        myLogger.info("=======> in @Before: calling method: " + theMethod);
        // display the arguments to the method

        //get the arguuments
        Object[] args = theJoinPoint.getArgs();

        // loop thru and display args
        for (Object tempArg: args) {
            myLogger.info("======> argument: " + tempArg);
        }
        // add @AfterReturning advice

    }

    @AfterReturning(
            pointcut = "forAppFlow()",
            returning = "theResult")
    public void afterReturning(JoinPoint theJoinPoint, Object theResult) {
        String theMethod = theJoinPoint.getSignature().toShortString();
        myLogger.info("=======> in @AfterReturning: from method: " + theMethod);
        //display method we are returning from
        myLogger.info("======> result : " + theResult);

        // display data returend
    }


    }

