package com.easymorse.admin;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import util.dao.Pagination;

import com.easymorse.TestDemo;
import com.easymorse.hotel.HotelBean;
import com.easymorse.hotel.HotelBeanDao;

@Controller
public class AdminUserController {

	@Autowired
	AdminUserDao adminUserDao;
	
	@Autowired
	HotelBeanDao hotelBeanDao;

	private static final Logger logger = Logger.getLogger(TestDemo.class);

	@RequestMapping("/webadmin/adminlogin.do")
	public String webAdmin(HttpServletRequest request, ModelMap modelMap) {
		logger.debug(">>>>>>>>>>执行到了后哦太管理");
		return "bgadmin/admin_login";
	}

	@RequestMapping("/webadmin/adminlogin_submit.do")
	public String adminLoginSubmit(HttpServletRequest request,
			ModelMap modelMap, AdminUser adminUser) {
		logger.debug(">>>>>>>>>>执行到了后哦太管理");
		AdminUser admin = null;
		if (null != adminUserDao.findByName(adminUser.getAdminUserName())) {
			admin = adminUserDao.findByName(adminUser
					.getAdminUserName());
			logger.debug("用户输入的用户名是 :>>>" + adminUser.getAdminUserName()
					+ "用户输入的 密码是" + adminUser.getAdminUserPassword());
			logger.debug("根据数据库查找到的amdin是" + admin.getAdminUserName()
					+ "查到的密码是" + admin.getAdminUserPassword());
			logger
					.debug("》》》》》》》》》》》》》" + admin.getAdminUserPassword() == adminUser
							.getAdminUserPassword());
		}

		if ((null != admin)
				&& (admin.getAdminUserPassword().equals(adminUser
						.getAdminUserPassword()))) {
			request.getSession().setAttribute("loginusername",
					adminUser.getAdminUserName());
			request.getSession().setAttribute("loginusertype", admin.getAdminType());
			request.getSession().setAttribute("loginuserid", admin.getId());
			return "bgadmin/index";
		} else {
			request.setAttribute("error", "用户名或密码错误");
			return "bgadmin/admin_login";
		}

	}

	@RequestMapping("/webadmin/updateadminuser.do")
	public String updateAdminUser(HttpServletRequest request, ModelMap modelMap) {
		logger.debug(">>>>>>>>>>执行到了后哦太管理");
		return "bgadmin/updateadminuser";
	}

	@RequestMapping("/webadmin/addadminuser.do")
	public String addAdminUser(HttpServletRequest request, ModelMap modelMap) {
		logger.debug(">>>>>>>>>>审核通过合作酒店"+hotelBeanDao.findNotCheckup(true));
		
		modelMap.put("hotellist", hotelBeanDao.findNotCheckup(true));
		return "bgadmin/addadminuser";
	}

	@RequestMapping("/webadmin/addusersumbit.do")
	@Transactional(propagation = Propagation.REQUIRED)
	public String addAdminUserSubmit(HttpServletRequest request,
			HttpServletResponse response, ModelMap modelMap,
			AdminUser adminUser, String registerTimes,String hotelBeanId) {
		logger.debug(">>>>>>>>>添加user");
		/**
		 * 解决了修改用户时，同时修改该用户的创建时间的问题
		 */
		HotelBean hotelBean = null;
		if(null != hotelBeanId){
			hotelBean = hotelBeanDao.findById(Long.valueOf(hotelBeanId));
			adminUser.setHotelBean(hotelBean);
		}
		if (null == request.getParameter("registerTimes")) {
			adminUser.setRegisterTime(new Date());
		} else {
			logger.debug("隐藏域得到的是时间是：" + request.getParameter("registerTimes"));
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			try {
//				adminUser.setRegisterTime(format.parse(request
//						.getParameter("registerTimes")));
				adminUser.setRegisterTime(new Date());
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}

		adminUserDao.saveOrUpdate(adminUser);
		int pageno = 0;
		if (null == request.getParameter("pageno")) {
			pageno = 0;
		} else {
			pageno = Integer.valueOf(request.getParameter("pageno"));
		}
		return "redirect:/webadmin/adminuserlist.do?pageno=" + pageno + "";

	}

	@RequestMapping("/webadmin/adminuserlist.do")
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public String adminUserList(HttpServletRequest request, ModelMap modelMap,
			AdminUser adminUser) {
		logger.debug(">>>>>>>>查找所有的usr");
		Pagination<AdminUser> pagination = new Pagination<AdminUser>();
		pagination.setSize(5);
		if (null != request.getParameter("pageno")) {
			pagination.setNo(Integer.valueOf(request.getParameter("pageno")));
		}
		adminUserDao.browse(pagination);
		modelMap.put("userlist", pagination.getResults());
		modelMap.put("pagination", pagination);
		logger.debug("pagination的属性： no" + pagination.getNo() + ">>recordsum"
				+ pagination.getRecordSum() + ">>>pages:"
				+ pagination.getPageSum());
		return "bgadmin/adminuserlist";
	}

	@RequestMapping("/webadmin/editadminuser.do")
	@Transactional(propagation = Propagation.REQUIRED)
	public String editAdminUser(HttpServletRequest request, ModelMap modelMap,
			AdminUser adminUser) {
		logger.debug(">>>>>>>>编辑user,user的id是：" + adminUser.getId());
		Pagination<AdminUser> pagination = new Pagination<AdminUser>();
		pagination.setSize(5);
		if (null != request.getParameter("pageno")) {
			pagination.setNo(Integer.valueOf(request.getParameter("pageno")));
		}
		adminUserDao.browse(pagination);
		modelMap.put("userlist", pagination.getResults());
		modelMap.put("pagination", pagination);
		modelMap.put("theuser", adminUserDao.findById(adminUser.getId()));
		request.setAttribute("thesign", "sign");
		return "bgadmin/adminuserlist";
	}
	
	
		@RequestMapping("/webadmin/deleteadminuser.do")
		@Transactional(propagation = Propagation.REQUIRED)
		public String deleteAdminUser(HttpServletRequest request, ModelMap modelMap,
				AdminUser adminUser) {
			logger.debug(">>>>>>>>编辑user,user的id是：" + adminUser.getId());
			if(null != request.getParameter("id") ){
				adminUserDao.delete(adminUserDao.findById(Long.valueOf(request.getParameter("id"))));
			}
			
			return "bgadmin/deleteusersuccess";
		}
}
