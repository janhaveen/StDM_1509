package com.returnData.dao;

import java.util.List;

import com.returnData.pojo.DetailReturnItemView;
import com.returnData.pojo.ReturnDemo;
import com.returnData.pojo.ReturnItem;

public interface ReturnDao 
{
	List<ReturnDemo> getAllReturnDetails();

	boolean saveReturn(ReturnDemo returnDemo);

	boolean saveReturnItem(ReturnItem returnItem);

	List<DetailReturnItemView> getAllReturnItemDetails();
}
