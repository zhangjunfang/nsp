package com.hnrisen.auditworks.mapper.reuse;

import java.io.Serializable;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.hnrisen.auditworks.basic.interfaces.CRUDMapper;
import com.hnrisen.auditworks.domain.Master;

/**
 * The Interface MasterMapper.
 * 
 * @param <T>
 *            the generic type
 */
public interface MasterMapper<T extends Serializable> extends CRUDMapper<T> {
	
	/**
	 * Gets the masters.
	 * 
	 * @param segname
	 *            the segname
	 * @return the masters
	 * @throws DataAccessException
	 *             the data access exception
	 */
	List<Master> getMastersBySegname(String segname) throws DataAccessException;
}
