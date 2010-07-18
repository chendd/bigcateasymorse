package com.test.dao;

import java.util.ArrayList;
import java.util.List;

import com.test.Product;

public class ProductDao {

	List<Product> list = new ArrayList<Product>();

	public List<Product> insertProduct(Product product) {

		list.add(product);

		return list;

	}
}
