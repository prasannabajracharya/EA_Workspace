package aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.util.StopWatch;


@Aspect
public class StopWatchAdvice {
	
	
	@Around("execution(public void save(*))")
	public Object invoke(ProceedingJoinPoint call ) throws Throwable { 
		StopWatch sw = new StopWatch(); 
		sw.start(call.getSignature().getName());
		Object retVal = call.proceed();
		sw.stop();
		long totaltime = sw.getLastTaskTimeMillis();
	   // print the time to the console
		System.out.println("Time taken to run function : " + totaltime + " ms");
		return retVal; 
	}
}
