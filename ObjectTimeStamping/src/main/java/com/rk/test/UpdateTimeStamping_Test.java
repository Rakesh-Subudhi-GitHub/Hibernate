package com.rk.test;

import java.time.LocalDateTime;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rk.entity.BankAccountInfo;
import com.rk.utilty.HibernetUtil;

public class UpdateTimeStamping_Test {

	public static void main(String[] args) {
		
		//read inputs
		Session ses=null;
		BankAccountInfo account=null;
		Transaction tx=null;
		Boolean flag=false;
		
		//get session
		ses=HibernetUtil.getSession();
		
		//prepared object
		account= new BankAccountInfo();

		try {
			
			tx=ses.beginTransaction();	
			
			//load the account
			account=ses.load(BankAccountInfo.class,29l);
			System.out.println(account);
			account.setBalance(1000.0);
			
			ses.save(account);
			flag=true;
		}//try
		catch(HibernateException he)
		{
			he.printStackTrace();
			flag=false;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			flag=false;
		}
		
		//save object or not
		finally {
			if(flag)
			{
				tx.commit();
				System.out.println("object is updated succesfully");
				System.out.println("opening date:::"+account.getOpeningDate());
				System.out.println("last date update"+account.getLastDateUpdated());
			}
			else
			{
				tx.rollback();
				System.out.println("object not updated saved");
				
			}
			
			//close obj
			HibernetUtil.closeSession(ses);
			HibernetUtil.closeSessionFactory();
			
		}//finally
	}//main

}//class
