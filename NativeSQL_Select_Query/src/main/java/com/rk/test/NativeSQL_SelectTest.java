package com.rk.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.query.NativeQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.rk.entity.InsurancePolicy;
import com.rk.utility.HibernateUtil;

public class NativeSQL_SelectTest {

	public static void main(String[] args) {
		Session ses=null;
		Transaction tx=null;
		
	     //get Session obj
		ses=HibernateUtil.getSession();
		
		try {
			if(!ses.getTransaction().isActive())
			tx=ses.beginTransaction(); //dummy
		
			//prepare Query
			NativeQuery query=ses.createSQLQuery("SELECT * FROM Insurance_Policy where policy_id >=? and policy_id<=?");
			
			//set query param values
			query.setParameter(1, 100);
			query.setParameter(2,105);
			
			//Execute the query 
			List<Object[]> list=query.getResultList();
			
			//print the output
			list.forEach(row->{
				for(Object o:row)
				{
					System.out.print(o+" ");
				}
				System.out.println();
			});
			
		}//try
		
		catch(HibernateException he) {
			he.printStackTrace();
		}
		
		finally {
			HibernateUtil.closeSessionFacory();
		}

	}//main
}//class