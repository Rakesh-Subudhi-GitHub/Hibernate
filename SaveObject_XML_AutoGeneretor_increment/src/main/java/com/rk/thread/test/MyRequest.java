package com.rk.thread.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rk.entity.Product;

public class MyRequest implements Runnable {
	
	//read inputs
	private Session ses;
	private Product p;
	
	public MyRequest(Session ses,Product p)
	{
		this.ses=ses;
		this.p=p;
	}

	@Override
	public void run() {
		
		//read input
		Transaction tx=null;
		boolean flag=false;
		int idVal=0;

		try {
			tx=ses.beginTransaction();
			idVal=(Integer)ses.save(p);
			flag=true;
			System.out.println("generate id value is:: "+idVal);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			flag=false;
		}
		
		//finally
		{
			if(flag)
			{
				tx.commit();
			}
			else
			{
				tx.rollback();
			}
		}//finally
	}//main

}
