package com.audit.service;

import java.util.List;

import org.json.JSONArray;

import com.audit.pojo.Audit;
import com.audit.pojo.AuditItem;
import com.audit.pojo.AuditItemDetailsView;

public interface AuditService 
{
	int createAuditReason(Audit audit);

	List viewAuditDetails(String auditId);

	int saveAuditItem(JSONArray auditItemArray);

	int updateItemsAudited(Audit audit, JSONArray itemsAuditedArray);

	int updateItemsCorrected(Audit audit, JSONArray itemsCorrectedArray);

	int updateItemsDuplicated(Audit audit, JSONArray itemsDuplicatedArray);

	int updateIsEditedAuditItem(AuditItem auditItem, JSONArray updateIsEditedAuditItemArray);

	List getAuditList();

	List getAuditItemDetailsViewList(String auditId);

	List<AuditItemDetailsView> getExportAuditItemAsCSVList(String auditItem);

	int updateInCorrectedLocationAuditItem(AuditItem auditItem, JSONArray isInCorrectedLocationArray);

	int getCurrentSectionData(String section);
}
