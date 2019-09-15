package com.npdProduct.dao;

import java.util.List;

import com.npdProduct.pojo.NPDProduct;
import com.product.pojo.Product;

public interface NPDProductDao 
{
	public List getProductNPDList();

	public boolean updateNPDProduct(Product product, String productId);

	public boolean saveNPDProdduct(NPDProduct npdProduct);

	public List getRequestForPurchaseList();

	public List getRequestForProductionList();

	public boolean updateStatusForNPD(NPDProduct npdProduct);

	/* public List getCheckSkuIfExists(Product product); */
}
