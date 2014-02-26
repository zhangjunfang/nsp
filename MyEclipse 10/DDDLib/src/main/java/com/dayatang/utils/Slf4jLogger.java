package com.dayatang.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * SLF4J日志记录器。编写此类以取代裸SLF4J的API是为了：
 * (1)使得客户代码中不必做日志级别检测，简化代码。
 * (2)将SLF4J中的日志记录的几个重载方法（无参数，一个参数，两个参数，参数数组）合并为一个（用变长参数实现）。
 * @author yyang (<a href="mailto:gdyangyu@gmail.com">gdyangyu@gmail.com</a>)
 *
 */
public class Slf4jLogger implements com.dayatang.utils.Logger {
	private Logger logger;
	
	Slf4jLogger(Logger logger) {
		this.logger = logger;
	}

	public static Slf4jLogger getLogger(Class<?> clazz) {
		Logger logger = LoggerFactory.getLogger(clazz);
		return new Slf4jLogger(logger);
	}

	public static Slf4jLogger getLogger(String name) {
		Logger logger = LoggerFactory.getLogger(name);
		return new Slf4jLogger(logger);
	}
	
	@Override
	public void debug(String msg, Object... args) {
		if (logger.isDebugEnabled()) {
			logger.debug(msg, args);
		}
	}
	
	@Override
	public void debug(String msg, Throwable t) {
		if (logger.isDebugEnabled()) {
			logger.debug(msg, t);
		}
	}
	
	@Override
	public void info(String msg, Object... args) {
		if (logger.isInfoEnabled()) {
			logger.info(msg, args);
		}
	}
	
	@Override
	public void info(String msg, Throwable t) {
		if (logger.isInfoEnabled()) {
			logger.info(msg, t);
		}
	}
	
	@Override
	public void trace(String format, Object... args) {
		if (logger.isTraceEnabled()) {
			logger.trace(format, args);
		}
	}
	
	@Override
	public void trace(String msg, Throwable t) {
		if (logger.isTraceEnabled()) {
			logger.trace(msg, t);
		}
	}
	
	@Override
	public void warn(String format, Object... args) {
		if (logger.isWarnEnabled()) {
			logger.warn(format, args);
		}
	}
	
	@Override
	public void warn(String msg, Throwable t) {
		if (logger.isWarnEnabled()) {
			logger.warn(msg, t);
		}
	}
	
	@Override
	public void error(String format, Object... args) {
		if (logger.isErrorEnabled()) {
			logger.error(format, args);
		}
	}
	
	@Override
	public void error(String msg, Throwable t) {
		if (logger.isErrorEnabled()) {
			logger.error(msg, t);
		}
	}
	
}
