package com.hklmart.persistence;

import org.springframework.stereotype.Repository;

import com.hklmart.domain.ProductVO;
import com.hklmart.domain.StockVO;

@Repository
public interface ProductDAO {
	public void saveFile(ProductVO productVO);

	public void saveStock(StockVO stockVO);
	
	public int codeCheck(String insertCode);

	public void modifyFile(ProductVO productVO);

	public void modifyStock(StockVO stockVO);
}
