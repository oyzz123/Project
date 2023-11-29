package com.pro.aop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAdvice{
    @Pointcut("execution(void com.pro.dao.BookDao.update())")
    public void pt(){}
    @Pointcut("execution(int com.pro.dao.BookDao.select())")
    public void pt2(){}

//    @Before("pt()")
    public void before(){
        System.out.println("before advice...");
    }

    //@After("pt()")
    public void after(){
        System.out.println("after advice...");
    }

    @Around("pt()")
    public void around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("around before advice...");
        //表示对原始操作的调用
        pjp.proceed();
        System.out.println("around after advice...");
    }

    @Around("pt2()")
    public Object aroundSelect(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("around before advice...");
        //表示对原始操作的调用
        //Object result = pjp.proceed();
        Integer ret = (Integer) pjp.proceed();
        System.out.println("around after advice...");
        //return 200;//代表原始操作的返回值
        //return result;
        return ret + 200;
    }

    @AfterReturning("pt2()")
    public void afterReturning(){
        System.out.println("aroundReturning advice...");
    }

    @AfterThrowing("pt2()")//抛出异常后运行
    public void afterThrowing(){
        System.out.println("afterThrowing advice...");
    }

}