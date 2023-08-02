package com.mr.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String home()
	{
			return "loginManager";
	}
	@RequestMapping(path ="/processLogin",method=RequestMethod.POST)
	public String processLogin(HttpServletRequest request)
	{
			String email = request.getParameter("email");
			String password=request.getParameter("password");
			if(email.equals("admin@gmail.com")&&password.equals("admin"))
			{
				return "dashboard";
			}else{
				return "loginManager";
			}
	}
}
