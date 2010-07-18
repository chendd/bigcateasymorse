package com.test;

import com.test.dao.ProductDao;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */

public class AppTest  {

	@org.junit.Test
	public void tests() {
		assert 1 == 1;
		
		Product product1= new Product();
		product1.setProductName("电脑");
		product1.setProductPrice("2000元");
		ProductDao productDao = new ProductDao();
		assert productDao.insertProduct(product1).size()!=0;
		
	
	}
	
	
}
