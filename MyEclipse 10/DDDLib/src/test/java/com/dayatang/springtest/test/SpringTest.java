package com.dayatang.springtest.test;

import org.dbunit.operation.DatabaseOperation;
import org.junit.Test;

import com.dayatang.dbunit.DataSetStrategy;
import com.dayatang.domain.InstanceFactory;
import com.dayatang.springtest.AbstractIntegratedTestCase;

public class SpringTest extends AbstractIntegratedTestCase {

	@Override
	protected boolean rollback() {
		return true;
	}

	@Override
	protected void action4SetUp() {
	}

	@Override
	protected void action4TearDown() {
	}

	@Override
	protected DataSetStrategy getDataSetStrategy() {
		return DataSetStrategy.Xml;
	}

	// @Override
	// protected String[] getDataSetFilePaths() {
	// return new String[] { "sample-data.xml" };
	// }

	@Override
	protected DatabaseOperation setUpOp() {
		return DatabaseOperation.CLEAN_INSERT;
	}

	@Override
	protected DatabaseOperation tearDownOp() {
		return DatabaseOperation.DELETE_ALL;
	}

	@Test
	public void cc() {
		CustomBean2 b2 = InstanceFactory.getInstance(CustomBean2.class);
		b2.aa();
	}
}
