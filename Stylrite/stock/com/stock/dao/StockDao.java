package com.stock.dao;

import java.util.List;

public interface StockDao {
	public List getOrdersForStockOutList();

	public List getOrderProductsForStockOutList(String orderId);

	public List getSampleListForStockOutFromSample(String product_id);
}
