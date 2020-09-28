package com.rk.test;

import java.util.List;
import java.util.Iterator;
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
		//Query<InsurancePolicy> query=null;
		//List<InsurancePolicy> list=null;
		
	     //get Session obj
		ses=HibernateUtil.getSession();
		try {
			tx=ses.beginTransaction(); //dummy
		
			//prepare Query
			Query query=ses.createQuery("SELECT policy_Id,policy_Name FROM   com.rk.entity.InsurancePolicy WHERE policy_Name like :initLetters");
			//SELECT policy_Id,policy_Name FROM Insurance_Policy WHERE policy_Name like 'r%'
			
			//set values to query params
			query.setParameter("initLetters","r%");
			
			//execute HQL query
			List<Object[]> list=query.getResultList();
			
			//process result
			list.forEach(row->{
				for(Object obj:row) {
					System.out.print(obj+"   "); 
				}//for
				System.out.println();
			});
	  }		//try
		
		catch(HibernateException he) {
			he.printStackTrace();
		}
		
		finally {
			HibernateUtil.closeSessionFacory();
		}

	}//main
}//class