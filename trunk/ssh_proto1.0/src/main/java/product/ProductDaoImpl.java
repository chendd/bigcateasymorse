package product;

import util.dao.HibernateDaoImpl;

public class ProductDaoImpl extends HibernateDaoImpl<Product, Long> implements
		ProductDao {
	{
		this.type = Product.class;
	}
}
