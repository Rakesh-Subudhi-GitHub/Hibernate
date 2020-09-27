package com.rk.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name="PROGRAMERS_PROJECT_INFO")
public class ProgramersProjectInfo implements Serializable{

	@EmbeddedId    //BCZ its composite key use this
	
	//read inputs
	private ProgrProjID id;
	
	@Column(name="PNAME",length = 20)
	@Type(type="string")
	private String pname;
	
	@Column(name="PROJNAME",length = 20)
	@Type(type="string")
	private String projName;
	
	@Column(name="DEPTNO",length = 5)
	@Type(type="int")
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
