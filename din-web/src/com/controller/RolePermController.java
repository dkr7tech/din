package com.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.model.common.PermissionEnum;
import com.model.common.RoleEnum;
import com.model.user.Permission;
import com.model.user.Role;
import com.model.user.RolePerm;
import com.service.user.RolePermService;

@Controller
public class RolePermController {
	@Autowired
	private RolePermService rolePermService;

	@RequestMapping(value = "/rolesList", method = RequestMethod.GET)
	public ModelAndView findRoles() {
		Role role = new Role();
		RolePerm rolePerm = new RolePerm();
		ModelAndView modelAndView = new ModelAndView("rolesList");
		Map<Integer, String> rolesMap = RoleEnum.getRolesIdWithNameMap();
		modelAndView.addObject("rolePerm", rolePerm);
		modelAndView.addObject("rolesMap", rolesMap);
		return modelAndView;
	}

	@RequestMapping(value = "/roleperm", method = RequestMethod.GET)
	public ModelAndView findRolePerms(@RequestParam("roleId")  int roleId) {
		RolePerm rolePerm = new RolePerm();
		ModelAndView modelAndView = new ModelAndView("roleperm");
		Map<Integer, String> permMap = PermissionEnum.getPermIdWithNameMap();
		System.out.println("ddddddd"+roleId);
		modelAndView.addObject("rolePerm", rolePerm);
		modelAndView.addObject("availablepermMap", permMap);
		Map<Integer, String> rolesMap = RoleEnum.getRolesIdWithNameMap();
		modelAndView.addObject("selectpermMap", rolesMap);
		return modelAndView;
	}
	//@JsonView(View.Summary.class)
	@RequestMapping(value = "/roledata", method = RequestMethod.GET)
	public ModelAndView getRoleData(@RequestParam("roleId")  int roleId) {
		MappingJackson2JsonView view=new MappingJackson2JsonView();
		RoleEnum roleEnum = RoleEnum.getRoleEnumById(roleId);
		
		RolePerm rolePerm = new RolePerm();
		Role role = new Role();
		
		role.setName(roleEnum.getName());
		role.setRoleId(roleEnum.getId());
		role.setDescription(roleEnum.getDesc());
		role.setExternalName(roleEnum.getExternalName());
		role.setType("pub");
		rolePerm.setRole(role);
		view.setBeanName("role");
		ModelAndView model = new ModelAndView(view);
		Map<Integer, String> permMap = PermissionEnum.getPermIdWithNameMap();
		Map<Integer, String> rolemap =roleEnum.getRolesIdWithNameMap();
		model.addObject("availablePerm", permMap);
		model.addObject("selectedPerm", rolemap);
		model.addObject("rolePerm", rolePerm);
		
		return model;
	}

	@RequestMapping(value = "/createrole", method = RequestMethod.GET)
	public ModelAndView createRole() {
		ModelAndView model = new ModelAndView("rolesadmin");
		Map<Integer, RoleEnum> rolesMap = RoleEnum.getRolesEnumMap();

		// model.addObject("rolesMap", rolesMap);
		model.addObject("role", new Role());
		return model;
	}

	@RequestMapping(value = "/saverole", method = RequestMethod.POST)
	public ModelAndView saveRole(@ModelAttribute Role role) {
		int i = getRolePermService().createRole(role);
		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/createPerm", method = RequestMethod.GET)
	public ModelAndView createPermission() {
		ModelAndView model = new ModelAndView("permission");
		model.addObject("permission", new Permission());
		return model;
	}

	@RequestMapping(value = "/saveperm", method = RequestMethod.POST)
	public ModelAndView saveRole(@ModelAttribute Permission permission) {
		int i = getRolePermService().createPermission(permission);
		return new ModelAndView("redirect:/");
	}

	public RolePermService getRolePermService() {
		return rolePermService;
	}

}
