package cs544.spring.bank.service.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

import cs544.spring.bank.logging.ILogger;

@Aspect
public class DAOLogAdvice {

	ILogger logger;
	
	public void setLogger(ILogger logger){
		this.logger = logger;
	}
	
	@After("execution(* cs544.spring.bank.dao.*.*(*))")
	public void logDAOCall(JoinPoint joinpoint){
		logger.log("method: "+joinpoint.getSignature().getName());
	}
	
}
