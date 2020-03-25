package com.example.minilogin.DAO;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.example.minilogin.model.ProductInfo;

@RestController
public interface ProductInfoDAO {

	public List<ProductInfo> viewAllProductInfo();
	public void updateProductInfo(ProductInfo product);
	public ProductInfo addProductInfo(ProductInfo product);
	//public void deleteProductInfo(String product_id);
}
