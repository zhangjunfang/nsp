/**
 * 
 */
package com.hnrisen.auditworks.service.tree.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.hnrisen.auditworks.domain.tree.Tree;
import com.hnrisen.auditworks.mapper.batch.CommonBatchMapper;
import com.hnrisen.auditworks.service.tree.TreeService;
import com.hnrisen.auditworks.service.tree.constant.TreeConstant;

/**
 * @author ： ocean date ：2012-4-27
 */
@Service(value = "treeServiceImpl")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class TreeServiceImpl implements TreeService<Tree> {
	
	private static final long serialVersionUID = 2550521511806980848L;
	
	private Log log = LogFactory.getLog(getClass());
	
	@Resource(name = "commonBatchMapper")
	private CommonBatchMapper commonBatchMapper;
	
	@Override
	public List<Map<String, Object>> selectBySql(String sql) throws DataAccessException {
	
		return commonBatchMapper.selectBySql(sql);
		
	}
	
	@Override
	public Tree [] getTreeData(String [] jsonKey, String... columnName) {
	
		Tree [] temp = null;
		
		try {
			
			temp = getTreeAsArray(jsonKey, columnName);
			
			
			
		} catch ( JsonGenerationException e ) {
			
			log.error("JSON 数据书写出错 ");
			
			e.printStackTrace();
		} catch ( JsonMappingException e ) {
			
			log.error("JSON 数据映射出错 ");
			
			e.printStackTrace();
			
		} catch ( IOException e ) {
			
			log.error("JSON 数据读写出错 ");
			
			e.printStackTrace();
		}
		return temp;
	}
	
	/**
	 * 
	 * json 数据格式字符串
	 * 
	 * */
	@Override
	public String getTrees(String [] jsonKey, String... columnName) {
	
		List<Map<String, Object>> list = selectBySql(TreeConstant.DEPARTMENT_SQL);
		
		ObjectMapper mapper = new ObjectMapper();
		
		List<Map<String, Object>> lists = new ArrayList<Map<String, Object>>(list.size());
		
		for ( Map<String, Object> map : list ) {
			
			Map<String, Object> userInMap = new HashMap<String, Object>();
			
			Set<Entry<String, Object>> set = map.entrySet();
			
			Iterator<Entry<String, Object>> iterator = set.iterator();
			
			while ( iterator.hasNext() ) {
				
				Entry<String, Object> entry = iterator.next();
				
				String key = entry.getKey();
				
				Object value = entry.getValue();
				
				Assert.notNull(key);
				
				for ( int i = 0 ; i < jsonKey.length ; i++ ) {
					
					if (columnName[0].equals(key)) {
						
						userInMap.put(jsonKey[0], value);
						
					}
					if (columnName[1].equals(key)) {
						
						userInMap.put(jsonKey[1], value);
						
					}
					
					if (columnName[2].equals(key)) {
						
						userInMap.put(jsonKey[2], value);
						userInMap.put("t", value);
						
					}
					
				}
				
			}
			lists.add(userInMap);
		}
		
		StringBuffer buffer = new StringBuffer();
		buffer.append("[");
		int i = 0;
		for ( Map<String, Object> map : lists ) {
			
			try {
				buffer.append(mapper.writeValueAsString(map));
			} catch ( JsonGenerationException e ) {
				
				log.error("JSON 数据书写出错 ");
				
				e.printStackTrace();
			} catch ( JsonMappingException e ) {
				
				log.error("JSON 数据映射出错 ");
				
				e.printStackTrace();
				
			} catch ( IOException e ) {
				
				log.error("JSON 数据读写出错 ");
				
				e.printStackTrace();
			}
			
			if (lists.size() - 1 != i) {
				buffer.append(",");
			}
			i++;
		}
		buffer.append("]");
		log.info(buffer);
		
		return new String(buffer);
		
	}
	
	/*
	 * 返回Tree对象数组格式
	 * 
	 * 
	 * *
	 */
	
	private Tree [] getTreeAsArray(String [] jsonKey, String... columnName)
			throws JsonGenerationException, JsonMappingException, IOException {
	
		List<Map<String, Object>> list = selectBySql(TreeConstant.DEPARTMENT_SQL);
		
		Tree [] lists = new Tree[list.size()];
		
		/**
		 * 遍历集合中的元素【list】
		 * 
		 * 
		 * */
		for ( int i = 0 ; i < list.size() ; i++ ) {
			
			// 取出集合中的元素
			Map<String, Object> map = list.get(i);
			
			Set<Map.Entry<String, Object>> sets = map.entrySet();
			// 取出set集合中的Map.Entry元素
			for ( int j = 0 ; j < sets.size() ; j++ ) {
				
				Iterator<Entry<String, Object>> it = sets.iterator();
				
				Tree tree = new Tree();
				
				while ( it.hasNext() ) {
					
					Entry<String, Object> entry = it.next();
					
					String key = entry.getKey();
					
					String value = (String) entry.getValue();
					
					
					if (columnName[0].equals(key)) {
						
						tree.setId(value);
					}
					if (columnName[1].equals(key)) {
						
						tree.setpId(value);
					}
					if (columnName[2].equals(key)) {
						
						tree.setName(value);
						tree.setT(value);
					}
					
				}
				//log.info("================================================================="+ tree);
				lists[i] = tree;
			}
			
		}
		
	
		return lists;
		
	}
}
