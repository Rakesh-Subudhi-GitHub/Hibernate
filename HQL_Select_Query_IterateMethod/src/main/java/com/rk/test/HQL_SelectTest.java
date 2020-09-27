package com.rk.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.rk.entity.InsurancePolicy;
import com.rk.utility.HibernateUtil;

public class HQL_SelectTest {

	public static void main(String[] args) {
		Session ses=null;
		Transaction tx=null;
		Query<InsurancePolicy> query=null;
		List<InsurancePolicy> list=null;
		
	     //get Session obj
		ses=HibernateUtil.getSession();
		try {
			tx=ses.beginTransaction(); //dummy
		
			//prepare Query
			query=ses.createQuery("FROM  com.rk.entity.InsurancePolicy");
			
			//execute HQL query
			Iterator<InsurancePolicy> it= query.iterate();//returns the all data and store to it
			
			//output print
			while(it.hasNext())//if its true then data is here 
			{
				InsurancePolicy policy=it.next();//one by one catch and store to policy
				System.out.println(policy);
				
			}//while
			
			
		}//try
		
		catch(HibernateException he) {
			he.printStackTrace();
		}
		
		finally {
			HibernateUtil.closeSessionFacory();
		}

	}//main
}//class