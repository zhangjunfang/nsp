package com.hnrisen.auditworks.service.subnavigation.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.hnrisen.auditworks.domain.Subnavigation;
import com.hnrisen.auditworks.mapper.reuse.SubnavigationMapper;
import com.hnrisen.auditworks.service.subnavigation.SubnavigationService;



@Service
public class SubnavigationServiceImpl implements SubnavigationService<Subnavigation> {

	@Autowired
	private SubnavigationMapper<Subnavigation> subnavigationMapper;
	
	public void setSubnavigationMapper(SubnavigationMapper<Subnavigation> subnavigationMapper) {
		
		this.subnavigationMapper = subnavigationMapper;
	}
	
	
	@Override
	public void remove(Subnavigation subnavigationMapper) throws Exception {
		// TODO Auto-generated method stub
		this.subnavigationMapper.delete(subnavigationMapper);
	}

	@Override
	public void create(Subnavigation subnavigationMapper) throws Exception {
		// TODO Auto-generated method stub
		this.subnavigationMapper.insert(subnavigationMapper);
	}

	@Override
	public void modify(Subnavigation subnavigationMapper) throws Exception {
		// TODO Auto-generated method stub
		this.subnavigationMapper.update(subnavigationMapper);
	}

	@Override
	public Subnavigation get(Subnavigation subnavigationMapper) throws Exception {
		// TODO Auto-generated method stub
		return this.subnavigationMapper.selectOne(subnavigationMapper);
	}

	@Override
	public List<Subnavigation> getAll(Subnavigation subnavigationMapper) throws Exception {
		// TODO Auto-generated method stub
		return this.subnavigationMapper.selectAll(subnavigationMapper);
	}
	
	public List<Subnavigation> getByScene(Subnavigation subnavigationMapper) throws Exception {
		
		return this.subnavigationMapper.selectByScene(subnavigationMapper);		
	}

}




