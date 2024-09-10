package com.bridgelabz.aop1.advice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import org.springframework.stereotype.Component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Aspect
@Component
public class LoggingAdvice
{
    Logger log = (Logger) LoggerFactory.getLogger(LoggingAdvice.class);
//    private static final Logger log = LoggerFactory.getLogger(LoggingAdvice.class);

    @Pointcut(value = "execution(* com.bridgelabz.aop1.*.*.*(..) )")
    public void myPointCut()
    {

    }

    @Around("myPointCut()")
    public Object applicationLogger(ProceedingJoinPoint pjp) throws Throwable {
        ObjectMapper objectMapper=new ObjectMapper();
        String methodName=pjp.getSignature().getName();
        String className=pjp.getTarget().getClass().getName();
        Object[] args = pjp.getArgs();

        log.info("method invoked "+className+" : "
                +methodName+"() arguments :"
                +objectMapper.writeValueAsString(args));

        Object proceed = pjp.proceed();

        log.info(className+" : "
                +methodName+"() response :"
                +objectMapper.writeValueAsString(args));

        return proceed;
    }
}
