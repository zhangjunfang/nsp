package com.dayatang.dsrouter.datasource;

import java.io.PrintWriter;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 来自spring
 * 
 * @author chencao
 * 
 */
public abstract class AbstractDataSource implements DataSource {

	/** Logger available to subclasses */
	protected final Log logger = LogFactory.getLog(getClass());

	/**
	 * Returns 0, indicating the default system timeout is to be used.
	 */
	@Override
	public int getLoginTimeout() throws SQLException {
		return 0;
	}

	/**
	 * Setting a login timeout is not supported.
	 */
	@Override
	public void setLoginTimeout(int timeout) throws SQLException {
		throw new UnsupportedOperationException("setLoginTimeout");
	}

	/**
	 * LogWriter methods are not supported.
	 */
	@Override
	public PrintWriter getLogWriter() {
		throw new UnsupportedOperationException("getLogWriter");
	}

	/**
	 * LogWriter methods are not supported.
	 */
	@Override
	public void setLogWriter(PrintWriter pw) throws SQLException {
		throw new UnsupportedOperationException("setLogWriter");
	}

	// ---------------------------------------------------------------------
	// Implementation of JDBC 4.0's Wrapper interface
	// ---------------------------------------------------------------------

	@Override
	@SuppressWarnings("unchecked")
	public <T> T unwrap(Class<T> iface) throws SQLException {

		if (iface == null) {
			throw new IllegalArgumentException(
					"Interface argument must not be null");
		}

		if (!DataSource.class.equals(iface)) {
			throw new SQLException(
					"DataSource of type ["
							+ getClass().getName()
							+ "] can only be unwrapped as [javax.sql.DataSource], not as ["
							+ iface.getName());
		}
		return (T) this;
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		return DataSource.class.equals(iface);
	}

}