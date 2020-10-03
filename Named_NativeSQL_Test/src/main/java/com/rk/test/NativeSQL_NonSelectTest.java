package com.rk.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import com.rk.utility.HibernateUtil;

public class NativeSQL_NonSelectTest {

	public static void main(String[] args) {
		Session ses=null;
		Transaction tx=null;
		boolean Flag=false;
		
	     //get Session obj
		ses=HibernateUtil.getSession();
		
		try {
			
			//locate or begin tx
			if(!ses.getTransaction().isActive())
			tx=ses.beginTransaction();
			
			//create Native Query object having nativeQuery sql query
			NativeQuery<Object[]> query=ses.getNamedNativeQuery("GET_POLICY_TYPE");
			
			//Set value query params
			query.setParameter(1,"lic");
			
			//execute query
			List<Object[]> list=query.getResultList();
			
			list.forEach(row->{
				for(Object o: row)
				{
					System.out.println(o+" ");
				}
				System.out.println();
			});
		     
		}//try
		catch(HibernateException he)
		{
			he.printStackTrace();
		}
	catch(Exception e)
		{
		e.printStackTrace();
		}

		//save the file or close ses
		finally {
			if(Flag)
			{
			  tx.commit();
				System.out.println("Recod inserted sucessed:::");
			}
			else
			{
				tx.rollback();
				System.out.println("no record updated");
			}
			
			HibernateUtil.closeSessionFacory();
		}//finally
	}//main
}//class