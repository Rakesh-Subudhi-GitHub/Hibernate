package com.rk.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.rk.entity.UpdateAccount;
import com.rk.util.HibernetUtil;

public class Update_Account_Table_Test_Approch3 {

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
		    account=ses.get(UpdateAccount.class,10010);
			
		    //persial obj modify
		    if(account != null)
		    {
		    	account.setAcc_bal(998877);
		    	
		   // ses.update(account);//if it is change or not check
			//not  required for approach 3
		    	flag=true;
		    
		    }
		    else
		    {
		    System.out.println("record is not there::");	
		    return;
		   // System.out.println("return not work");
		    }
		    
		}//try
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("some internal proble ");
		}

		//close final object
		finally {
			System.out.println("finally statement work check");
			
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
			System.out.println("close obj1");
			HibernetUtil.closeSessionFactory();
			System.out.println("close obj2");
		}//finally
	
	}//main

}//class
