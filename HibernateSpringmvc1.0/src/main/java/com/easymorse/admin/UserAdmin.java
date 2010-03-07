package com.easymorse.admin;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.easymorse.TestDemo;

@Controller
public class UserAdmin {

	private static final Logger logger = Logger.getLogger(TestDemo.class);

	@RequestMapping("/webadmin.php")
	public String webAdmin(HttpServletRequest request, ModelMap modelMap) {
		logger.debug(">>>>>>>>>>执行到了后哦太管理");
		return "admin/login";
	}
}
