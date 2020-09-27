package com.rk.entity;

import java.io.Serializable;

public class Product implements Serializable
{
	//beans property
	private int pid;
	private String pname;
	private float price;
	private int qty;
	
	//setter and getter selected
				//setter method used for setting(set/modify) the data
				//getter method used for reading the data
						//so fast get read the data then used set modify data
	
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	
	//print all data
	
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", price=" + price + ", qty=" + qty + "]";
	}

}//main
