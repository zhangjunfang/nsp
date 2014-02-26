package com.hnrisen.auditworks.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import com.hnrisen.auditworks.common.DataConvert;
import com.hnrisen.auditworks.domain.ColumnModel;
import com.hnrisen.auditworks.service.contact.ContactService;
import com.hnrisen.auditworks.service.master.MasterService;
import com.hnrisen.auditworks.util.JsonDataWrapper;

/******************************************************************************
 * 
 * 
 * 
 * 
 * *****************************************************************************/
@Controller
public class FlexigridController {
	
	@Autowired
	private ContactService contactService;
	
	@Autowired
	private MasterService masterService;
	
	@RequestMapping(value = "/query/flexigrid", method = RequestMethod.GET)
	public String flexigrid() {
	
		return "/query/flexigrid";
	}
	
	@RequestMapping(value = "/query/getTable", method = RequestMethod.POST)
	public @ResponseBody
	JsonDataWrapper<Map<String, Object>> getViewRows(WebRequest request) {
	
		String sql = "select trace_no, trace_cnt, opn_br_no, tx_br_no, ac_id, ac_seqn, tx_code, sub_tx_code, ln_tx_type, add_ind, ct_ind, tx_amt, bal, intst_acm, tx_date, tx_time, note_type, note_no, hst_cnt, brf, tel, chk, auth from ln_mst_hst100y";
		sql += " where rownum < 100";
		
		String tableName = "LN_MST_HST";
		
		List<Map<String, Object>> list = new DataConvert().getViewData(contactService, sql,
				masterService, tableName);
		
		int page = Integer.valueOf(request.getParameter("page"));
		
		return new JsonDataWrapper<Map<String, Object>>(page, 100, list);
	}
	
	@RequestMapping(value = "/query/getColumnModel", method = RequestMethod.GET)
	public @ResponseBody
	List<ColumnModel> getColumnModel() throws Exception {
	
		String tableName = "LN_MST_HST";
		
		return new DataConvert().getColumnModel(masterService, tableName);
		
	}
	
}
