package az.edu.ada.wm2.authortestingaop.aspect;


import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Slf4j
@Component
@Aspect
public class AuthorControllerAspect {


    @Pointcut("execution(* az.edu.ada.wm2.authortestingaop.service.AuthorService.*(..))")
    private void methodPointCut() {

    }

    @Before("methodPointCut()")
    public void before(JoinPoint jp) {
        log.info("Method {} is called with parameters {}", jp.getSignature(), jp.getArgs());
    }


    @AfterReturning(pointcut = "methodPointCut()", returning = "result")
    public void afterReturning(JoinPoint jp, Object result) {
        log.info("Method {} returned with value {}", jp.getSignature(), result);
    }


    @SneakyThrows
    @Around("methodPointCut()")
    public Object around(ProceedingJoinPoint pjp) {
        StopWatch watch = new StopWatch();
        watch.start();
        var result = pjp.proceed();
        watch.stop();
        log.info("Method {} took {} ms to execute", pjp.getSignature(), watch.getTotalTimeMillis());
        return result;

    }
}

