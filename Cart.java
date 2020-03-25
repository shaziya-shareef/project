package com.example.minilogin.model;

public class Cart {
	Long id;
	String name;
	
	public Cart() {
		super();
	}
	
	public Cart(Long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Cart [id=" + id + ", name=" + name + "]";
	}
	
}
