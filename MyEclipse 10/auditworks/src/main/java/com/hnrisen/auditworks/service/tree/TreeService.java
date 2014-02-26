/**
 * 
 */
package com.hnrisen.auditworks.service.tree;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

/**
 * @author ： ocean date ：2012-4-27
 */
public interface TreeService<T> extends Serializable {
	
	List<Map<String, Object>> selectBySql(String sql) throws DataAccessException;
	
	T[]   getTreeData(String[] jsonKey,String... columnName) ;
	
	String getTrees(String[] jsonKey,String... columnName) ;
	
	
	
	
	
	
}
