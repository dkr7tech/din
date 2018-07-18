package com.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.javers.core.Javers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.common.utils.ObjectUtility;
import com.common.utils.StringUtility;
import com.db.UserDAO;
import com.model.common.LoginSessionBean;
import com.model.common.RoleEnum;
import com.model.common.constant.CommonConstant;
import com.model.user.Role;
import com.model.user.User;
import com.service.auth.RolePermManager;
import com.service.user.UserService;
import com.web.utils.WebManagar;

/**
 * Handles requests for the application home page.
 */
@Controller
//@RequestMapping("/")
public class HomeController {

	@Autowired
	Javers javers;
	
	
	

	@InitBinder
	protected void initBinder(WebDataBinder binder) throws Exception {

		binder.registerCustomEditor(List.class, "roleList", new CustomCollectionEditor(List.class) {

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
	@RequestMapping(value="/resttemplate",method=RequestMethod.GET)
	public static void getEmployees()
	{
	    final String uri = "http://localhost:8080/din-web/resttest";
	     
	    RestTemplate restTemplate = new RestTemplate();
	    String result = restTemplate.getForObject(uri, String.class);
	     
	    System.out.println("result "+result);
	}

	@RequestMapping(value="/resttest",method=RequestMethod.GET,
    produces="application/json")
	public @ResponseBody List<String> handleRequest2() throws Exception {
		List<String> listUsers = new ArrayList<String>();
		listUsers.add("ddd");
		
		listUsers.add("abc");
		return listUsers;
	}
	
	@RequestMapping("/userlist.htm")
	public ModelAndView handleRequest() throws Exception {
		List<User> listUsers = userDao.list();
		ModelAndView model = new ModelAndView("UserList");
		model.addObject("userList", listUsers);
		return model;
	}

	@RequestMapping(value = "/new.htm", method = RequestMethod.GET)
	public ModelAndView newUser() {
		ModelAndView model = new ModelAndView("UserForm");
		RolePermManager roleManager = new RolePermManager();
		model.addObject("availableRoles", roleManager.getAllRoles());
		model.addObject("user", new User());
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
	public Map<Integer, String> getUserRole(List<Role> roleList,Map<Integer, String> allRolesMap){
		Map<Integer, String> map=new HashMap<Integer,String>();
		for(Role role:roleList){
			map.put(role.getRoleId(), RoleEnum.getRoleEnumById(role.getRoleId()).getName());
			allRolesMap.remove(role.getRoleId());
		}
		return map;
		
	}
	

	@RequestMapping(value = "/edit.htm", method = RequestMethod.GET)
	public ModelAndView editUser(HttpServletRequest request) {
		int userId = Integer.parseInt(request.getParameter("id"));
		User user = userDao.get(userId);
		Map<Integer, String> allRolesMap =RoleEnum.getRolesIdWithNameMap();
		ModelAndView model = new ModelAndView("UserForm");
		model.addObject("availableRoles", allRolesMap);
		model.addObject("selectedRoles", getUserRole(user.getRoleList(),allRolesMap));
		model.addObject("user", user);
		return model;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView userLoginPage(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("logon");
		//AuditManagar audit=new AuditManagar(javers);
		//audit.listPrperties();
		//WebManagar.setApplicationProperties(request.getServletContext());
		model.addObject("user", new User());
		return model;		
	}
	
	@RequestMapping(value = "/delete.htm", method = RequestMethod.POST)
	public ModelAndView delete(@ModelAttribute User User) {

		System.out.println("Inside save user first name" + User.getFirstName());
		User newUser = userService.deleteUser(User);
		
		/*
		 * if(newUser.getUserId()>0){
		 * 
		 * }
		 */
		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/save.htm", method = RequestMethod.POST)
	public ModelAndView saveUser(@ModelAttribute User User) {

		System.out.println("Inside save user first name" + User.getFirstName());
		User newUser = userService.createUser(User);
		System.out.println("user :" + newUser.getUserId());
		/*
		 * if(newUser.getUserId()>0){
		 * 
		 * }
		 */
		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/aui.htm")
	public ModelAndView angular() {
		System.out.println("Inside angular " );
		
		return  new ModelAndView("aui");
	}
	@RequestMapping(value = "/home.htm", method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute User user, HttpServletRequest request) {
		String target = "redirect:/";
		String username=getPrincipal();
		
		if (!StringUtility.isEmpty(user.getLogin()) && !StringUtility.isEmpty(user.getPassword())) {
			User loggedInUser = userService.getUser(user);
			if (ObjectUtility.isNotNull(loggedInUser)) {
				HttpSession session = WebManagar.generateNewSessionId(request);
				LoginSessionBean loginSessionBean = new LoginSessionBean();
				loginSessionBean.setUser(loggedInUser);
				session.setAttribute(CommonConstant.USER_SESSION, loginSessionBean);
				target = "redirect:/userlist.htm";
			}
		}
		return new ModelAndView(target);
	}
	private String getPrincipal(){
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails)principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
	}
}
