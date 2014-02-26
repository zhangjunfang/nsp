package net.newcapec.bus.service;

import java.util.Locale;

import org.springframework.web.context.ContextLoader;

/**
 *
 * @author 黄鑫
 *
 */
public abstract class AbstractService {

	protected String getMessage(String key) {
		return ContextLoader.getCurrentWebApplicationContext().getMessage(key, null, Locale.getDefault());
	}
}
