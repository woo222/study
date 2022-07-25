package hello.hellospring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

//    @Componenet를 쓰거나 SpringConfig에
//    @Bean
//    public TimeTraceAop timeTraceAop() {
//        return new TimeTraceAop();
//    }
//    추가

// Aop를 통해 간편하게 시간을 측정하여 병목되는 부분 확인가능
@Component
@Aspect
public class TimeTraceAop {

    // 타게팅 어디에서 시간 로직 쓸지 (* 패키지명.하위패키지..클래스명(..)
    @Around("execution(* hello.hellospring..*(..))")

    // joinPoint - 다음 메소드로 진행 , 메소드가 진행될 때마다 intercept 걸림
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {

        // 시간 로직직
       long start = System.currentTimeMillis();
        System.out.println("START: " + joinPoint.toString());

        try {
            return joinPoint.proceed();
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("END: " + joinPoint.toString()+ " " + timeMs + "ms");
        }
    }
}
