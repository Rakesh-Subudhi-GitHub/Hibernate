package com.rk.entity;

import java.io.Serializable;

public class Product implements Serializable {

	//read inputs
	private long pid;
	private String name;
	private String addres;
	private long price;
	
	//setter and getter
	public long getPid() {
		return pid;
	}
	public void setPid(long pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddres() {
		return addres;
	}
	public void setAddres(String addres) {
		this.addres = addres;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	
	
	//to string
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", name=" + name + ", addres=" + addres + ", price=" + price + "]";
	}
	
	
}//class
