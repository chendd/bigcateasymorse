package com.easymorse;

import java.text.MessageFormat;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.easymorse.room.HotelRoomDao;

@Controller
public class TestDemo {

	private static final Logger logger = Logger.getLogger(TestDemo.class);

	@Autowired
	HotelRoomDao hotelRoomDao;
	
	@RequestMapping("/index.do")
	public String index(HttpServletRequest request, ModelMap modelMap) {
		logger.debug(">>>>>>>>>>执行到了首页");
		
	modelMap.put("room", hotelRoomDao.findAll());
		return "index";
		
	}
	@RequestMapping("/liansuo.do")
	public String liansuo(HttpServletRequest request, ModelMap modelMap) {
		logger.debug(">>>>>>>>>>执行到了首页");
		
	modelMap.put("room", hotelRoomDao.findAll());
		return "liansuo/liansuo";
		
	}
	

}
