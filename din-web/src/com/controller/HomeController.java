package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.common.utils.StringUtility;
import com.db.UserDAO;
import com.model.common.LoginSessionBean;
import com.model.common.constant.CommonConstant;
import com.model.user.User;
import com.service.user.UserService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

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
		model.addObject("user", new User());
		return model;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView editUser(HttpServletRequest request) {
		int userId = Integer.parseInt(request.getParameter("id"));
		User user = userDao.get(userId);
		ModelAndView model = new ModelAndView("UserForm");
		model.addObject("user", user);
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
	public ModelAndView saveUser(@ModelAttribute User user) {
		User newUser = userService.createUser(user);
		/*
		 * if(newUser.getUserId()>0){
		 * 
		 * }
		 */
		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/home", method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute User user, HttpSession session) {
		/*
		 * RoleEnum re=RoleEnum.valueOf("RoleEnum"); re.RoleEnum_1.name();
		 */
		String target="/";
		if(!StringUtility.isEmpty(user.getLogin()) && !StringUtility.isEmpty(user.getPassword()))
		{
		User loggedInUser = userService.getUser(user);
		boolean bool = userService.validateUser(user);
		LoginSessionBean loginSessionBean = new LoginSessionBean();
		loginSessionBean.setUser(loggedInUser);
		session.setAttribute(CommonConstant.USER_SESSION, loginSessionBean);
		target="redirect:/userlist";
		}

		return new ModelAndView(target);
	}

}
