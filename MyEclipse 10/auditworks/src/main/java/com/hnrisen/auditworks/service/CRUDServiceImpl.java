package com.hnrisen.auditworks.service;

import java.io.Serializable;
import java.util.List;

import com.hnrisen.auditworks.basic.interfaces.CRUDMapper;
import com.hnrisen.auditworks.basic.interfaces.CRUDService;

// TODO: Auto-generated Javadoc
/**
 * The Class CRUDServiceImpl.
 * 
 * @param <T>
 *            the generic type
 */
public class CRUDServiceImpl<T extends Serializable> implements CRUDService<T> {
	
	// private static final Logger logger =
	// LoggerFactory.getLogger(CRUDServiceImpl.class);
	
	private CRUDMapper<T> crudMapper;
	
	public void setCrudMapper(CRUDMapper<T> crudMapper) {
	
		this.crudMapper = crudMapper;
	}
	
	@Override
	public void remove(T domain) throws Exception {
	
		this.crudMapper.delete(domain);
	}
	
	@Override
	public void create(T domain) throws Exception {
	
		this.crudMapper.insert(domain);
	}
	
	@Override
	public void modify(T domain) throws Exception {
	
		this.crudMapper.update(domain);
	}
	
	@Override
	public T get(T domain) throws Exception {
	
		return this.crudMapper.selectOne(domain);
	}
	
	@Override
	public List<T> getAll(T domain) throws Exception {
	
		return this.crudMapper.selectAll(domain);
	}
}
