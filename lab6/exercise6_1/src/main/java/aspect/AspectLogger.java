package aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

import cs544.exercise6_1.IEmailSender;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;

@Aspect
public class AspectLogger {
	
	private static Logger logger = Logger.getLogger(AspectLogger.class);
	@After("execution(public void sendEmail(*,*)) && args(email, message)")
	public void logBeforeSendEmail(JoinPoint joinpoint, String email, String message){
	
		//Fri Jun 05 14:09:47 GMT 2009 method= sendMail
		IEmailSender emailSender = (IEmailSender) joinpoint.getTarget();
		
		logger.info("method: "+joinpoint.getSignature().getName() + " address=" + email + "\n Message = " + message
				+ "\n outgoing mail server = " + emailSender.getOutgoingMailServer());
	}
}
