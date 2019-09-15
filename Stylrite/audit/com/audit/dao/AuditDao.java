package com.audit.dao;

import java.util.List;

import com.audit.pojo.Audit;
import com.audit.pojo.AuditItem;
import com.audit.pojo.AuditItemDetailsView;

public interface AuditDao 
{
	boolean createAuditReason(Audit audit);

	List viewAuditDetails(String auditId);

	boolean saveAuditItem(AuditItem auditItem);

	boolean updateItemsAudited(Audit audit);

	boolean updateItemsCorrected(Audit audit);

	boolean updateItemsDuplicated(Audit audit);

	boolean updateIsEditedAuditItem(AuditItem auditItem);

	List getAuditList();

	List getAuditItemDetailsViewList(String auditId);

	List<AuditItemDetailsView> getExportAuditItemAsCSVList(String auditItem);

	boolean updateInCorrectedLocationAuditItem(AuditItem auditItem);

	boolean updateLostCountInAudit(Audit audit);
}
