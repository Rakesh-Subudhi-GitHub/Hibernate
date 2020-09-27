package com.rk.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rk.entity.Delete_Account;
import com.rk.utility.HibernetUtil;

public class Delete_Account_Test {

public static void main(String[] args) {
		
		//read inputs
		Session ses=null;
		Delete_Account account=null;
		Transaction tx=null;
		Boolean flag=false;
		
		//get Session
		ses=HibernetUtil.getSession();//calling method to assigne session object
		
		//prepare full object for modification with existing id
		account=new Delete_Account();
		
		account.setAcc_no(2000);
		
		//Verify the account is there or change or not 
		try {
			//remove auto commit
			tx=ses.beginTransaction();
			ses.delete(account);//if it is change or not check
			flag=true;

		}//try
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("some internal proble ");
		}

		//close final object
		finally {
	
			//check the flag
			if(flag==true)
			{
			tx.commit();
			System.out.println("::account is delete succeded::");
			}
			else
			{
				tx.rollback();
				System.out.println("::account not delete::");
			
			}
			
			//close ses or factory obj
			HibernetUtil.closeSession(ses);
			HibernetUtil.closeSessionFactory();
		}//finally
	

}//main
}//class
