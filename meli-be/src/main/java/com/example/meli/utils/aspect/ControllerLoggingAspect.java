package com.example.meli.utils.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@Slf4j
public class ControllerLoggingAspect {

  @Pointcut("within(@org.springframework.web.bind.annotation.RestController *)")
  public void restControllerMethods() {}

  @Around("restControllerMethods()")
  public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
    String className = joinPoint.getSignature().getDeclaringTypeName();
    String methodName = joinPoint.getSignature().getName();
    Object[] args = joinPoint.getArgs();

    log.info("→ [{}#{}] llamado con argumentos: {}", className, methodName, Arrays.toString(args));

    long start = System.currentTimeMillis();
    try {
      Object result = joinPoint.proceed();
      long duration = System.currentTimeMillis() - start;

      log.info("← [{}#{}] completado en {}ms con respuesta: {}", className, methodName, duration, result);
      return result;

    } catch (Throwable ex) {
      log.error("✖ [{}#{}] falló con excepción: {}", className, methodName, ex.getMessage(), ex);
      throw ex;
    }
  }
}