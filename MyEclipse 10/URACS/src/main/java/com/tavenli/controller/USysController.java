package com.tavenli.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tavenli.entity.MenuEntity;
import com.tavenli.entity.RoleEntity;
import com.tavenli.entity.UserEntity;
import com.tavenli.model.PageData;
import com.tavenli.model.UserInfo;
import com.tavenli.security.WebUserDetails;
import com.tavenli.services.UCenterService;
import com.tavenli.utils.PageNavUtil;


@Controller
@RequestMapping("/u")
public class USysController extends UBaseController {

	
	@Autowired
	private UCenterService uCenterService;	

	
	@RequestMapping("/users")
	public String userList(Model model,Integer page,String userName) {
		
		page = page== null ? 1 : page<1 ? 1 : page;
		
		int pageSize = 10;
		
		PageData<UserEntity> pageData = this.uCenterService.getUsers(page, pageSize, userName);
		
		model.addAttribute("dataList", pageData.getPageData());
		model.addAttribute("totalCount", pageData.getTotalCount());
		model.addAttribute("totalPage", pageData.getTotalPage());
		model.addAttribute("currentPage", page);
		model.addAttribute("pageNav", PageNavUtil.getPageNavHtml(page.intValue(), pageSize, pageData.getTotalCount(), 15));
		
		return "ucenter/sys/userList";
	}
	
	@RequestMapping("/userAdd")
	public String userAdd(Model model,UserEntity userEntity) {
		userEntity.setStatus(1);
		model.addAttribute("userEntity", userEntity);
		return "ucenter/sys/userEdit";
	}
	
	@RequestMapping("/userEdit")
	public String userEdit(Model model,int id) {
		
		UserEntity userEntity = this.uCenterService.getUser(id);
		model.addAttribute("userEntity", userEntity);
		return "ucenter/sys/userEdit";
	}
	
	@RequestMapping("/changePwd")
	public String changePwd(Model model) {
		WebUserDetails userInfo = this.getUserInfo();
		int userId = userInfo.getUserId();
		
		UserEntity userEntity = this.uCenterService.getUser(userId);
		model.addAttribute("userEntity", userEntity);
		return "ucenter/sys/pwdEdit";
	}
	
	@RequestMapping("/roles")
	public String roleList(Model model, Integer page,String roleName) {
		
		page = page== null ? 1 : page<1 ? 1 : page;
		int pageSize = 10;
		PageData<RoleEntity> pageData = this.uCenterService.getRoles(page, pageSize, roleName);
		
		model.addAttribute("dataList", pageData.getPageData());
		model.addAttribute("totalCount", pageData.getTotalCount());
		model.addAttribute("totalPage", pageData.getTotalPage());
		model.addAttribute("currentPage", page);
		model.addAttribute("pageNav", PageNavUtil.getPageNavHtml(page.intValue(), 10, pageData.getTotalCount(), 15));
		
		return "ucenter/sys/roleList";
	}
	
	@RequestMapping("/roleAdd")
	public String roleAdd(Model model,RoleEntity roleEntity) {
		roleEntity.setStatus(1);
		model.addAttribute("roleEntity", roleEntity);
		return "ucenter/sys/roleEdit";
	}
	
	@RequestMapping("/roleEdit")
	public String roleEdit(Model model,int id) {
		
		RoleEntity roleEntity = this.uCenterService.getRole(id);
		model.addAttribute("roleEntity", roleEntity);
		return "ucenter/sys/roleEdit";
	}
	
	@RequestMapping("/menus")
	public String menuList(Model model, Integer page,String menuName) {
		
		page = page== null ? 1 : page<1 ? 1 : page;
		int pageSize = 10;
		PageData<MenuEntity> pageData = this.uCenterService.getMenus(page, pageSize, menuName);
		
		model.addAttribute("dataList", pageData.getPageData());
		model.addAttribute("totalCount", pageData.getTotalCount());
		model.addAttribute("totalPage", pageData.getTotalPage());
		model.addAttribute("currentPage", page);
		model.addAttribute("pageNav", PageNavUtil.getPageNavHtml(page.intValue(), 10, pageData.getTotalCount(), 15));
		
		return "ucenter/sys/menuList";
	}
	
	@RequestMapping("/menuAdd")
	public String menuAdd(Model model,MenuEntity menuEntity) {
		menuEntity.setNavMenu(1);
		
		List<MenuEntity> parentMenus = this.uCenterService.getChildMenus(0);
		MenuEntity rootMenu = new MenuEntity();
		rootMenu.setId(0);
		rootMenu.setMenuName("--顶级菜单--");
		parentMenus.add(0, rootMenu);
		
		model.addAttribute("menuEntity", menuEntity);
		model.addAttribute("parentMenus", parentMenus);
		
		return "ucenter/sys/menuEdit";
	}
	
	@RequestMapping("/menuEdit")
	public String menuEdit(Model model,int id) {
		
		MenuEntity menuEntity = this.uCenterService.getMenu(id);
		
		List<MenuEntity> parentMenus = this.uCenterService.getChildMenus(0);
		MenuEntity rootMenu = new MenuEntity();
		rootMenu.setId(0);
		rootMenu.setMenuName("--顶级菜单--");
		parentMenus.add(0, rootMenu);
		
		model.addAttribute("menuEntity", menuEntity);
		model.addAttribute("parentMenus", parentMenus);
		
		return "ucenter/sys/menuEdit";
	}
	
	@RequestMapping("/userRoleSet")
	public String userRoleSet(Model model,int userId) {
		//取用户
		UserEntity userEntity = this.uCenterService.getUser(userId);
		//取所有角色
		List<RoleEntity> allRoles = this.uCenterService.getAvailableRoles();

		UserInfo userInfo = new UserInfo();
		userInfo.setId(userEntity.getId());
		userInfo.setUserName(userEntity.getUserName());
		for (RoleEntity roleEntity : userEntity.getRoles()) {
			userInfo.getRoles().add(roleEntity.getId());
		}
		
		model.addAttribute("allRoles", allRoles);
		model.addAttribute("userInfo", userInfo);
		
		return "ucenter/sys/userRoleSet";
	}
	
	@RequestMapping("/roleResourceSet")
	public String roleResourceSet(Model model,int roleId) {
		
		RoleEntity roleEntity = this.uCenterService.getRole(roleId);
		
		Set<MenuEntity> menus = roleEntity.getMenus();
		List<Integer> menuIds = new ArrayList<Integer>();
		for (MenuEntity menu : menus) {
			menuIds.add(menu.getId());
		}
		
		model.addAttribute("roleEntity", roleEntity);
		model.addAttribute("menuIds", StringUtils.join(menuIds,","));
		
		return "ucenter/sys/roleResourceSet";
	}
	

	
}