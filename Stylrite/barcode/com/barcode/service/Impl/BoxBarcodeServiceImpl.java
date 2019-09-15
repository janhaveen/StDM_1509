package com.barcode.service.Impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barcode.dao.BoxBarcodeDao;
import com.barcode.service.BoxBarcodeService;

@Service
public class BoxBarcodeServiceImpl implements BoxBarcodeService {
	@Autowired
	HttpSession session;
	
	@Autowired
	private BoxBarcodeDao boxBarcodeDao;
	
	public BoxBarcodeDao getBoxBarcodeDao() {
		return boxBarcodeDao;
	}

	public void setBoxBarcodeDao(BoxBarcodeDao boxBarcodeDao) {
		this.boxBarcodeDao = boxBarcodeDao;
	}

	@Override
	public List getlistEmptyLocationList() {
		return boxBarcodeDao.getlistEmptyLocationList();
	}

}
