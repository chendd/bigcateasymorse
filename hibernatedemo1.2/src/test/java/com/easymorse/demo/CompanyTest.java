package com.easymorse.demo;


import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;




/**
 * 测试类
 * @author dahui <a href="mailto:jiessiedyh@gmail.com">jiessiedyh@gmail.com</a> 
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:config.xml" })
public class CompanyTest {

	@Autowired
	CompanyDao companyDao;

	

	@Test
	@Transactional(propagation = Propagation.REQUIRED)
	public void test() {

	
		Product product = new Product();
		product.setProductName("OS");
		product.setProductType("软件");
		product.setDescription("操作系统");
		
		Set<Product> set = new HashSet<Product>();
		set.add(product);
		
		Product product1 = new Product();
		product1.setProductName(".net");
		product1.setProductType("软件");
		product1.setDescription("编程语言");
		
		set.add(product1);
		
		Company company = new Company();
		company.setCompanyName("微软");
		company.setCompanyLocation("美国");
 		company.setProduct(set);
 		
 		companyDao.create(company);
		
		
	}

}
