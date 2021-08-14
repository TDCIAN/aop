package com.example.aop.aop;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimerAop { // 특정 메소드의 실행 시간 파악
}
