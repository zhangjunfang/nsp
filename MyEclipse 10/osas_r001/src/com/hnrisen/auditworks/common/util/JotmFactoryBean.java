/**
 * 
 */
package com.hnrisen.auditworks.common.util;

import javax.naming.NamingException;
import javax.transaction.SystemException;

import org.objectweb.jotm.Current;
import org.objectweb.jotm.Jotm;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author ocean
 */
public class JotmFactoryBean implements FactoryBean<Current>, DisposableBean {

	private Current jotmCurrent;

	private Jotm jotm;

	public JotmFactoryBean() throws NamingException {
		
		this.jotmCurrent = Current.getCurrent();

		
		if (this.jotmCurrent == null) {
			
			this.jotm = new Jotm(true, false);
			this.jotmCurrent = Current.getCurrent();
		}
	}

	public void setDefaultTimeout(int defaultTimeout) {
		this.jotmCurrent.setDefaultTimeout(defaultTimeout);
		
		try {
			this.jotmCurrent.setTransactionTimeout(defaultTimeout);
		} catch (SystemException ex) {
		
			ex.printStackTrace();
		}
	}

	public Jotm getJotm() {
		return this.jotm;
	}

	@Override
	public Current getObject() {
		return this.jotmCurrent;
	}

	@Override
	public Class<?> getObjectType() {
		return this.jotmCurrent.getClass();
	}

	@Override
	public boolean isSingleton() {
		return true;
	}

	@Override
	public void destroy() {
		if (this.jotm != null) {
			this.jotm.stop();
		}
	}

}
