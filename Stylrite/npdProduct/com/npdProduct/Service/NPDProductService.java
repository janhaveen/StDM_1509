package com.npdProduct.Service;

import java.util.List;

import com.npdProduct.pojo.NPDProduct;
import com.product.pojo.Product;

public interface NPDProductService 
{
	public List getProductNPDList();

	public int sentForPurchaseData(Product product, String sku, String productId, String rowId, String npdType);

	public int sentForProductionData(Product product, String sku, String productId, String rowId, String npdType);

	public List getRequestForPurchaseList();

	public List getRequestForProductionList();

	public int updateStatusForProcessedInNPD(NPDProduct npdProduct, String sku, String productId, String rowId, String npdStatus);

	public int updateStatusForInProcessedInNPD(NPDProduct npdProduct, String sku, String productId, String rowId,String npdStatus);

	/* public List getCheckSkuIfExists(Product product); */
}
