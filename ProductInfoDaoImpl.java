package com.example.minilogin.DAOimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

import org.springframework.web.bind.annotation.RestController;

import com.example.minilogin.DAO.ProductInfoDAO;
import com.example.minilogin.model.ProductInfo;
import com.example.minilogin.util.DButil;

@RestController
public class ProductInfoDaoImpl implements ProductInfoDAO{
	static List<ProductInfo> list1=new ArrayList();
	Connection connection;
	
	public ProductInfoDaoImpl() {
		connection = DButil.getConnection();
		System.out.println("connection" + connection);
	}	
	public List<ProductInfo> viewAllProductInfo(){
		//List<Customer> customer = new ArrayList<Customer>();		
		System.out.println("Inside viewAll products");
		try {
			
			System.out.println("Inside try");
			PreparedStatement stmt = connection.prepareStatement("select * from product_info");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				ProductInfo product=new ProductInfo();
				System.out.println("Inside while");
				product.setProduct_id(rs.getString(1));
				product.setCategory_type(rs.getInt(2));
				product.setCreate_time(rs.getDate(3));
				product.setProduct_description(rs.getString(4));
				product.setProduct_icon(rs.getString(5));
				product.setProduct_name(rs.getString(6));
				product.setProduct_price(rs.getDouble(7));
				product.setProduct_status(rs.getInt(8));
				product.setProduct_stock(rs.getInt(9));
				product.setUpdate_time(rs.getDate(10));
				System.out.println("Inside while-2");
				list1.add(product);
				System.out.println(list1);
				
			}
			}catch(Exception e) {}
		return list1;
	}

	public void updateProductInfo(ProductInfo product) {}
	public ProductInfo addProductInfo(ProductInfo product) {
		int noOfRecords=0;
		try {
		PreparedStatement pst = connection.prepareStatement("Insert into product_info(product_id,category_type, create_time, product_description, product_icon,  product_name, product_price, product_status, product_stock, update_time) values(?,?,?,?,?,?,?,?,?,?)");
		pst.setString(1,product.getProduct_id());
		pst.setInt(2,product.getCategory_type());
		pst.setDate(3, product.getCreate_time());
		pst.setString(4,product.getProduct_description());
		pst.setString(5,product.getProduct_icon());
		pst.setString(6,product.getProduct_name());
		pst.setDouble(7,product.getProduct_price());
		pst.setInt(8,product.getProduct_status());
		pst.setInt(9,product.getProduct_stock());
		pst.setDate(10,product.getUpdate_time());
		
		noOfRecords=pst.executeUpdate();
		
		System.out.println(noOfRecords+ "record inserted successfully");
		}catch(Exception e) {}
		return product;
	}
	

}
