package com.rk.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.rk.entity.UpdateAccount;
import com.rk.util.HibernetUtil;

public class Update_Account_Table_Test_Approch2 {

	public static void main(String[] args) {
		
		//read inputs
		Session ses=null;
		UpdateAccount account=null;
		Transaction tx=null;
		Boolean flag=false;
		
		//get Session
		ses=HibernetUtil.getSession();//calling method to assigne session object
		
		//appoch 2 test
		
		try {	
			
			//remove auto commit
			tx=ses.beginTransaction();
					
			//load object for the partial modification of the object
		    account=ses.get(UpdateAccount.class,1000);
			System.out.println(account);

		    //persial obj modify
		    if(account != null)
		    {
		    	account.setAcc_bal(9685987);
		    ses.update(account);//if it is change or not check
			flag=true;

		    }
		    else
		    {
		    System.out.println("record is not there::");	
		    return;
		    }
		    
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
