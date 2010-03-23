package com.easymorse.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OrderItemController {

	@Autowired
	OrderItemDao orderItemDao;
	
	@RequestMapping("/")
	@Transactional(propagation = Propagation.REQUIRED)
	public String addItem(){
		return "";
	}
}
