package com.rk.test;

import com.rk.dao.AuthenticationImpl;
import com.rk.dao.IAuthentication;
import com.rk.utility.HibernateUtil;

public class ProcedureTest {

	public static void main(String[] args) {
		
	//read inputs	
	IAuthentication dao= null;

	//create DAO
	dao=new AuthenticationImpl();
	
	//invoke method
	System.out.println(dao.Authentication("raja","rani"));
	
	//close session
	HibernateUtil.closeSessionFacory();
	
	}//main

}//class
