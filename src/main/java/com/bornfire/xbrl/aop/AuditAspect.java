package com.bornfire.xbrl.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.bornfire.xbrl.services.AuditService;

import org.springframework.beans.factory.annotation.Autowired;

@Aspect
@Component
public class AuditAspect {

    @Autowired
    private AuditService auditService;

    @Around("execution(* com.bornfire.xbrl.services..*.detailChanges*(..))")
    public Object auditEntityChanges(ProceedingJoinPoint joinPoint) throws Throwable {
        // Extract method arguments
        Object[] args = joinPoint.getArgs();

        // Audit each entity argument
        if (args != null) {
            for (Object arg : args) {
                if (arg != null && isJpaEntity(arg)) {
                    auditService.auditChanges(arg);
                }
            }
        }

        // Proceed with original method call
        return joinPoint.proceed();
    }

    private boolean isJpaEntity(Object obj) {
        return obj.getClass().isAnnotationPresent(javax.persistence.Entity.class);
    }
}
