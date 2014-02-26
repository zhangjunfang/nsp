/**
 * 
 */
package com.hnrisen.auditworks.tree.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hnrisen.auditworks.domain.tree.Tree;
import com.hnrisen.auditworks.service.tree.TreeCUDService;
import com.hnrisen.auditworks.service.tree.TreeService;

/**
 * @author ： ocean date ：2012-4-20
 */
@Controller
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class TreeController implements Serializable {
	
	private Log log = LogFactory.getLog(getClass());
	
	private static final long serialVersionUID = 8566732447804442376L;
	
	private final List<Tree> list = new ArrayList<Tree>(24);
	
	@Resource(name = "treeServiceImpl")
	private TreeService<Tree> treeService;
	
	@Resource(name = "treeCUDServiceImpl")
	private TreeCUDService<Tree> treeCUDService;  
	
	@RequestMapping(value = "tree", method = RequestMethod.POST)
	public @ResponseBody
	Tree [] getTreeList() {
	
		// public @ResponseBody String getTreeList() throws
		// JsonGenerationException, JsonMappingException, IOException {
		log.info("展示节点数据");
		
		String jsonKey[] = new String[]{
				"id", "pId", "name"
		};
		
		String columnName[] = new String[]{
				"DEPARTMENT_ID", "PARENT_ID", "DEPARTMENT_NAME"
		};
		
		// return testBasicSettings();
		return treeService.getTreeData(jsonKey, columnName);
		// return getTreeData();
		
	}
	
	@RequestMapping(value = "/tree/addNode", method = RequestMethod.POST)
	// public String addTree(/*@Valid*/ Tree tree) {
	// public ModelAndView addTree(/*@Valid*/ Tree tree,ModelMap map) {
	public String addTree(/* @Valid */Tree tree, ModelMap map, BindingResult result) {
		
		log.info(tree);
		
		map.put("addSucess", "添加节点成功");
		treeCUDService.insertTree(tree);
		log.info("添加节点成功");
		return dynamicControl(result, "/tree/addNode", "/tree/addNode");
		// return dynamicControl(result, "/main", "/tree/addNode");
		// return new ModelAndView("main");
		
		// return "/main";
		
		// return "forward:/main.htm";
		
	}
	
	@RequestMapping(value = "addShowTree", method = RequestMethod.GET)
	public String addShowTree(ModelMap model) {
	
		model.addAttribute("tree", new Tree());
		
		log.info("转向添加节点页面");
		
		return "/tree/addNode";
		
	}
	
	@RequestMapping(value = "/tree/updateNode", method = RequestMethod.POST)
	// public String updateTree(/*@Valid*/ Tree tree) {
	// public void updateTree(/*@Valid*/ Tree tree, ModelMap map, BindingResult
	// result) {
	public String updateTree(/* @Valid */Tree tree, ModelMap map, BindingResult result) {
	
		log.info(tree);
		map.put("updateSucess", "更新节点成功");
		
		treeCUDService.updateTree(tree);
		
		log.info("更新节点成功");
		return dynamicControl(result, "/tree/updateNode", "/tree/updateNode");
		// return "redirect:/main.htm";
		
		// return "forward:/main.htm";
		
	}
	
	@RequestMapping(value = "updateShowTree", method = RequestMethod.GET)
	public String updateShowTree(ModelMap model) {
	
		model.addAttribute("tree", new Tree());
		
		log.info("转向更新节点页面");
		
		return "/tree/updateNode";
		
	}
	
	@RequestMapping(value = "/tree/deleteNode", method = RequestMethod.POST)
	// public String deleteTree(/*@Valid*/ Tree tree) {
	// public void deleteTree(/*@Valid*/ Tree tree, ModelMap map, BindingResult
	// result) {
	public String deleteTree(/* @Valid */Tree tree, ModelMap map, BindingResult result) {
	
		list.remove(tree);
		
		log.info(tree);
		map.put("deleteSucess", "删除节点成功");
		treeCUDService.deleteTree(tree);
		
		log.info("删除节点成功");
		return dynamicControl(result, "/tree/deleteNode", "/tree/deleteNode");
		// return "redirect:/main.htm";
		
		// return "forward:/main.htm";
		
	}
	
	@RequestMapping(value = "deleteShowTree", method = RequestMethod.GET)
	public String deleteShowTree(ModelMap model) {
	
		model.addAttribute("tree", new Tree());
		
		log.info("转向删除节点页面");
		
		return "/tree/deleteNode";
		
	}
	
	private String dynamicControl(BindingResult result, String sucess, String fail) {
	
		if (result.hasErrors()) {
			log.info("转向失败页面");
			return fail;
		} else {
			
			log.info("转向成功页面");
			return sucess;
		}
		
	}
	

	
}
