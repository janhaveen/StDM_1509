package com.npdProduct.ServiceIpml;



import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.service.impl.CurrentDateTime;
import com.npdProduct.Service.NPDProductService;
import com.npdProduct.dao.NPDProductDao;
import com.npdProduct.pojo.NPDProduct;
import com.product.pojo.Product;


@Service
public class NPDProductServiceImpl implements NPDProductService
{

	@Autowired
	HttpSession session;
	
	@Autowired
	private NPDProductDao npdProductDao;
	

	@Override
	public List getProductNPDList() 
	{
		return npdProductDao.getProductNPDList();
	}

	@Override
	public int sentForPurchaseData(Product product, String sku, String productId, String rowId, String npdType) 
	{
		boolean bool = false;
		
		int status = 0;
		
		try
		{
			product.setUpdatedBy(String.valueOf(session.getAttribute("userRowId")));
			
			product.setUpdatedOn(CurrentDateTime.CurrentTimestamp());
				
			bool = npdProductDao.updateNPDProduct(product, productId);
			
			if(bool) 
			{
				
				boolean bol = false;

				NPDProduct npdProduct = new NPDProduct();
				  			 npdProduct.setRowId(rowId);
				  			 npdProduct.setProductId(productId);
				  			 npdProduct.setSku(sku);
				  			 npdProduct.setType(npdType);
				  			 npdProduct.setIsdeleted("0");
				  			 npdProduct.setCreatedBy(String.valueOf(session.getAttribute("userRowId")));
				  			 npdProduct.setCreatedOn(CurrentDateTime.CurrentTimestamp());
				  			 
				  bol = npdProductDao.saveNPDProdduct(npdProduct);
				  
				  if(bol)
				  {
					  status = 1501;
				  }
				  else
				  {
					  status = 1502;
				  }
			}
			else 
			{
				status = 1503;
			}
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		
		return status;
	}

	@Override
	public int sentForProductionData(Product product, String sku, String productId, String rowId, String npdType) 
	{
		boolean bool = false;
		
		int status = 0;
		
		try
		{
			product.setUpdatedBy(String.valueOf(session.getAttribute("userRowId")));
			
			product.setUpdatedOn(CurrentDateTime.CurrentTimestamp());
				
			bool = npdProductDao.updateNPDProduct(product, productId);
			
			if(bool) 
			{
				
				boolean bol = false;

				NPDProduct npdProduct = new NPDProduct();
				  			 npdProduct.setRowId(rowId);
				  			 npdProduct.setProductId(productId);
				  			 npdProduct.setSku(sku);
				  			 npdProduct.setType(npdType);
				  			 npdProduct.setIsdeleted("0");
				  			 npdProduct.setCreatedBy(String.valueOf(session.getAttribute("userRowId")));
				  			 npdProduct.setCreatedOn(CurrentDateTime.CurrentTimestamp());
				  			 
				  bol = npdProductDao.saveNPDProdduct(npdProduct);
				  
				  if(bol)
				  {
					  status = 1601;
				  }
				  else
				  {
					  status = 1602;
				  }
			}
			else 
			{
				status = 1603;
			}
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		
		return status;
	}

	@Override
	public List getRequestForPurchaseList() 
	{
		return npdProductDao.getRequestForPurchaseList();
	}

	@Override
	public List getRequestForProductionList()
	{
		return npdProductDao.getRequestForProductionList();
	}

	@Override
	public int updateStatusForProcessedInNPD(NPDProduct npdProduct, String sku, String productId, String rowId, String npdStatus)
	{
		boolean bool = false;
		
		int status = 0;
		
		try
		{
			npdProduct.setUpdatedBy(String.valueOf(session.getAttribute("userRowId")));
			
			npdProduct.setUpdatedOn(CurrentDateTime.CurrentTimestamp());
			
			npdProduct.setRowId(rowId);
			
			npdProduct.setProductId(productId);
			
			npdProduct.setStatus(npdStatus);
			
			npdProduct.setSku(sku);
				
			bool = npdProductDao.updateStatusForNPD(npdProduct);
			
			if(bool) 
			{
				status = 1701;
			}
			else 
			{
				status = 1702;
			}
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		
		return status;
	}

	@Override
	public int updateStatusForInProcessedInNPD(NPDProduct npdProduct, String sku, String productId, String rowId, String npdStatus)
	{
		boolean bool = false;
		
		int status = 0;
		
		try
		{
			npdProduct.setUpdatedBy(String.valueOf(session.getAttribute("userRowId")));
			
			npdProduct.setUpdatedOn(CurrentDateTime.CurrentTimestamp());
			
			npdProduct.setRowId(rowId);
			
			npdProduct.setProductId(productId);
			
			npdProduct.setStatus(npdStatus);
			
			npdProduct.setSku(sku);
				
			bool = npdProductDao.updateStatusForNPD(npdProduct);
			
			if(bool) 
			{
				status = 1701;
			}
			else 
			{
				status = 1702;
			}
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		
		return status;
	}
}
