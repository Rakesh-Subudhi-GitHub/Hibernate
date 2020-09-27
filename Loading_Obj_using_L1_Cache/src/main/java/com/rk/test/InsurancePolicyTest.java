package com.rk.test;

import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.rk.entity.InsurancePolicy;
import com.rk.utility.HibernateUtil;

public class InsurancePolicyTest {

	public static void main(String[] args) {
	
		//read inputs
		Session ses=null;
		InsurancePolicy policy=null,policy1=null;
		
		//get Session object
		ses=new HibernateUtil().getSession();//calling the getSession method 

		//its select operaion
		
		try
		{
			//load obj
			policy=ses.get(InsurancePolicy.class, 101);
			
			//verify
			if(policy==null)
			{
				System.out.println("record not found");
				
			}//if
			else
			{
				System.out.println("record found and disply");
				System.out.println("policy load :::::"+policy);
			}//else

		//2nd time load the obj
			//load obj
			System.out.println("---------------------------------------------------------------------------------");
			policy1=ses.get(InsurancePolicy.class, 101);
			System.out.println("policy 1 load:::"+policy1);
		
			System.out.println();
			
			//check hash code
			System.out.println(policy.hashCode());
			System.out.println(policy1.hashCode());
			System.out.print("chek policy hash code same :::");
			System.out.println(policy.hashCode()==policy1.hashCode());
		
		
		
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
