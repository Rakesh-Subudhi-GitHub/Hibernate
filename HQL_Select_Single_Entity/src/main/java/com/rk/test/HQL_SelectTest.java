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
			Query query=ses.createQuery("FROM   com.rk.entity.InsurancePolicy WHERE policy_id= :pid");
			
			//set values to query params
			query.setParameter("pid",100);
			
			//execute HQL query
			List<InsurancePolicy> list=query.getResultList();
			
			//process result
			if(!list.isEmpty())
			{
		    
				InsurancePolicy policy=list.get(0);//single record so fast element in array so its start with 0 so we get 0th elements
		        System.out.println(policy);
		        System.out.println("size of elements:: "+list.size());
			
			}//if
			else
			{
				System.out.println("record not found:::");
			}
		
	  }		//try
		
		catch(HibernateException he) {
			he.printStackTrace();
		}
		
		finally {
			HibernateUtil.closeSessionFacory();
		}

	}//main
}//class