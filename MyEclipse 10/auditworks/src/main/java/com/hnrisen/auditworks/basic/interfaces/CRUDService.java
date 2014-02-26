package com.hnrisen.auditworks.basic.interfaces;

import java.io.Serializable;
import java.util.List;

/**
 * The Interface CRUDService.
 * 
 * @param <T>
 *            the generic type
 */
public interface CRUDService<T extends Serializable> {
	
	/**
	 * Removes the entity.
	 * 
	 * @param domain
	 *            the domain
	 * @throws Exception
	 *             the exception
	 */
	void remove(T domain) throws Exception;
	
	/**
	 * Insert.
	 * 
	 * @param domain
	 *            the domain
	 * @throws Exception
	 *             the exception
	 */
	void create(T domain) throws Exception;
	
	/**
	 * Update.
	 * 
	 * @param domain
	 *            the domain
	 * @throws Exception
	 *             the exception
	 */
	void modify(T domain) throws Exception;
	
	/**
	 * Gets the.
	 * 
	 * @param domain
	 *            the domain
	 * @return the t
	 */
	T get(T domain) throws Exception;
	
	/**
	 * Gets the all.
	 * 
	 * @param domain
	 *            the domain
	 * @return the all
	 */
	List<T> getAll(T domain) throws Exception;
	
}
