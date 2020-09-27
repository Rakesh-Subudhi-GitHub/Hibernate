package com.rk.entity;

import java.io.Serializable;

public class Membership implements Serializable {

	//read inputs
	private Long mid;
	private String name;
	private String addres;
	private Long reward_points;
	
	//setters & getters methods
	
	public Long getMid() {
		return mid;
	}
	public void setMid(Long mid) {
		this.mid = mid;
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
	public Long getReward_points() {
		return reward_points;
	}
	public void setReward_points(Long reward_points) {
		this.reward_points = reward_points;
	}
	
	//to string methods
	@Override
	public String toString() {
		return "Membership [mid=" + mid + ", name=" + name + ", addres=" + addres + ", reward_points=" + reward_points
				+ "]";
	}
	
	
}//class
