package com.dayatang.dsrouter.datasource.examples.test;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.dayatang.domain.InstanceFactory;
import com.dayatang.dsrouter.datasource.examples.CustomerContextHolder;
import com.dayatang.dsrouter.datasource.examples.CustomerType;
import com.dayatang.springtest.PureSpringTestCase;

public class ExamplesTest extends PureSpringTestCase {

	// private MultiTenantContext tenantContext;

	@Override
	@Before
	public void setup() {
		super.setup();

		// tenantContext = createMock(MultiTenantContext.class);
	}

	@Override
	@After
	public void teardown() {
		super.teardown();

		// tenantContext = null;
	}

	protected String[] createXmlPath() {
		return new String[] { "classpath:spring/examples/*.xml" };
	}

	@Test
	public void notNull() {
		// DataSource ds = (DataSource) context.getBean("dataSource");
		DataSource ds = InstanceFactory.getInstance(DataSource.class);
		assertNotNull(ds);
	}

	@Test
	public void getConnection() throws Exception {
		CustomerContextHolder.setCustomerType(CustomerType.GOLD);
		printConn();

		CustomerContextHolder.setCustomerType(CustomerType.SILVER);
		printConn();

		CustomerContextHolder.clearCustomerType();
		printConn();
	}

	private void printConn() throws SQLException {
		// DataSource ds = (DataSource) context.getBean("dataSource");
		DataSource ds = InstanceFactory.getInstance(DataSource.class);
		Connection connection = ds.getConnection();
		connection.setReadOnly(true);
		System.err.println(connection.getMetaData().getURL());
		System.err.println(connection.getMetaData().getURL());
		System.err.println(connection.getCatalog());
	}

}
