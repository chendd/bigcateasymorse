package com.easymorse.room;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.easymorse.TestDemo;
import com.easymorse.hotel.HotelBeanDao;
import com.easymorse.order.OrderItem;
import com.easymorse.order.OrderItemDao;
import com.easymorse.user.UserBean;
import com.easymorse.user.UserBeanDao;

@Controller
public class HotelRoomController {

	private static final Logger logger = Logger.getLogger(TestDemo.class);

	@Autowired
	HotelRoomDao hotelRoomDao;

	@Autowired
	HotelBeanDao hotelBeanDao;

	@Autowired
	OrderItemDao orderItemDao;

	@Autowired
	UserBeanDao userBeanDao;
	
	@RequestMapping("/hotel/managerroom.do")
	@Transactional(propagation = Propagation.REQUIRED)
	public String managerRoom(HttpServletRequest request, ModelMap modelMap) {
		logger.debug(">>>>>>>>>>managerroom.do");
		modelMap.put("roomlist", hotelRoomDao.findAll());
		return "hotel/roomlist";
	}

	@RequestMapping("/webadmin/deleteroom.do")
	@Transactional(propagation = Propagation.REQUIRED)
	public String deleteRoom(HttpServletRequest request, ModelMap modelMap) {
		logger.debug(">>>>>>>>>>managerroom.do");
		if (null != hotelRoomDao.findById(Long.valueOf(request
				.getParameter("id")))) {
			hotelRoomDao.delete(hotelRoomDao.findById(Long.valueOf(request
					.getParameter("id"))));
		}

		return "hotel/deleteroomsuccess";
	}

	@RequestMapping("/webadmin/addroom.do")
	@Transactional(propagation = Propagation.REQUIRED)
	public String addRoom(HttpServletRequest request, HotelRoom hotelRoom,
			String hotelId, ModelMap modelMap) {

		if (null != hotelId) {
			hotelRoom
					.setHotelBean(hotelBeanDao.findById(Long.valueOf(hotelId)));
		}

		hotelRoomDao.create(hotelRoom);

		return "hotel/addroomsuccess";
	}

	@RequestMapping("/hotel/addroomsubmit.do")
	@Transactional(propagation = Propagation.REQUIRED)
	public String addRoomSubmit(HttpServletRequest request,
			HotelRoom hotelRoom, ModelMap modelMap) {

		hotelRoomDao.saveOrUpdate(hotelRoom);

		return "hotel/roomlist";
	}

	@RequestMapping("/bookhotel.do")
	@Transactional(propagation = Propagation.REQUIRED)
	public String bookHotel(HttpServletRequest request, ModelMap modelMap) {
		Long id = Long.valueOf(request.getParameter("id"));
		request.setAttribute("theHotel", hotelBeanDao.findById(id));
		modelMap
				.put("hotels", hotelRoomDao.findRoom(hotelBeanDao.findById(id)));
		return "hotel/bookhotelpage";
	}

	@RequestMapping("/book_submit.do")
	@Transactional(propagation = Propagation.REQUIRED)
	public String bookHotelSubmit(HttpServletRequest request, ModelMap modelMap) {
		if (null != request.getSession().getAttribute("islogined")) {

			Long id = Long.valueOf(request.getParameter("id"));
			request.setAttribute("rooms", hotelRoomDao.findById(id));

			return "hotel/booktable";
		} else {
			return "redirect:login.do";
		}

	}

	@RequestMapping("/book_submit_confirm.do")
	@Transactional(propagation = Propagation.REQUIRED)
	public String bookHotelSubmitConfirm(HttpServletRequest request,
			ModelMap modelMap, OrderItem orderItem, String roomId) {

		if(null != roomId){
			orderItem.setHotelRoom(hotelRoomDao.findById(Long.valueOf(roomId)));
		}
		if(null != request.getSession().getAttribute("the_user")){
			UserBean user  =userBeanDao.findByAlise((String)request.getSession().getAttribute("the_user"));
			orderItem.setUserBean(user);
		}
		
		orderItemDao.create(orderItem);
		return "hotel/hotelbooksuccess";

	}
	

	@RequestMapping("/ibooks.do")
	@Transactional(propagation = Propagation.REQUIRED)
	public String books(HttpServletRequest request,
			ModelMap modelMap, OrderItem orderItem, String roomId) {
		modelMap.put("hotellist", hotelBeanDao.findNotCheckup(true));
		return "hotel/bookhotellist";

	}
}
