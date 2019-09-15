package com.barcode.dao.Impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.barcode.dao.BoxBarcodeDao;
import com.barcode.pojo.EmptyBoxBarcodeLocationList;
@Repository("boxBarcodeDaoImpl")
@Transactional("transactionManagerInventory")
public class BoxBarcodeDaoImpl implements BoxBarcodeDao {
	@PersistenceContext(unitName="stylriteInventory")
	private EntityManager entityManagerInventory;

	@Override
	public List getlistEmptyLocationList() {
		return entityManagerInventory.createQuery("SELECT e FROM EmptyBoxBarcodeLocationList e "
				+ "where 1=1 AND e.remQty=e.capacity AND  e.isPresent!=1 ",EmptyBoxBarcodeLocationList.class).getResultList();
	}

}
