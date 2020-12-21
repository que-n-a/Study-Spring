package com.hklmart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hklmart.persistence.ProductDAO;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDAO productDAO;
	
	@Override
	public void registProduct() {
		
		
	}

	@Override
	public void deleteProduct() {
		
		
	}

	public int codeCheckTest(String insertCode) {
		
		return productDAO.codeCheck(insertCode);
	}

}
