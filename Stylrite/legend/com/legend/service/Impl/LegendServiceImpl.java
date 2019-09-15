package com.legend.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.legend.dao.LegendDao;
import com.legend.service.LegendService;

@Service
public class LegendServiceImpl implements LegendService
{
	@Autowired
	LegendDao legendDao;
	
	public void setLegendDao(LegendDao legendDao)
	{
		this.legendDao = legendDao;
	}

	@Override
	public List getProductLegendList() 
	{
		return legendDao.getProductLegendList();
	}
	
	@Override
	public List getGeneralLegendList()
	{
		return legendDao.getGeneralLegendList();
	}

	@Override
	public List getAllState()
	{
		return legendDao.getAllState();
	}

	@Override
	public List getPermissionLegendList() {
		return legendDao.getPermissionLegendList();
	}

	@Override
	public List getPermissionLegendListVerticalss() {
		return legendDao.getPermissionLegendListVerticalss();
	}

	@Override
	public List getAuditList()
	{
		return legendDao.getAuditList();
	}

	@Override
	public List getBarcodeLegendList()
	{
		return legendDao.getBarcodeLegendList();
	}

	@Override
	public List getInventoryLegendList() {
		// TODO Auto-generated method stub
		return legendDao.getInventoryLegendList();
	}

}
