package spring.concurrency.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.UUID;

@Slf4j
@Aspect
public class RetryAop {

    @Around("@annotation(spring.concurrency.annotation.Retry)")
    public Object doRetry(ProceedingJoinPoint joinPoint) throws Throwable {

        int retry = 3;
        Exception exception = null;

        for (int i = 1; i <= retry; i++) {
            try{
                return joinPoint.proceed();
            }catch (IllegalStateException e){
                exception = e;
            }
        }

        return exception;
    }
}
