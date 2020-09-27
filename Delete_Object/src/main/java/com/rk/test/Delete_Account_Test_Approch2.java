package com.rk.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rk.entity.Delete_Account;
import com.rk.utility.HibernetUtil;

public class Delete_Account_Test_Approch2 {

public static void main(String[] args) {
		
		//read inputs
		Session ses=null;
		Delete_Account account=null;
		Transaction tx=null;
		Boolean flag=false;
		
		//get Session
		ses=HibernetUtil.getSession();//calling method to assigne session object
		
		//appoch 2 test
		
		try {	
			
			//remove auto commit
			tx=ses.beginTransaction();
					
			//load object for the partial modification of the object
		    account=ses.get(Delete_Account.class,1001);
			System.out.println(account);

		    //persial obj modify
		    if(account != null)
		    {
		    	System.out.println();
		    	System.out.println(account);
		    ses.delete(account);//if it is change or not check
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
			System.out.println("::account is deleted succeded::");
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
