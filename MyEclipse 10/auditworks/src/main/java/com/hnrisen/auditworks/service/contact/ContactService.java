package com.hnrisen.auditworks.service.contact;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

public interface ContactService {
	
	List<Map<String, Object>> selectBySql(String sql) throws DataAccessException;
}
