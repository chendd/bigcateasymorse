package com.easymorse.hotel;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.easymorse.TestDemo;
import com.easymorse.admin.AdminUserDao;

@Controller
public class HotelController {

	private static final Logger logger = Logger.getLogger(TestDemo.class);

	@Autowired
	HotelBeanDao hotelBeanDao;

	@Autowired
	AdminUserDao adminUserDao;

	@RequestMapping("/hoteljoin.do")
	public String hotelJoin(HttpServletRequest request, ModelMap modelMap) {
		logger.debug(">>>>>>>>>>执行到了后哦太管理");
		return "hotel/hoteljoin";
	}

	@RequestMapping("/hoteljoin_submit.do")
	@Transactional(propagation = Propagation.REQUIRED)
	public String hotelJoinSubmit(HttpServletRequest request,
			ModelMap modelMap, HotelBean hotelBean) {
		hotelBean.setCheckUp(false);
		hotelBean.setApplyTime(new Date());
		hotelBeanDao.saveOrUpdate(hotelBean);
		request.setAttribute("joinname", hotelBean.getHotelName());
		return "hotel/hoteljoinsuccess";
	}

	@RequestMapping("/hotel/managerhotel.do")
	@Transactional(propagation = Propagation.REQUIRED)
	public String hotelManager(HttpServletRequest request, ModelMap modelMap,
			HotelBean hotelBean) {
		logger.debug(">>>>>>>>>>>>>>" + request.getParameter("hotel_name"));
		Long s = (Long)request      
		.getSession().getAttribute("loginuserid");
		
		List<HotelBean> hotel = null;
		if("超级管理员".equals(request.getSession().getAttribute("loginusertype"))){
			hotel = hotelBeanDao.findAll();
			 modelMap.put("hotelMsgDetails", hotel);
		}else{
			HotelBean hotels = adminUserDao.findById(s).getHotelBean();
			
			request.setAttribute("hotelMsgDetails1",hotels);
		}
		 
		return "hotel/hotelmanager_detailmsg";
	}

	@RequestMapping("/hotelnametest.do")
	public void hotelNameTest(HttpServletRequest request, ModelMap modelMap,
			HotelBean hotelBean) {
		logger.debug(">>>>>>>>>>>>>>" + request.getParameter("hotel_name"));
	}

	@RequestMapping("/hotel/checkup.do")
	public String hotelCheckUp(HttpServletRequest request, ModelMap modelMap,
			HotelBean hotelBean) {
		logger.debug(">>>>>>>>>>>>>为通过审核的酒店数目是：>"
				+ hotelBeanDao.findNotCheckup(false).size());

		modelMap.put("applyhotels", hotelBeanDao.findNotCheckup(false));
		return "hotel/applylist";
	}

	@RequestMapping("/webadmin/hoteldetailmsg.do")
	public String detailMsg(HttpServletRequest request, ModelMap modelMap,
			HotelBean hotelBean, String id) {

		logger.debug("---------------id的值是：" + id);
		HotelBean ho = hotelBeanDao.findById(Long.valueOf(id));
		// modelMap.put("applyhotels", hotelBeanDao.findNotCheckup());
		request.setAttribute("hotelMsgDetail", ho);
		return "hotel/detailmsg";
	}

	@RequestMapping("/webadmin/updatehotel.do")
	@Transactional(propagation = Propagation.REQUIRED)
	public String updateHotel(HttpServletRequest request, ModelMap modelMap,
			HotelBean hotelBean, String checkup) {

		logger.debug("---------------checkup,表示是否审核通过，值是：" + checkup);
		HotelBean ho = hotelBeanDao.findById(Long.valueOf(request
				.getParameter("id")));
		if (null != ho) {
			if ("true".equals(checkup)) {
				ho.setCheckUp(true);
			} else {
				ho.setCheckUp(false);
			}

		}
		hotelBeanDao.saveOrUpdate(ho);

		return "hotel/applylist";
	}

	@RequestMapping("/webadmin/updatehotels.do")
	@Transactional(propagation = Propagation.REQUIRED)
	public String updateHotels(HttpServletRequest request, ModelMap modelMap,
			HotelBean hotelBean, String checkup) {

		
	//	HotelBean ho = hotelBeanDao.findById(Long.valueOf(request
	//			.getParameter("id")));
		

		hotelBean.setApplyTime(new Date());
		hotelBeanDao.saveOrUpdate(hotelBean);

		return "hotel/updatesuccess";
	}
}
