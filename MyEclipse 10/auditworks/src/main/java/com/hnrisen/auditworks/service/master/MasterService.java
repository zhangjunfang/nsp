package com.hnrisen.auditworks.service.master;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.hnrisen.auditworks.basic.interfaces.CRUDService;
import com.hnrisen.auditworks.domain.Master;

public interface MasterService extends CRUDService<Master> {
	
	/**
	 * 
	 * 
	 * @param segname
	 *            the segname
	 * @return the masters
	 */
	List<Master> getMastersBySegname(String segname) throws DataAccessException;
}
