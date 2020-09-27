package com.rk.test;

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
			
			//execute query
			list=query.getResultList();
			
			//process the result
			/*list.forEach(policy->{     //java 8 for Each method with Lamda expression
				System.out.println(policy);
			});*/
			
			list.forEach(System.out::println);   // java 8 forEach method + Method reference
	
		}//try
		
		catch(HibernateException he) {
			he.printStackTrace();
		}
		
		finally {
			HibernateUtil.closeSessionFacory();
		}

	}//main
}//class