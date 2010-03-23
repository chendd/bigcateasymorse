package com.easymorse.user;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.easymorse.TestDemo;

@Controller
public class UserController {

	private static final Logger logger = Logger.getLogger(TestDemo.class);
	
	@Autowired
	UserBeanDao userBeanDao;

	@RequestMapping("/register.do")
	public String webAdmin(HttpServletRequest request, ModelMap modelMap) {
		logger.debug(">>>>>>>>>>执行到了后哦太管理");
		return "admin/register";
	}

	@RequestMapping("/register_submit.do")
	@Transactional(propagation = Propagation.REQUIRED)
	public String registerSubmit(HttpServletRequest request, ModelMap modelMap,UserBean userBean) {
		logger.debug(">>>>>>>>>>执行到了后哦太管理");
//		UserBean user = new UserBean();
//		user.setAlias("ddd");
		userBeanDao.saveOrUpdate(userBean);
		request.getSession().setAttribute("the_user",userBean.getAlias() );
		return "redirect:index.do";
	}
	

	@RequestMapping("/exit.do")
	@Transactional(propagation = Propagation.REQUIRED)
	public String exitWeb(HttpServletRequest request, ModelMap modelMap) {
		logger.debug(">>>>>>>>>>执行到了后哦太管理");
		request.getSession().setAttribute("the_user",null );
		return "redirect:index.do";
	}
	
	@RequestMapping("/login.do")
	@Transactional(propagation = Propagation.REQUIRED)
	public String loginWeb(HttpServletRequest request, ModelMap modelMap) {
		logger.debug(">>>>>>>>>>执行到了后哦太管理");
		return "admin/login";
	}
	
	@RequestMapping("/login_submit.do")
	@Transactional(propagation = Propagation.SUPPORTS)
	public String loginSubmint(HttpServletRequest request, ModelMap modelMap,UserBean userBean) {
		logger.debug(">>>>>>>>>>执行到了后哦太管理");
		if(null != userBeanDao.findByAlise(userBean.getAlias())){
			request.getSession().setAttribute("the_user",userBeanDao.findByAlise(userBean.getAlias()).getAlias());
			request.getSession().setAttribute("islogined", "yes");
			return "index";
		}else{
			return "redirect:login.do";
		}
		
	}
	
}
