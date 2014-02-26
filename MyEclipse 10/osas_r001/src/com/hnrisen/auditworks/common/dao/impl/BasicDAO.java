/**
 * 
 */
package com.hnrisen.auditworks.common.dao.impl;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.hnrisen.auditworks.common.dao.intefaces.IBasicDAO;
import com.hnrisen.auditworks.common.domain.BasicDomain;

/**
 * @author ： ocean
 *  date ：2012-4-14
 */
public  class BasicDAO<T extends BasicDomain> implements IBasicDAO<T> {

	private static final long serialVersionUID = 4511754856257586439L;
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
