package com.easymorse;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestDemo {

	private static final Logger logger = Logger.getLogger(TestDemo.class);

	@RequestMapping("/index.php")
	public String index(HttpServletRequest request, ModelMap modelMap) {
		logger.debug(">>>>>>>>>>执行到了首页");
		return "index";
	}

	
	@RequestMapping("/aboutus.php")
	public String aboutUs(HttpServletRequest request, ModelMap modelMap) {
		logger.debug(">>>>>>>>>>执行到了关于我们页面");
		return "aboutus";
	}

	@RequestMapping("/services.php")
	public String services(HttpServletRequest request, ModelMap modelMap) {
		logger.debug(">>>>>>>>>>执行到了服务页面");
		return "services";
	}

	@RequestMapping("/solutions.php")
	public String solutions(HttpServletRequest request, ModelMap modelMap) {
		logger.debug(">>>>>>>>>>执行到了解决方案页面");
		return "solutions";
	}

	@RequestMapping("/contacts.php")
	public String contacts(HttpServletRequest request, ModelMap modelMap) {
		logger.debug(">>>>>>>>>>执行到了联系我们页面");
		return "contacts";
	}


}
