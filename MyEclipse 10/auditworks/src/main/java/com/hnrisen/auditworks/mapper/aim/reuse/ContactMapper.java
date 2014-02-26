package com.hnrisen.auditworks.mapper.aim.reuse;

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
@Repository("contactMapper")
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public interface ContactMapper {
	
	List<Map<String, Object>> selectBySql(String sql) throws DataAccessException;
	
}
