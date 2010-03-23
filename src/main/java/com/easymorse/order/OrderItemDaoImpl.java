package com.easymorse.order;

import util.dao.HibernateDaoImpl;

public class OrderItemDaoImpl extends HibernateDaoImpl<OrderItem, Long>
		implements OrderItemDao {

	{
		
		this.type = OrderItem.class;
	}

}
