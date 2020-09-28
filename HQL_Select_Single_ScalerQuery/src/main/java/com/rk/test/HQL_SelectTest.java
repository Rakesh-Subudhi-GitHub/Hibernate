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
			Query query=ses.createQuery("SELECT policy_id, policy_name com.rk.entity.InsurancePolicy WHERE policy_id= :pid");
			
			//set values to query params
			query.setParameter("pid",100);
			
			//execute HQL query
			List<Object[]> list=query.getResultList();
			
			//process result
			if(!list.isEmpty())
			{
		    
				Object row[]=list.get(0);
		        System.out.println(row[0]+" "+row[1]);
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