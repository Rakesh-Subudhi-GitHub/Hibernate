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
			query=ses.createQuery("FROM  com.rk.entity.InsurancePolicy where policy_id >=?1 and policy_id<=?2");
			
			//set query param values
			
			/*  query.setInteger(1,100);
			      query.setInteger(2, 105);   *///this method are deprecated
			
			//use
			query.setParameter(1, 100);
			query.setParameter(2,105);
			
			//Execute the query 
			list=query.getResultList();
			
			//print the output
			list.forEach(System.out::println);
			
		}//try
		
		catch(HibernateException he) {
			he.printStackTrace();
		}
		
		finally {
			HibernateUtil.closeSessionFacory();
		}

	}//main
}//class