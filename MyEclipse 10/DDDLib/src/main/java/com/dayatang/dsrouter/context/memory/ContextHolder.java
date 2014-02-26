package com.dayatang.dsrouter.context.memory;

public class ContextHolder {

	private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();

	private ContextHolder() {
		super();
	}

	public static void setContextType(String contextType) {
		contextHolder.set(contextType);
	}

	public static String getContextType() {
		return contextHolder.get();
	}

	public static void clearContextType() {
		contextHolder.remove();
	}
}
