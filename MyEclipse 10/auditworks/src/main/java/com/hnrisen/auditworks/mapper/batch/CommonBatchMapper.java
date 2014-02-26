package com.hnrisen.auditworks.mapper.batch;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;


/**
 *
 *
 *
 */
@Repository("commonBatchMapper")
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public interface CommonBatchMapper {
	
	List<Map<String, Object>> selectBySql(String sql) throws DataAccessException;
	
	
	// getArrayList(String sql) throws DataAccessException;
	
}
