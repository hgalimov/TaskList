package ru.uennar.birem.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {
    @Pointcut("execution(* *.get*(..))")
    private void allGetMethods(){
    }
    @Before("allGetMethods()")
    public void logBefore(){
        System.out.println("aspectTest");
    }
}
