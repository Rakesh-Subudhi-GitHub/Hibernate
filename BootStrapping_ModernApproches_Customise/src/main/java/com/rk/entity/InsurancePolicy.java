package com.rk.entity;

import java.io.Serializable;

public class InsurancePolicy implements Serializable {

	private Integer policy_id;
	private String Policy_name;
	private String policy_type;
	private String Company;
	private Integer tenure;//get rapper obj so it take Integer fully name
	
	//getters & setters
	public Integer getPolicy_id() {
		return policy_id;
	}
	public void setPolicy_id(Integer policy_id) {
		this.policy_id = policy_id;
	}
	public String getPolicy_name() {
		return Policy_name;
	}
	public void setPolicy_name(String policy_name) {
		Policy_name = policy_name;
	}
	public String getPolicy_type() {
		return policy_type;
	}
	public void setPolicy_type(String policy_type) {
		this.policy_type = policy_type;
	}
	public String getCompany() {
		return Company;
	}
	public void setCompany(String company) {
		Company = company;
	}
	public Integer getTenure() {
		return tenure;
	}
	public void setTenure(Integer tenure) {
		this.tenure = tenure;
	}
	
//	also take toString method

	@Override
	public String toString() {
		return "InsurancePolicy [policy_id=" + policy_id + ", Policy_name=" + Policy_name + ", policy_type="
				+ policy_type + ", Company=" + Company + ", tenure=" + tenure + "]";
	}
}
