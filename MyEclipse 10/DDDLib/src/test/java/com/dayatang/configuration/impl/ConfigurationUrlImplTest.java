package com.dayatang.configuration.impl;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.dayatang.configuration.impl.ConfigurationUrlImpl;

public class ConfigurationUrlImplTest extends AbstractConfigurationTest {
	
	@Before
	public void setUp() throws Exception {
		instance = ConfigurationUrlImpl.fromUrl("http://www.dayatang.com/conf.properties");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testUsePrefix() {
		((ConfigurationUrlImpl)instance).usePrefix("org.dayatang");
		assertTrue(instance.getBoolean("finished"));
	}

}
