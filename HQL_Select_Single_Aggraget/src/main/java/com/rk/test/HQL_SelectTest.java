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
			Query query=ses.createQuery("SELECT COUNT(*) FROM com.rk.entity.InsurancePolicy");
			
			//execute HQL query
			List<?> list=query.getResultList();
			
			//process result
			if(!list.isEmpty())
			{
		    Long count=(Long)list.get(0);
		    System.out.println("record count is ::   "+count);
			}//if
		
	  }		//try
		
		catch(HibernateException he) {
			he.printStackTrace();
		}
		
		finally {
			HibernateUtil.closeSessionFacory();
		}

	}//main
}//class