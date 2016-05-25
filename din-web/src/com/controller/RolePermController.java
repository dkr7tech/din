package com.controller;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
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
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) throws Exception {
	binder.registerCustomEditor(List.class, "permissionList", new CustomCollectionEditor(List.class) {

		@Override
		protected Object convertElement(Object element) {
			String value = String.valueOf(element);
			List<Permission> permList = new ArrayList<Permission>();
			Permission perm = new Permission();
			perm.setPermId(Integer.valueOf(value).intValue());
			permList.add(perm);
			return permList;
		}

	});

	

}

	@RequestMapping(value = "/rolepermadmin", method = RequestMethod.GET)
	public ModelAndView findRoles() {
		Role role = new Role();
		
		ModelAndView modelAndView = new ModelAndView("rolepermadmin");
		Map<Integer, String> rolesMap = RoleEnum.getRolesIdWithNameMap();
		Map<Integer, String> permMap = PermissionEnum.getPermIdWithNameMap();
		modelAndView.addObject("role", role);
		modelAndView.addObject("rolesMap", getRolls());
		modelAndView.addObject("availablePerm", permMap);
		
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
	
	
	private Role populateRole(int id){
		RoleEnum roleEnum=RoleEnum.getRoleEnumById(id);
		Role role=new Role();
		role.setName(roleEnum.getName().trim());
		role.setRoleId(roleEnum.getId());
		role.setDescription(roleEnum.getDesc().trim());
		role.setExternalName(roleEnum.getExternalName().trim());
		role.setStatus(roleEnum.getIsActive());
		return role;
	}
	private List<Role> getRolls(){
		List<Role> roles=new LinkedList<Role>();
	
		List<Role>  roleList=getRolePermService().getRoles();
		/*if(roleList!=null && roleList.size()>0){
			if(roleList.size()<RoleEnum.values().length){
				int num=RoleEnum.values().length-roleList.size();
				for(int i=RoleEnum.values().length; i>roleList.size(); i--){
					roles.add(populateRole(i));
				}
			}
		} else*/{
			for(RoleEnum roleEnum:RoleEnum.values()){
				if(roleEnum.getIsActive()==1){
				roles.add(populateRole(roleEnum.getId()));
				}
			}
		}
		
		return roles;
	}
	
	
	private Permission populatePerm(int id){
		PermissionEnum permEnum=PermissionEnum.getPermEnumById(id);
		Permission perm=new Permission();
		perm.setName(permEnum.getName().trim());
		perm.setPermId(permEnum.getId());
		perm.setDescription(permEnum.getDesc().trim());
		
		perm.setStatus(permEnum.getIsActive());
		return perm;
	}
	private List<Permission> getPermissons(){
		List<Permission> permissons=new LinkedList<Permission>();
		Map<Integer, String> permMap = PermissionEnum.getPermIdWithNameMap();
	
		
		List<Permission>  permList=getRolePermService().getAllSysPermissions();
		/*if(permList!=null && permList.size()>0){
			if(permList.size()<PermissionEnum.values().length){
				int num=PermissionEnum.values().length-permList.size();
				for(int i=PermissionEnum.values().length; i>permList.size(); i--){
					permissons.add(populatePerm(i));
				}
			}
		} else*/{
			for(PermissionEnum permEnum:PermissionEnum.values()){
				if(permEnum.getIsActive()==1){
					permissons.add(populatePerm(permEnum.getId()));
				}
			}
		}
		
		return permissons;
	}
	//@JsonView(View.Summary.class)
	@RequestMapping(value = "/roledata", method = RequestMethod.GET)
	public ModelAndView getRoleData(@RequestParam("roleId")  int roleId) {
		MappingJackson2JsonView view=new MappingJackson2JsonView();
		RolePerm rolePerm = new RolePerm();
		ModelAndView model = new ModelAndView(view);
		Role role=new Role();
		role.setRoleId(roleId);
		Role roleData=getRolePermService().getRole(role);
		if(roleData==null){
			roleData =populateRole(roleId);
		}
		rolePerm.setRole(roleData);
		view.setBeanName("role");
		
		
		List<List<Permission>> permList=getRolePermService().getRolePermAndAvailPerm(roleData);
		if(permList!=null && !permList.isEmpty()){
			model.addObject("availablePerm", permList.get(0));
			if(permList.size()>1){
			model.addObject("selectedperm", permList.get(1));
			}
		}
		model.addObject("rolePerm", rolePerm);
		
		return model;
	}
	
	@RequestMapping(value = "/permdata", method = RequestMethod.GET)
	public ModelAndView getPermData(@RequestParam("permId")  int permId) {
		MappingJackson2JsonView view=new MappingJackson2JsonView();
		ModelAndView model = new ModelAndView(view);
		getRolePermService().getAllSysPermissions();
		PermissionEnum permEnum=PermissionEnum.getPermEnumById(permId);
		Permission permission=new Permission();
		permission.setPermId(permEnum.getId());
		permission.setName(permEnum.getName());
		permission.setStatus(permEnum.getIsActive());
		
		permission.setDescription(permEnum.getDesc());
		model.addObject("permission",permission );
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
		RolePerm rolePerm=new RolePerm();
		Map<Integer,String> permMap=PermissionEnum.getPermIdWithNameMap();
		model.addObject("permMap", permMap);
		model.addObject("rolePerm", rolePerm);
		
		return model;
	}

	@RequestMapping(value = "/saveperm", method = RequestMethod.POST)
	public ModelAndView savePerm(@ModelAttribute RolePerm rolePerm) {
		getRolePermService().createPermission(rolePerm.getPermission());
		return new ModelAndView("redirect:/");
	}

	public RolePermService getRolePermService() {
		return rolePermService;
	}

}
