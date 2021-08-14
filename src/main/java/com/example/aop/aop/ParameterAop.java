package com.example.aop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class ParameterAop {

    @Pointcut("execution(* com.example.aop.controller..*.*(..))") // com.example.aop.controller의 하위 전체에서 실행
    private void cut(){}

    @Before("cut()") // Pointcut(cut())이 실행되는 시점에 before() 메소드를 실행시키겠다
    public void before(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        System.out.println(method.getName());

        Object[] args = joinPoint.getArgs();
        for(Object obj: args) {
            System.out.println("type: "+obj.getClass().getSimpleName());
            System.out.println("value: "+obj);
        }
    }

    @AfterReturning(value = "cut()", returning = "returnObj") // cut() 메소드가 정상 실행되고 나면 returnObj를 알 수 있다
    public void afterReturn(JoinPoint joinPoint, Object returnObj) {
        System.out.println("return obj");
        System.out.println(returnObj);
    }
}
