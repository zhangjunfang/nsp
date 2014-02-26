package com.hnrisen.auditworks.service.access.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hnrisen.auditworks.domain.Access;
import com.hnrisen.auditworks.mapper.reuse.AccessMapper;
import com.hnrisen.auditworks.service.access.AccessService;

@Service
public class AccessServiceImpl implements AccessService<Access> {
	
	// private static final Logger logger =
	// LoggerFactory.getLogger(AccessServiceImpl.class);
	
	@Autowired
	private AccessMapper<Access> accessMapper;
	
	/**
	 * Sets the access mapper.
	 * 
	 * @param accessMapper
	 *            the new access mapper
	 */
	public void setAccessMapper(AccessMapper<Access> accessMapper) {
	
		this.accessMapper = accessMapper;
	}
	
	@Override
	public void remove(Access access) throws Exception {
	
		this.accessMapper.delete(access);
	}
	
	@Override
	public void create(Access access) throws Exception {
	
		this.accessMapper.insert(access);
	}
	
	@Override
	public void modify(Access access) throws Exception {
	
		this.accessMapper.update(access);
	}
	
	@Override
	public Access get(Access access) throws Exception {
	
		return this.accessMapper.selectOne(access);
	}
	
	@Override
	public List<Access> getAll(Access access) throws Exception {
	
		return this.accessMapper.selectAll(access);
	}
}
