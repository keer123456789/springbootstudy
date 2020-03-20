package com.keer.aopdemo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @BelongsProject: spring-boot-study
 * @BelongsPackage: com.keer.aopdemo
 * @Author: keer
 * @CreateTime: 2020-03-20 09:37
 * @Description:
 */
@Component
@Aspect
public class AspectLog {
    protected Logger logger= LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(public * com.keer.aopdemo.Controller.get1(..))")
    public void aspectLog1() {
    }

    @Pointcut("execution(public * com.keer.aopdemo.Controller.get2(..))")
    public void aspectLog2() {
    }

    @Before("aspectLog1()")
    public void doBefore(JoinPoint joinPoint){
        List<String> args=new ArrayList<>();
        for(Object arg:joinPoint.getArgs()){
            args.add((String) arg);
        }
        logger.info("AOP： 方法前执行");
        logger.info("AOP： 方法名："+joinPoint.getSignature().getName()+",方法参数："+args.toString());
    }

    @After("aspectLog1()")
    public void doAfter(JoinPoint joinPoint){
        logger.info("AOP： 方法结束执行");
    }

    @AfterReturning("aspectLog1()")
    public void doAfterReturn(JoinPoint joinPoint){
        logger.info("AOP: 方法执行结束返回结果后执行");
    }
    @AfterThrowing("aspectLog1()")
    public void deAfterThrowing(JoinPoint joinPoint){
        logger.info("AOP: 方法抛出异常后执行");
    }

    @Around("aspectLog2()")
    public void doAround(ProceedingJoinPoint joinPoint){
        try {
            List<String> args=new ArrayList<>();
            for(Object arg:joinPoint.getArgs()){
                args.add((String) arg);
            }
            logger.info("AOP： 方法前执行");
            logger.info("AOP： 方法名："+joinPoint.getSignature().getName()+",方法参数："+args.toString());
            joinPoint.proceed();
            logger.info("AOP: 方法执行结束返回结果后执行");
        }catch (Throwable e){
            logger.info("AOP: 方法抛出异常后执行");
        }
    }

}
