package com.rk.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.rk.entity.UpdateAccount;
import com.rk.util.HibernetUtil;

public class Update_Account_Table_Test {

	public static void main(String[] args) {
		
		//read inputs
		Session ses=null;
		UpdateAccount account=null;
		Transaction tx=null;
		Boolean flag=false;
		
		//get Session
		ses=HibernetUtil.getSession();//calling method to assigne session object
		
		//prepare full object for modification with existing id
		account=new UpdateAccount();
		
		account.setAcc_no(1054);
		account.setAcc_name("rakesh");
		account.setAcc_add("bbsr");
		account.setAcc_type("customer");
		account.setAcc_bal(100000000);
		
		//Verify the account is there or change or not 
		try {
			//remove auto commit
			tx=ses.beginTransaction();
			ses.update(account);//if it is change or not check
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
			System.out.println("::account is updated succeded::");
			}
			else
			{
				tx.rollback();
				System.out.println("::account not updated::");
			
			}
			
			//close ses or factory obj
			HibernetUtil.closeSession(ses);
			HibernetUtil.closeSessionFactory();
		}//finally
	
	}//main

}//class
