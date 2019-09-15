package com.product.dao;

import java.util.List;

import com.product.pojo.Product;

public interface ProductDao 
{
	public List getProductList();
	
	public boolean addProduct(Product product);

	public List getHSNList();

	public boolean updateProduct(Product product);

	public boolean deleteProduct(Product product, String rowId);

	public boolean CheckSkuExists(Product product);

	public List getCheckSkuIfExists(Product product);

	public List getProductListDataTable();

	public boolean updateTypeOfProduct(String productIdText, String type);

	/* public List getCheckSkuIfExists(Product product); */
}
