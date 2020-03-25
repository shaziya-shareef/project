package com.example.minilogin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.minilogin.DAO.ProductInfoDAO;
import com.example.minilogin.model.ProductInfo;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ProductInfoController {
	
	@Autowired
	private ProductInfoDAO productDao;
	
	@GetMapping("/product")
	public List getProducts() {	
	return productDao.viewAllProductInfo();
}

	
	@PostMapping(value = "/post/product")
	public ResponseEntity addProductInfo(@RequestBody ProductInfo product) {
		productDao.addProductInfo(product);
		return new ResponseEntity(product, HttpStatus.OK);
	}

}
