package miu.edu.exams.jun23.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ConfirmAspect {
    @Pointcut("@annotation(miu.edu.exams.jun23.aspect.annotation.Confirm)")
    public void confirmAnnotion(){}
    @AfterReturning("confirmAnnotion()")
    public void confirmation( JoinPoint joinpoint ){
// implementation to send confirmation email…
        System.out.println(joinpoint.getSignature().getName()+ "<<Confirm>>");
    }



}
