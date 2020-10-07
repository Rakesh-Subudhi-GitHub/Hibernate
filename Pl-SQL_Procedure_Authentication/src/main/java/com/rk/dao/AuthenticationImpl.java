package com.rk.dao;

import javax.persistence.ParameterMode;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.procedure.ProcedureCall;

import com.rk.utility.HibernateUtil;

public class AuthenticationImpl implements IAuthentication {

	@Override
	public String Authentication(String Username, String password) {
		
		//read input
		Session ses=null;
		Transaction tx=null;
		ProcedureCall call=null;
		String Result;
		
		//create session
		ses=HibernateUtil.getSession();
		
		//get session obj
		if(!ses.getTransaction().isActive())
			tx=ses.beginTransaction();
		
		//create procedure call
		call=ses.createStoredProcedureCall("P_AUTHENTICATION");
		
		//register IN or OUT param values
		call.registerParameter(1,String.class,ParameterMode.IN).bindValue(Username);
		call.registerParameter(2,String.class,ParameterMode.IN).bindValue(password);
		call.registerParameter(3,String.class,ParameterMode.OUT);
		
		//PL-SQL result is store
		Result=(String) call.getOutputParameterValue(3);//PL-SQL out put is store in Result param
		
		return Result;
		
	}//main

}//class
