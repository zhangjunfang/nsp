package com.dayatang.configuration.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;

import org.apache.commons.lang3.StringUtils;

import com.dayatang.configuration.Configuration;
import com.dayatang.configuration.ConfigurationException;
import com.dayatang.utils.Assert;

public abstract class AbstractConfiguration implements Configuration {
	private String prefix = "";
	private static final String DATE_FORMAT_KEY = "DATE_FORMAT";
	private static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss.SSS";
	protected Hashtable<String, String> hTable;	

	/**
	 * 激活配置前缀功能
	 * 
	 * @param prefix 如"com.dayatang.mes."
	 */
	public void usePrefix(final String prefix) {
		if (StringUtils.isNotBlank(prefix)) {
			this.prefix = prefix.endsWith(".") ? prefix : prefix + ".";
		}
	}

	/* (non-Javadoc)
	 * @see com.dayatang.configuration.Configuration#getString(java.lang.String, java.lang.String)
	 */
	@Override
	public String getString(String key, String defaultValue) {
		Assert.notBlank(key, "Key is null or empty!");
		String result = getHashtable().get(key);
		if (result == null) {
			result = getHashtable().get(prefix + key);
		}
		return result == null ? defaultValue : result;
	}

	/* (non-Javadoc)
	 * @see com.dayatang.configuration.Configuration#getString(java.lang.String)
	 */
	@Override
	public String getString(String key) {
		return getString(key, "");
	}

	/* (non-Javadoc)
	 * @see com.dayatang.configuration.WritableConfiguration#setString(java.lang.String, java.lang.String)
	 */
	@Override
	public void setString(String key, String value) {
		Assert.notBlank(key, "Key is null or empty!");
		if (StringUtils.isBlank(value)) {
			getHashtable().remove(key);
			return;
		}
		getHashtable().put(key, StringPropertyReplacer.replaceProperties(value));
	}

	/* (non-Javadoc)
	 * @see com.dayatang.configuration.Configuration#getInt(java.lang.String, int)
	 */
	@Override
	public int getInt(String key, int defaultValue) {
		String result = getString(key, String.valueOf(defaultValue));
		return StringUtils.isBlank(result) ? defaultValue : Integer.parseInt(result);
	}

	/* (non-Javadoc)
	 * @see com.dayatang.configuration.Configuration#getInt(java.lang.String)
	 */
	@Override
	public int getInt(String key) {
		return getInt(key, 0);
	}

	/* (non-Javadoc)
	 * @see com.dayatang.configuration.WritableConfiguration#setInt(java.lang.String, int)
	 */
	@Override
	public void setInt(String key, int value) {
		setString(key, String.valueOf(value));
	}

	/* (non-Javadoc)
	 * @see com.dayatang.configuration.Configuration#getLong(java.lang.String, long)
	 */
	@Override
	public long getLong(String key, long defaultValue) {
		String result = getString(key, String.valueOf(defaultValue));
		return StringUtils.isBlank(result) ? defaultValue : Long.parseLong(result);
	}

	/* (non-Javadoc)
	 * @see com.dayatang.configuration.Configuration#getLong(java.lang.String)
	 */
	@Override
	public long getLong(String key) {
		return getLong(key, 0);
	}

	/* (non-Javadoc)
	 * @see com.dayatang.configuration.WritableConfiguration#setLong(java.lang.String, long)
	 */
	@Override
	public void setLong(String key, long value) {
		setString(key, String.valueOf(value));
	}

	/* (non-Javadoc)
	 * @see com.dayatang.configuration.Configuration#getDouble(java.lang.String, double)
	 */
	@Override
	public double getDouble(String key, double defaultValue) {
		String result = getString(key, String.valueOf(defaultValue));
		return StringUtils.isBlank(result) ? defaultValue : Double.parseDouble(result);
	}

	/* (non-Javadoc)
	 * @see com.dayatang.configuration.Configuration#getDouble(java.lang.String)
	 */
	@Override
	public double getDouble(String key) {
		return getDouble(key, 0);
	}

	/* (non-Javadoc)
	 * @see com.dayatang.configuration.WritableConfiguration#setDouble(java.lang.String, double)
	 */
	@Override
	public void setDouble(String key, double value) {
		setString(key, String.valueOf(value));
	}

	/* (non-Javadoc)
	 * @see com.dayatang.configuration.Configuration#getBoolean(java.lang.String, boolean)
	 */
	@Override
	public boolean getBoolean(String key, boolean defaultValue) {
		String result = getString(key, String.valueOf(defaultValue));
		return StringUtils.isBlank(result) ? defaultValue : Boolean.parseBoolean(result);
	}

	/* (non-Javadoc)
	 * @see com.dayatang.configuration.Configuration#getBoolean(java.lang.String)
	 */
	@Override
	public boolean getBoolean(String key) {
		return getBoolean(key, false);
	}

	/* (non-Javadoc)
	 * @see com.dayatang.configuration.WritableConfiguration#setBoolean(java.lang.String, boolean)
	 */
	@Override
	public void setBoolean(String key, boolean value) {
		setString(key, String.valueOf(value));
	}

	/* (non-Javadoc)
	 * @see com.dayatang.configuration.Configuration#getDate(java.lang.String, java.util.Date)
	 */
	@Override
	public Date getDate(String key, Date defaultValue) {
		String result = getString(key);
		String dateFormat = getString(DATE_FORMAT_KEY, DEFAULT_DATE_FORMAT);
		try {
			return StringUtils.isBlank(result) ? defaultValue : new SimpleDateFormat(dateFormat).parse(result);
		} catch (ParseException e) {
			throw new ConfigurationException("日期解析错误！日期格式是：" + dateFormat + ", 日期：" + result, e);
		}
	}

	/* (non-Javadoc)
	 * @see com.dayatang.configuration.Configuration#getDate(java.lang.String)
	 */
	@Override
	public Date getDate(String key) {
		return getDate(key, null);
	}

	/* (non-Javadoc)
	 * @see com.dayatang.configuration.WritableConfiguration#setDate(java.lang.String, java.util.Date)
	 */
	@Override
	public void setDate(String key, Date value) {
		if (value == null) {
			setString(key, "");
		}
		String dateFormat = getString(DATE_FORMAT_KEY, DEFAULT_DATE_FORMAT);
		setString(key, new SimpleDateFormat(dateFormat).format(value));
	}


	public Hashtable<String, String> getHashtable() {
		if (hTable == null) {
			load();
		}
		return hTable;
	}
}
