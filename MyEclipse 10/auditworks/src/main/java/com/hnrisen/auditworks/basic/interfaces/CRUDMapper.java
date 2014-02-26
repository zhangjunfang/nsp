package com.hnrisen.auditworks.basic.interfaces;

import java.io.Serializable;
import java.util.List;

import org.springframework.dao.DataAccessException;

/**
 * The Interface CRUDMapper.
 * 
 * @param <T>
 *            the generic type
 */
public interface CRUDMapper<T extends Serializable> {
	
	/**
	 * Select object.
	 * 
	 * @param account
	 *            the account
	 * @return the t
	 * @throws DataAccessException
	 *             the data access exception
	 */
	T selectOne(T domain) throws DataAccessException;
	
	/**
	 * Select all.
	 * 
	 * @param account
	 *            the account
	 * @return the list
	 * @throws DataAccessException
	 *             the data access exception
	 */
	List<T> selectAll(T domain) throws DataAccessException;
	
	/**
	 * Insert.
	 * 
	 * @param account
	 *            the account
	 * @throws DataAccessException
	 *             the data access exception
	 */
	void insert(T domain) throws DataAccessException;
	
	/**
	 * Update.
	 * 
	 * @param account
	 *            the account
	 * @throws DataAccessException
	 *             the data access exception
	 */
	void update(T domain) throws DataAccessException;
	
	/**
	 * Delete.
	 * 
	 * @param account
	 *            the account
	 * @throws DataAccessException
	 *             the data access exception
	 */
	void delete(T domain) throws DataAccessException;
	
}
