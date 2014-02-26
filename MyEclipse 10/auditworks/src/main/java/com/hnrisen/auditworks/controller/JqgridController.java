package com.hnrisen.auditworks.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import com.hnrisen.auditworks.domain.ColumnModel;
import com.hnrisen.auditworks.domain.Master;
import com.hnrisen.auditworks.service.contact.ContactService;
import com.hnrisen.auditworks.service.master.MasterService;
import com.hnrisen.auditworks.util.Constant;
import com.hnrisen.auditworks.util.JqgridJsonDataWrapper;


@Controller
public class JqgridController {
	
	private static final Log log = LogFactory.getLog(JqgridController.class);
	
	@Autowired
	private ContactService contactService;
	
	@Autowired
	private MasterService masterService;
	
	@RequestMapping(value = "/query/jqgrid", method = RequestMethod.GET)
	public String flexigrid() {
	
		return "/query/jqgrid";
	}
	
	@RequestMapping(value = "/query/getRows", method = RequestMethod.GET)
	public @ResponseBody
	JqgridJsonDataWrapper<Map<String, Object>> getRows(WebRequest request) throws Exception {
	
		/******************************************************************************
		 * 
		 * 获取表名对应的表元数据
		 * 
		 * 
		 * *****************************************************************************/
		
		List<Master> masters = masterService.getMastersBySegname("LN_MST_HST");
		
		log.info(Constant.LINE_BREAK + "=======================1============" + Constant.LINE_BREAK
				+ Arrays.toString(masters.toArray()));
		
		String sql = "select trace_no, trace_cnt, opn_br_no, tx_br_no, ac_id, ac_seqn, tx_code, sub_tx_code, ln_tx_type, add_ind, ct_ind, tx_amt, bal, intst_acm, tx_date, tx_time, note_type, note_no, hst_cnt, brf, tel, chk, auth from ln_mst_hst100y";
		sql += " where rownum < 100";
		/******************************************************************************
		 * 
		 * 表元数据对应数据的结果集
		 * 
		 * 
		 * *****************************************************************************/
		List<Map<String, Object>> results = this.contactService.selectBySql(sql);
		
		
		int page = Integer.valueOf(request.getParameter("page"));
		
		int total = Integer.valueOf(request.getParameter("total"));
		
		String  id = request.getParameter("id");
		
	    log.info(id);
		
		/******************************************************************************
		 * 
		 * 把英文名称的列名转化为中文的列名
		 * 
		 * 以及列对应的数据
		 * 
		 * 
		 * *****************************************************************************/
		
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		
		for ( Map<String, Object> row : results ) {
			Map<String, Object> map1 = new HashMap<String, Object>();
			for ( Master master : masters ) {
				if (row.containsKey(master.getFieldName().toUpperCase())) {
					map1.put(master.getTitle(), row.get(master.getFieldName()));
				} else {
					map1.put(master.getTitle(), null);
				}
			}
			list.add(map1);
		}
		
		/******************************************************************************
		 * 
		 * 把数据结果集截取单页显示的数据列表
		 * 
		 * 
		 * *****************************************************************************/
		JqgridJsonDataWrapper<Map<String, Object>> jdw = new JqgridJsonDataWrapper<Map<String, Object>>(
				page, total, 100, list);
		
		return jdw;
	}
	
	@RequestMapping(value = "/query/getColumnModel2", method = RequestMethod.GET)
	public @ResponseBody
	List<ColumnModel> getColumnModel2() throws Exception {
	
		List<Master> masters = masterService.getMastersBySegname("LN_MST_HST");
		List<ColumnModel> cols = new ArrayList<ColumnModel>();
		for ( Master master : masters ) {
			// {display: '', name : '', width : 40, sortable : true, align:`
			// 'center'}
			ColumnModel col = new ColumnModel(master.getTitle(), master.getFieldName(), 40, true,
					"left");
			cols.add(col);
		}
		return cols;
	}
	
	
}

