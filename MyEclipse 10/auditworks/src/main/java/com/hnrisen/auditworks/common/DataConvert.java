/**
 * 
 */
package com.hnrisen.auditworks.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hnrisen.auditworks.domain.ColumnModel;
import com.hnrisen.auditworks.domain.Master;
import com.hnrisen.auditworks.service.contact.ContactService;
import com.hnrisen.auditworks.service.master.MasterService;
import com.hnrisen.auditworks.util.Constant;

/**
 * @author ： ocean date ：2012-4-20
 */
public class DataConvert implements Serializable {
	
	private static final long serialVersionUID = 3392758874306358754L;
	
	private final Log log = LogFactory.getLog(DataConvert.class);
	
	private List<Master> getColumnName(MasterService masterService, String tableName) {
	
		List<Master> masters = null;
		
		try {
			
			masters = masterService.getMastersBySegname(tableName);
			
		} catch ( Exception e ) {
			
			log.error(Tooltip.DATA_ACCESS_TABLESTRUCTURE_EXCEPTION + Constant.LINE_BREAK);
			
			e.printStackTrace();
		}
		return masters;
	}
	
	private List<Map<String, Object>> getQueryResultSet(ContactService contactService, String sql) {
	
		log.info("查询表数据结果集");
		
		return contactService.selectBySql(sql);
		
	}
	
	private List<Map<String, Object>> getData(ContactService contactService, String sql,
			MasterService masterService, String tableName) {
	
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		
		List<Map<String, Object>> results = getQueryResultSet(contactService, sql);
		
		List<Master> masters = getColumnName(masterService, tableName);
		
		for ( Map<String, Object> row : results ) {
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			for ( Master master : masters ) {
				
				if (row.containsKey(master.getFieldName().toUpperCase())) {
					
					map.put(master.getTitle(), row.get(master.getFieldName()));
					
				} else {
					
					map.put(master.getTitle(), null);
					
				}
				
			}
			
			list.add(map);
			
		}
		return list;
		
	}
	
	public List<Map<String, Object>> getViewData(ContactService contactService, String sql,
			MasterService masterService, String tableName) {
	
		return getData(contactService, sql, masterService, tableName);
		
	}
	
	public List<ColumnModel> getColumnModel(MasterService masterService, String tableName) {
	
		List<Master> masters = masterService.getMastersBySegname(tableName);
		
		List<ColumnModel> cols = new ArrayList<ColumnModel>();
		
		for ( Master master : masters ) {
			
			ColumnModel col = new ColumnModel(master.getTitle(), master.getFieldName(), 40, true,
					"left");
			
			cols.add(col);
			
		}
		return cols;
	}
	
}
