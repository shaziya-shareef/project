package com.example.minilogin.DAO;

import java.util.List;

import com.example.minilogin.model.Customer;

public interface CartDAO {
	public List<Customer> viewAllName();
	public int idvalidation(String name,String id1);
	public List<Customer> orders();
}
