package com.legend.service;

import java.util.List;

import org.springframework.stereotype.Service;

public interface LegendService 
{
	List getProductLegendList();
	
	List getGeneralLegendList();

	List getAllState();

	List getPermissionLegendList();

	List getPermissionLegendListVerticalss();

	List getAuditList();

	List getBarcodeLegendList();

	List getInventoryLegendList();
}
