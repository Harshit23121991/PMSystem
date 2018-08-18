package com.kelloggs.upc.log;

import java.util.Arrays;

import java.util.Calendar;

import org.apache.log4j.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import com.kelloggs.upc.common.exception.UPCException;

@Aspect
public class LoggingAspect {
	static final Logger logger = Logger.getLogger(LoggingAspect.class);

	/*@Around("execution(* com.kelloggs.upc1.service..*.*(..))")
	public Object logAround(final ProceedingJoinPoint iproceedingJoinPoint)
			throws Throwable {
		logger.info("The method "
				+ iproceedingJoinPoint.getSignature().getName()
				+ "() begins with "
				+ Arrays.toString(iproceedingJoinPoint.getArgs()));
		try {
			
			Object aresult = iproceedingJoinPoint.proceed();
			logger.info("The method "
					+ iproceedingJoinPoint.getSignature().getName()
					+ "() ends with " + aresult);
			return aresult;
		} catch (IllegalArgumentException e) {
			logger.error("Illegal argument "
					+ Arrays.toString(iproceedingJoinPoint.getArgs()) + " in "
					+ iproceedingJoinPoint.getSignature().getName() + "()");
			throw e;
		}

		catch (Exception e) {
			logger.error("Illegal argument "
					+ Arrays.toString(iproceedingJoinPoint.getArgs()) + " in "
					+ iproceedingJoinPoint.getSignature().getName() + "()");
			logger.error(e);
			throw e;
		}
	}

	@Around("execution(* com.kelloggs.upc1.service.resource.*.*(..))")
	public Object logAroundResource(
			final ProceedingJoinPoint iproceedingJoinPoint) throws Throwable {
		long startTime = Calendar.getInstance().getTimeInMillis();
		logger.info("The method "
				+ iproceedingJoinPoint.getSignature().getName()
				+ "() begins with "
				+ Arrays.toString(iproceedingJoinPoint.getArgs()));
		try {
			Object aresult = iproceedingJoinPoint.proceed();
			logger.info("The method "
					+ iproceedingJoinPoint.getSignature().getName()
					+ "() ends with " + aresult);
			return aresult;
		} catch (IllegalArgumentException e) {
			logger.error("Illegal argument "
					+ Arrays.toString(iproceedingJoinPoint.getArgs()) + " in "
					+ iproceedingJoinPoint.getSignature().getName() + "()");
			throw e;
		} finally {
			long endTime = Calendar.getInstance().getTimeInMillis();
			long totalTime = endTime - startTime;
			logger.info("Total Execution Time in ms: " + totalTime);
		}
	}

	@AfterThrowing(value = "execution(* com.kelloggs.upc1.service..*.*(..))", throwing = "throwable", argNames = "joinPoint, throwable")
	public void afterThrowing(final JoinPoint ijoinPoint,
			final Throwable ithrowable) {

		if (ithrowable instanceof UPCException) {
			logger.error(ijoinPoint.getArgs(),
					((UPCException) ithrowable).getRootCause());
		} else {
			logger.error(ijoinPoint.getArgs(), ithrowable);
		}

	}
*/
}