package com.example.minilogin.DAOimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.example.minilogin.DAO.CartDAO;
import com.example.minilogin.model.Cart;
import com.example.minilogin.model.ProductInfo;
import com.example.minilogin.model.Customer;
import com.example.minilogin.util.DButil;

@RestController
public class CartDAOImpl implements CartDAO{
	Connection connection;
	static List<Customer> list1 = new ArrayList();

	public CartDAOImpl() {
		connection = DButil.getConnection();
		System.out.println("connection" + connection);
	}

	public List<Customer> viewAllName() {
		// List<Customer> customer = new ArrayList<Customer>();
		System.out.println("Inside viewAll customer");

		try {
			list1.clear();

			System.out.println("Inside try");
			PreparedStatement stmt = connection.prepareStatement("select id,name from users");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Customer user = new Customer();
				System.out.println("Inside while");
				user.setId((int) rs.getLong("id"));
				user.setName(rs.getString("name"));
				System.out.println("Inside while-2");
				list1.add(user);
				System.out.println(list1);
			}
		} catch (Exception e) {
		}
		return list1;
	}

	@Override
	public int idvalidation(String name,String id1) {
		int flag = 0;
		Cart ca = new Cart();
		for (Customer c : list1) {
			try {
				Long temp; 
				System.out.println("Customer data----" + c);
				PreparedStatement pstmt = connection.prepareStatement("delete  from  cart");
				pstmt.executeUpdate();
				if (c.getName().equals(name)) {
					PreparedStatement pst = connection.prepareStatement("Insert into cart(user_id) select id from users where name='" + name + "'");
					Long id = ca.getId();
					pst.executeUpdate();
					flag = 1;
					
					
					PreparedStatement stmt =connection.prepareStatement("select max(order_id) from order_main");
					ResultSet rs = stmt.executeQuery();
					rs.next();
					temp=rs.getLong(1);
					temp++;
					System.out.println("first");
					PreparedStatement pst1 = connection.prepareStatement("select address,email,name,phone into @add,@email,@name,@ph from users where name='" + name + "'");
					pst1.executeUpdate();
					PreparedStatement pst2 = connection.prepareStatement("select create_time,product_price,product_status,update_time into @ct,@price,@st,@upt from product_info where product_id='" + id1 + "'");
					pst2.executeUpdate();
					PreparedStatement pst3 = connection.prepareStatement("Insert into order_main(order_id,buyer_address,buyer_email,buyer_name,buyer_phone,create_time,order_amount,order_status,update_time) values(temp,@add,@email,@name,@ph,@ct,@price,@st,@upt)");
					pst3.executeUpdate();
					System.out.println("second");
					System.out.println("plz work");



					
				}
			} catch (Exception e) {
			}
		}
		System.out.println("flag" + flag);
		return flag;
	}


  public List<Customer> orders() 
  { // List<Customer> customer = new ArrayList<Customer>(); 
	//System.out.println("Inside viewAll customer");
  
  try {
	  list1.clear();
	  Long temp; 
	  System.out.println("Inside try");
  PreparedStatement stmt =connection.prepareStatement("select max(order_id) from order_main");
 ResultSet rs = stmt.executeQuery();
 rs.next();
 temp=rs.getLong(1);
 temp++;
 
 PreparedStatement stmt1 = connection.prepareStatement("select * from users");
	ResultSet rs1 = stmt.executeQuery();
	PreparedStatement stmt2 = connection.prepareStatement("select * from product_info");
	ResultSet rs2 = stmt2.executeQuery();
	
		ProductInfo pr=new ProductInfo();
	while (rs1.next() && rs2.next()) {
		Customer user=new Customer();	
	System.out.println("Inside while");
	String address=rs.getString("address");
	String email=rs.getString("email");
	String buyer_name=rs.getString("name");
	String buyer_phone=rs.getString("phone");
	System.out.println("sucks");
	System.out.println(email);
	
	
	
		System.out.println("Inside while1");
		Date create_time=rs2.getDate("create_time");
		float amount=rs2.getFloat("product_price");
		int status=rs2.getInt("product_status");
		Date update_time=rs2.getDate("update_time");
		System.out.println(status);	
	}
			/*
			 * PreparedStatement stmt3 =connection.
			 * prepareStatement("insert into order_main(order_id,buyer_address,buyer_email,buyer_name,buyer_phone,create_time,order_amount,order_status,update_time) values()"
			 * ); stmt3.executeUpdate(); PreparedStatement stmt4
			 * =connection.prepareStatement("insert into product_order(...) values(temp, )"
			 * ); stmt4.executeUpdate();
			 */
 
 }catch (Exception e) { } return list1; 
 
  }
 
}
