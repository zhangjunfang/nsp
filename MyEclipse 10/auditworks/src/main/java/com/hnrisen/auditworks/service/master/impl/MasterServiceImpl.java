package com.hnrisen.auditworks.service.master.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hnrisen.auditworks.domain.Master;
import com.hnrisen.auditworks.mapper.reuse.MasterMapper;
import com.hnrisen.auditworks.service.master.MasterService;

@Service
public class MasterServiceImpl implements MasterService {
	
	// private static final Logger logger =
	// LoggerFactory.getLogger(MasterServiceImpl.class);
	
	@Autowired
	private MasterMapper<Master> masterMapper;
	
	/**
	 * Sets the master mapper.
	 * 
	 * @param masterMapper
	 *            the new account mapper
	 */
	public void setMasterMapper(MasterMapper<Master> masterMapper) {
	
		this.masterMapper = masterMapper;
	}
	
	@Override
	public List<Master> getMastersBySegname(String segname) {
	
		return this.masterMapper.getMastersBySegname(segname);
	}
	
	@Override
	public void remove(Master master) throws Exception {
	
		this.masterMapper.delete(master);
	}
	
	@Override
	public void create(Master master) throws Exception {
	
		this.masterMapper.insert(master);
	}
	
	@Override
	public void modify(Master master) throws Exception {
	
		this.masterMapper.update(master);
	}
	
	@Override
	public Master get(Master master) throws Exception {
	
		return this.masterMapper.selectOne(master);
	}
	
	@Override
	public List<Master> getAll(Master master) throws Exception {
	
		return this.masterMapper.selectAll(master);
	}
	
}
