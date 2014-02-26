package com.hnrisen.auditworks.service.navigation.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.hnrisen.auditworks.domain.Navigation;
import com.hnrisen.auditworks.mapper.reuse.NavigationMapper;
import com.hnrisen.auditworks.service.navigation.NavigationService;

@Service
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class NavigationServiceImpl implements NavigationService<Navigation> {

	@Autowired
	private NavigationMapper<Navigation> navigationMapper;
	
	public void setNavigationMapperr(NavigationMapper<Navigation> navigationMapper) {
		
		this.navigationMapper = navigationMapper;
	}	
	
	@Override
	public void remove(Navigation navigationMapper) throws Exception {
		// TODO Auto-generated method stub
		this.navigationMapper.delete(navigationMapper);
	}

	@Override
	public void create(Navigation navigationMapper) throws Exception {
		// TODO Auto-generated method stub
		this.navigationMapper.insert(navigationMapper);
	}

	@Override
	public void modify( Navigation navigationMapper) throws Exception {
		// TODO Auto-generated method stub
		this.navigationMapper.update(navigationMapper);
	}

	@Override
	public Navigation get(Navigation navigationMapper) throws Exception {
		// TODO Auto-generated method stub
		return this.navigationMapper.selectOne(navigationMapper);
	}

	@Override
	public List<Navigation> getAll(Navigation navigationMapper) throws Exception {
		// TODO Auto-generated method stub
		return this.navigationMapper.selectAll(navigationMapper);
	}
}




