/**
 * 
 */
package com.hnrisen.auditworks.service.tree.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hnrisen.auditworks.domain.tree.Tree;
import com.hnrisen.auditworks.mapper.batch.TreeMapper;
import com.hnrisen.auditworks.service.tree.TreeCUDService;

/**
 * @author ： ocean date ：2012-5-14
 */
@Service(value="treeCUDServiceImpl")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Transactional(propagation = Propagation.SUPPORTS,isolation=Isolation.DEFAULT)
public class TreeCUDServiceImpl implements TreeCUDService<Tree> {
	
	private static final long serialVersionUID = 8261316903126817042L;
	
	@Resource(name = "treeMapper")
	private TreeMapper<Tree> treeMapper;
	
	@Override
	public void insertTree(Tree tree) {
	
		treeMapper.insertTree(tree);
		
	}
	
	@Override
	public void updateTree(Tree tree) {
	
		treeMapper.updateTree(tree);
		
	}
	
	@Override
	public void deleteTree(Tree tree) {
	
		treeMapper.deleteTree(tree);
		
	}
	
}
