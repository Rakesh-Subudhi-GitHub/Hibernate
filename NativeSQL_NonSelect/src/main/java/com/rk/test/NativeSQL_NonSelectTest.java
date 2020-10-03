package com.rk.test;

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
			NativeQuery query=ses.createSQLQuery("INSERT INTO insurance_policy VALUES(?,?,?,?,?)");
			
			//Set query params
			query.setParameter(1,201);
			query.setParameter(2,"sanyasi");
			query.setParameter(3,"lic");
			query.setParameter(4,"saving");
			query.setParameter(5,50);
			
			//execute query
			int count=query.executeUpdate();
		     Flag=true;	
		     
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