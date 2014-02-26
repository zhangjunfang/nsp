package com.hnrisen.auditworks.service.contact.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.hnrisen.auditworks.mapper.aim.reuse.ContactMapper;
import com.hnrisen.auditworks.service.contact.ContactService;

@Service
public class ContactServiceImpl implements ContactService {
	
	@Autowired
	private ContactMapper contactMapper;
	
	@Override
	public List<Map<String, Object>> selectBySql(String sql) throws DataAccessException {
	
		return this.contactMapper.selectBySql(sql);
	}
	
}
