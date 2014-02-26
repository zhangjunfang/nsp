/**
 * 
 */
package com.hnrisen.auditworks.common.service.impl;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.hnrisen.auditworks.common.domain.BasicDomain;
import com.hnrisen.auditworks.common.service.interfaces.IBasicService;

/**
 * @author ： ocean
 *  date ：2012-4-12
 */
public  class BasicService<T extends BasicDomain> implements IBasicService<T> {

	
	private static final long serialVersionUID = 8973941603902482356L;

	
	@Override
	public T selectOne(T domain) throws DataAccessException {
		return null;
	}

	
	@Override
	public List<T> selectAll() throws DataAccessException {
		
		return null;
	}

	
	@Override
	public List<T> selectAll(int start, int size) throws DataAccessException {
		return null;
	}

	@Override
	public void insert(T domain) throws DataAccessException {
		
	}

	@Override
	public void update(T domain) throws DataAccessException {
		
	}
	@Override
	public void update(List<T> domain) throws DataAccessException {
		
	}
	@Override
	public void delete(T domain) throws DataAccessException {
		
	}

	@Override
	public void delete() throws DataAccessException {
		
	}

	@Override
	public void delete(List<T> domain) throws DataAccessException {
		
	}

}
