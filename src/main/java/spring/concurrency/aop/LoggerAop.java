package spring.concurrency.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.UUID;

@Slf4j
@Aspect
public class LoggerAop {

    @Around("@annotation(spring.concurrency.annotation.Trace)")
    public void doLog(ProceedingJoinPoint joinPoint) throws Throwable {

        String session = UUID.randomUUID().toString().substring(0 , 8);

        long startTime = System.currentTimeMillis();

        Signature signature = joinPoint.getSignature();
        log.info("[{}] Method Start  = {}" , session , signature);

        joinPoint.proceed();

        long endTime = System.currentTimeMillis();

        log.info("[{}] Method End = {} , executionTime = {} ms" , session ,signature , endTime - startTime);

    }
}
