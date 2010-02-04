package com.easymorse.demo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestDemo {

	@Autowired
	CompanyDao companyDao;
	
	@Autowired
	ProductDao productDao;
	
	@RequestMapping("/add1.php")
	@Transactional(propagation = Propagation.REQUIRED)
	public String add1(HttpServletRequest request,ModelMap modelMap){
		System.out.println(">>>>>>>>>>>>>>>>>add1.php");
		
		Product product = new Product();
		product.setProductName("browse");
		product.setProductType("软件");
		product.setDescription("浏览器");
		
		Set<Product> set = new HashSet<Product>();
		set.add(product);
		
		Product product1 = new Product();
		product1.setProductName("GO");
		product1.setProductType("软件");
		product1.setDescription("编程语言");
		
		set.add(product1);
		
		Company company = new Company();
		company.setCompanyName("GOOGLE");
		company.setCompanyLocation("美国");
 		company.setProduct(set);
 		
 		companyDao.saveOrUpdate(company);
		return "resources";
	}
	@RequestMapping("/add2.php")
	@Transactional(propagation = Propagation.REQUIRED)
	public String add2(HttpServletRequest request,ModelMap modelMap){
		System.out.println(">>>>>>>>>>>>>>>>>add2.php");
		
		Product product = new Product();
		product.setProductName("OS");
		product.setProductType("软件");
		product.setDescription("操作系统");
		
		Set<Product> set = new HashSet<Product>();
		set.add(product);
		
		Product product1 = new Product();
		product1.setId(2L);
		product1.setProductName(".net");
		product1.setProductType("软件");
		product1.setDescription("编程语言");
		
		set.add(product1);
		
		Company company = new Company();
		company.setId(1);
		company.setCompanyName("微软");
		company.setCompanyLocation("美国");
 	//	company.setProduct(set);
 		
 		companyDao.saveOrUpdate(company);
		return "resources";
	}
	@RequestMapping("/findall.php")
	public String findAll(){
		List<Company> list = companyDao.findAll();
		return "resources";
	}
	@RequestMapping("/deleteproduct.php")
	@Transactional(propagation = Propagation.REQUIRED)
	public String deleteProduct(){
		productDao.delete(productDao.findById(1L));
		companyDao.findById(1);
		return "resources";
	}
}
