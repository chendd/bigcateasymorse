package com.easymorse.criticism;

import java.io.UnsupportedEncodingException;
import java.util.Date;

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

@Controller
public class CriticismController {

	@Autowired
	CriticismBeanDao criticismBeanDao;

	@Autowired
	HotelBeanDao hotelBeanDao;

	private static final Logger logger = Logger.getLogger(TestDemo.class);

	@RequestMapping("/criticism.do")
	@Transactional(propagation = Propagation.REQUIRED)
	public String webAdmin(HttpServletRequest request, ModelMap modelMap) {
		modelMap.put("hotellist", hotelBeanDao.findNotCheckup(true));
		return "criticism/criticismlist";
	}

	@RequestMapping("/addcriticism.do")
	public String addC(HttpServletRequest request, ModelMap modelMap, String id) {
		

		if (1==0) {
			return "redirect:login.do";
		} else {
			if (null != id && !"".equals(id)) {
				if (null != hotelBeanDao.findById(Long.valueOf(id))) {
					request.setAttribute("hotels", hotelBeanDao.findById(Long
							.valueOf(id)));
					modelMap.put("criticismlist", criticismBeanDao
							.findListById(hotelBeanDao.findById(Long.valueOf(id))));
					
					logger.debug("hotels是》》》》》》》》》》》。"+hotelBeanDao.findById(Long
							.valueOf(id)));
				}

			}else if(null !=modelMap.get("signId")){
				logger.debug(">>>>>>>>>>>>执行到了signid的情况,z这个时候的id是"+modelMap.get("signId"));
				if (null != hotelBeanDao.findById((Long)(modelMap.get("signId")))) {
					request.setAttribute("hotels", hotelBeanDao.findById((Long)(modelMap.get("signId"))));
					modelMap.put("criticismlist", criticismBeanDao
							.findListById(hotelBeanDao.findById((Long)(modelMap.get("signId")))));
					logger.debug(">>>>>>>>>>>>执行到了signid的情况, 并且hotel是"+hotelBeanDao.findById((Long)(modelMap.get("signId"))));
				}
			}
			
			return "criticism/addcriticism";
		}

	}
	
	
		
		@RequestMapping("/criticism_submit.do")
		@Transactional(propagation = Propagation.REQUIRED)
		public String criticismSumbit(HttpServletRequest request, ModelMap modelMap, String id,CriticismBean criticismBean) {
			if(null != id && !"".equals(id)){
				
				if(null != hotelBeanDao.findById(Long.valueOf(id))){
					criticismBean.setHotelBean(hotelBeanDao.findById(Long.valueOf(id)));
				}
					criticismBean.setCriticismTime(new Date());
					logger.debug("评论的信息:>>>>>>>>>>>>"+criticismBean.getCriticism());
					try {
						String s  = new String(criticismBean.getCriticism().getBytes("iso8859-1"),"utf-8");
						logger.debug("评论的信息经过转码后的是:>>>>>>>>>>>>"+s);
					} catch (UnsupportedEncodingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					criticismBeanDao.create(criticismBean);
			}
			logger.debug("submint的时候的id是?>>>>"+id);
			modelMap.put("signId", id);
			
				return "redirect:/addcriticism.do?id="+id;
			

		}
}
