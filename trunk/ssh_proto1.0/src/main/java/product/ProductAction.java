package product;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.opensymphony.xwork2.ActionSupport;

public class ProductAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ProductDao productDao;

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
	
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public String test() throws Exception {
	//	productDao.findAll();
		return SUCCESS;
	}
	
}
