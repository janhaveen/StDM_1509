package com.stock.service.Impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stock.dao.StockDao;
import com.stock.service.StockService;
@Service
public class StockServiceImpl implements StockService {

	@Autowired
	HttpSession session;
	
	@Autowired
	private StockDao stockDao;

	public StockDao getStockDao() {
		return stockDao;
	}

	public void setStockDao(StockDao stockDao) {
		this.stockDao = stockDao;
	}
	
	@Override
	public List getOrdersForStockOutList() {
		return stockDao.getOrdersForStockOutList();
	}

	@Override
	public List getOrderProductsForStockOutList(String orderId) {
		return stockDao.getOrderProductsForStockOutList(orderId);
	}

	@Override
	public List getSampleListForStockOutFromSample(String product_id) {
		// TODO Auto-generated method stub
		return stockDao.getSampleListForStockOutFromSample(product_id);
	}


}
