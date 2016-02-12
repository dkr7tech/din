package com.audit.login;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;

@Aspect
public class AuditAdvice {

  @Autowired
  private AuditService auditService;

  /**
   * Advice for auditing a user's visit to a page. The rule is that the Before annotation
   * applies to any method in any class in the com.captaindebug.audit.controller package
   * where the class name ends in 'Controller' and the method is annotated by @Audit.
   * 
   * @param auditAnnotation
   *            Audit annotation holds the name of the screen we're auditing.
   */
  @Before("execution(public String com.controller.*Controller.*(..)) && @annotation(auditAnnotation) ")
  public void myBeforeLogger(Audit auditAnnotation) {

    auditService.audit(auditAnnotation.value());
  }

}