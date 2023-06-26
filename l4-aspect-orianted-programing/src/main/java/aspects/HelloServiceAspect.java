package aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect // by adding aspect we will not create instance of this class on the context (not like @component)
@Component
public class HelloServiceAspect {
    /**
     * the execution(* services.HelloServices.hello(..)) expression defines a pointcut that matches the execution of
     * the hello method in the HelloServices class, regardless of the return type and the number or type of arguments.
     */

    /**
     * -> @After @Before ... known as join points
     */
    @Before("execution(* services.HelloServices.hello(..))")
    public void before() {
        System.out.println("A");
    }

    @After("execution(* services.HelloServices.hello(..))")
    public void after() {
        System.out.println("B");
    }

    @AfterReturning("execution(* services.HelloServices.hello(..))")
    public void afterReturning() {
        System.out.println("C");
    }

    @AfterThrowing("execution(* services.HelloServices.hello(..))")
    public void afterThrowing() {
        System.out.println("D");
    }
    /**
     * @Around the most powerful join point type
     *
     * NOTE: it's advisable to not use aspects as replaceable, but we should use it as decoration
     */

    @Around("execution(* services.HelloServices.hello(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable { // joinPoint represent the method itself
        System.out.println("shit");
//        joinPoint.proceed();
        joinPoint.proceed(new Object[]{"Ahmed"}); // a way to manipulate the inputs of the method
        return "something else !!";
    }
}
