package com.rk.test;

import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.rk.entity.InsurancePolicy;
import com.rk.utility.HibernateUtil;

public class InsurancePolicyTest_GetLoad {

	public static void main(String[] args) {
	
		//read inputs
		Session ses=null;
		InsurancePolicy policy=null;
		
		//get Session object
		ses=new HibernateUtil().getSession();//calling the getSession method 

		//its select operaion
		
		try
		{
			//load obj
			policy=ses.load(InsurancePolicy.class, 101);
			
			//System.out.println(policy.getPolicy_id());
			
			//verify
			if(policy==null)
			{
				System.out.println("record not found");
			}//if
			else
			{
				System.out.println("record found and disply");
				System.out.println();
				System.out.println(policy);
				System.out.println();
				System.out.println("policy id is:: "+policy.getPolicy_id());
				System.out.println("policy name is:: "+policy.getCompany());
			}//else
		}//try
		catch(HibernateException he)
		{
			System.out.println("internal db problem::");
			he.printStackTrace();
		}
		catch(Exception e)
		{
			System.out.println("internal db problem::");
			e.printStackTrace();
		}
		
		//close obj
		finally {
			//close session obj
			HibernateUtil.closeSession(ses);//called session obj with help of Method (closeSession)
			
			//close SessionFactory
			HibernateUtil.closeSessionFacory();
		
		}//finally
	}//main

}//class
