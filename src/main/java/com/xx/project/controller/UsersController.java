package com.xx.project.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.xx.project.entity.Users;
import com.xx.project.service.UsersService;

@Controller
@RequestMapping("/users")
public class UsersController{
	
	private static final Logger logger = LoggerFactory.getLogger(UsersController.class);
	
//	@Autowired
//	 private UsersService userSerivce;
	
	@RequestMapping("/list")
	@ResponseBody
	public String list(HttpServletRequest request, @ModelAttribute("users") Users users, ModelMap model) {
		logger.trace("/platform/users  ====>  list");
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		return JSON.toJSONString(list);
	}

}
