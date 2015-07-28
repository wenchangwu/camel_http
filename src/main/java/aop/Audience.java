package aop;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Audience {
	
	@Pointcut("execution(** Performance.perform(..))")
	public void performance(){};

	@Before("performance()")
	public void silenceCellphones(){
		System.out.println("silencing cell phones");
	}
	
	@Before("performance()")
	public void tekeSeats(){
		System.out.println("taking seat");
	}
	
	@AfterReturning("performance()")
	public void applause(){
		System.out.println("CLAP CLAP CLAP");
	}
	@AfterThrowing("performance()")
	public void demandRefund(){
		System.out.println("demanding is refund");
	}
}
