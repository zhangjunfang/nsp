package com.hnrisen.auditworks.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hnrisen.auditworks.domain.Master;
import com.hnrisen.auditworks.service.contact.ContactService;
import com.hnrisen.auditworks.service.master.MasterService;

/**
 * The Class AccountController.
 */
@Controller
public class ContactController {
	
	// private static final Logger logger =
	// LoggerFactory.getLogger(ContactController.class);
	
	@Autowired
	private ContactService contactService;
	
	@Autowired
	private MasterService masterService;
	
	/**
	 * Gets the all.
	 * 
	 * @param map
	 *            the map
	 * @param request
	 *            the request
	 * @return the all
	 */
	
	@RequestMapping(value = "/contact/getAll", method = RequestMethod.GET)
	public final void getAll(final ModelMap map, final HttpServletRequest request) throws Exception {
	
		String sql = "select trace_no, trace_cnt, opn_br_no, tx_br_no, ac_id, ac_seqn, tx_code, sub_tx_code, ln_tx_type, add_ind, ct_ind, tx_amt, bal, intst_acm, tx_date, tx_time, note_type, note_no, hst_cnt, brf, tel, chk, auth from ln_mst_hst100y";
		sql += " where rownum < 100";
		List<Map<String, Object>> results = this.contactService.selectBySql(sql);
		
		List<Master> masters = masterService.getMastersBySegname("LN_MST_HST");
		
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
		map.put("contacts", results);
	}
}
