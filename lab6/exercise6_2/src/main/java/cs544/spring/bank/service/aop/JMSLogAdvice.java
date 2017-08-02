package cs544.spring.bank.service.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

import cs544.spring.bank.logging.ILogger;

@Aspect
public class JMSLogAdvice {

	ILogger logger;
	
	public void setLogger(ILogger logger){
		this.logger = logger;
	}
	
	@After("execution(* cs544.spring.bank.jms.*.*(*))")
	public void logJMSMessage(JoinPoint joinPoint){
		logger.log("***** JMS Method : " + joinPoint.getSignature().getName());
	}
}
