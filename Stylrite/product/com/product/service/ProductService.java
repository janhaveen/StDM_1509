package com.product.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.product.pojo.Product;


public interface ProductService 
{
	public List getProductList();
	
	public int addProduct(Product product, String action);

	public List getHSNList();

	public int updateProduct(Product product, String action);

	public int deleteProduct(Product product, String rowId);

	public int CheckSkuExists(Product product);

	public List getCheckSkuIfExists(Product product);

	public List getProductListDataTable();

	/* public List getCheckSkuIfExists(Product product); */
}
