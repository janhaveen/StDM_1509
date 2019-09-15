package com.stock.service;

import java.util.List;

public interface StockService {

	public List getOrdersForStockOutList();

	public List getOrderProductsForStockOutList(String orderId);

	public List getSampleListForStockOutFromSample(String product_id);
}
