package com.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.common.utils.ObjectUtility;
import com.common.utils.StringUtility;
import com.db.UserDAO;
import com.model.common.LoginSessionBean;
import com.model.common.RoleEnum;
import com.model.common.constant.CommonConstant;
import com.model.user.Role;
import com.model.user.User;
import com.model.user.UserRole;
import com.service.auth.RolePermManager;
import com.service.user.UserService;
import com.web.utils.WebManagar;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@InitBinder
	protected void initBinder(WebDataBinder binder) throws Exception {

		binder.registerCustomEditor(List.class, "user.roleList", new CustomCollectionEditor(List.class) {

			@Override
			protected Object convertElement(Object element) {
				String value = String.valueOf(element);
				List<Role> roleList = new ArrayList();
				Role role = new Role();
				role.setRoleId(Integer.valueOf(value).intValue());
				roleList.add(role);
				return roleList;
			}

		});

		/*
		 * binder.registerCustomEditor(Map.class,new CustomMapEditor(Map.class){
		 * 
		 * @Override protected Object convertKey(Object key) { String
		 * keyValue=String.valueOf(key); System.out.println("key value "
		 * +keyValue); return keyValue; }
		 * 
		 * @Override protected Object convertValue(Object value) { Integer
		 * integer=Integer.valueOf(String.valueOf(value)); System.out.println(
		 * "key value "+integer.intValue()); return integer; }
		 * 
		 * 
		 * });
		 */

	}

	@Autowired
	private UserDAO userDao;
	@Autowired
	private UserService userService;

	// @Audit("welcome")
	@RequestMapping("/userlist")
	public ModelAndView handleRequest() throws Exception {
		List<User> listUsers = userDao.list();
		ModelAndView model = new ModelAndView("UserList");
		model.addObject("userList", listUsers);
		return model;
	}

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public ModelAndView newUser() {
		ModelAndView model = new ModelAndView("UserForm");
		RolePermManager roleManager = new RolePermManager();
		model.addObject("availableRoles", roleManager.getAllRoles());
		model.addObject("userrole", new UserRole());
		return model;
	}

	private List<Role> getRoleList(Map<Integer, String> map) {
		List<Role> roleList = new ArrayList<Role>();
		Set<Map.Entry<Integer, String>> entrySet = map.entrySet();
		for (Entry<Integer, String> entry : entrySet) {
			Role role = new Role();
			role.setRoleId(entry.getKey());
			role.setName(entry.getValue());
			roleList.add(role);
		}
		return roleList;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView editUser(HttpServletRequest request) {
		int userId = Integer.parseInt(request.getParameter("id"));
		User user = userDao.get(userId);
		UserRole userrole = new UserRole();
		userrole.setUser(user);

		ModelAndView model = new ModelAndView("UserForm");
		List<Role> roleList = getRoleList(RoleEnum.getRolesIdWithNameMap());
		model.addObject("availableRoles", roleList);
		model.addObject("selectedRoles", roleList);
		model.addObject("userrole", userrole);
		return model;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView userLoginPage() {
		ModelAndView model = new ModelAndView("logon");
		model.addObject("user", new User());
		return model;
		/*
		 * int userId = Integer.parseInt(request.getParameter("id"));
		 * userDao.delete(userId); return new ModelAndView("redirect:/");
		 */
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveUser(@ModelAttribute UserRole UserRole) {

		System.out.println("dd" + UserRole.getUser().getRoleList().size());
		User newUser = userService.createUser(UserRole.getUser());
		System.out.println("user :" + newUser.getUserId());
		/*
		 * if(newUser.getUserId()>0){
		 * 
		 * }
		 */
		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/home", method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute User user, HttpServletRequest request) {
		String target = "redirect:/";
		if (!StringUtility.isEmpty(user.getLogin()) && !StringUtility.isEmpty(user.getPassword())) {
			User loggedInUser = userService.getUser(user);
			if (ObjectUtility.isNotNull(loggedInUser)) {
				HttpSession session = WebManagar.generateNewSessionId(request);
				LoginSessionBean loginSessionBean = new LoginSessionBean();
				loginSessionBean.setUser(loggedInUser);
				session.setAttribute(CommonConstant.USER_SESSION, loginSessionBean);
				target = "redirect:/userlist";
			}
		}
		return new ModelAndView(target);
	}

}
