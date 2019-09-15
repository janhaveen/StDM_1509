package com.returnData.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;

import com.product.pojo.Product;
import com.returnData.pojo.DetailReturnItemView;
import com.returnData.pojo.ReturnDemo;
import com.returnData.pojo.ReturnItem;

public interface ReturnService 
{
	List<ReturnDemo> getAllReturnDetails();

	int saveReturn(ReturnDemo returnDemo);

	int addProductReturn(Product product);

	List<DetailReturnItemView> getAllReturnItemDetails();

	int saveReturnItemArray(ReturnItem returnItem, ReturnDemo returnDemo, Product product, HttpServletRequest request, JSONArray returnItemArray);
}
