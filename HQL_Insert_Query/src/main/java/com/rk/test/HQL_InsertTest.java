package com.rk.test;

import com.rk.dao.InsurancePolicyDAO;
import com.rk.dao.InsurancePolicyDAOImpl;
import com.rk.utility.HibernateUtil;

public class HQL_InsertTest {

	public static void main(String[] args) {
		
		InsurancePolicyDAO dao=null;
		
		//create DAO class
	dao=new InsurancePolicyDAOImpl();
	
	//method called
	System.out.println(dao.transferPremiumInsurancePolicy(100));
	
	//close ses obj
	HibernateUtil.closeSessionFacory();
	
	}//main
}//class