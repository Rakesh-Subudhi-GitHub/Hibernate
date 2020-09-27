package com.rk.entity;

import java.io.Serializable;

public class ProgramersProjectInfo implements Serializable{

	//read inputs
	private ProgrProjID id;
	private String pname;
	private String projName;
	private Integer deptno;
	
	//setters & getters
	public ProgrProjID getId() {
		return id;
	}
	public void setId(ProgrProjID id) {
		this.id = id;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getProjName() {
		return projName;
	}
	public void setProjName(String projName) {
		this.projName = projName;
	}
	public Integer getDeptno() {
		return deptno;
	}
	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}

	
	//to string
	@Override
	public String toString() {
		return "ProgramersProjectInfo [id=" + id + ", pname=" + pname + ", projName=" + projName + ", deptno=" + deptno
				+ "]";
	}
	
}
