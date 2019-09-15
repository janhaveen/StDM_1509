package com.legend.dao;

import java.util.List;

import com.legend.pojo.ProductLegend;

public interface LegendDao 
{
	List getProductLegendList();
	
	List getGeneralLegendList();

	List getAllState();

	List getPermissionLegendList();

	List getPermissionLegendListVerticalss();

	List<ProductLegend> getbrandlegend(String brand);

	List<ProductLegend> getTypelegend(String type);

	List<ProductLegend> checkbrandsexists(List lst);

	List getAuditList();

	List getBarcodeLegendList();

	List getInventoryLegendList();
}
