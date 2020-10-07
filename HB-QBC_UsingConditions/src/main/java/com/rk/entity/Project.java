package com.rk.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@ToString
public class Project implements Serializable{

	//read inputs
	@Id
	private int projid;
	private String ProjName;
	private String Company;
	private String location;
	private Long cost;
	private int teamsize;
	
	
	
}//class
