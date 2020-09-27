package com.rk.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rk.entity.Product;
import com.rk.util.HibernetUtil;

public class Product_Test {

	public static void main(String[] args) {
		
		//read inputs
		Session ses=null;
		Transaction tx=null;
		Product prod=null;
		
		//get session obj
		ses=HibernetUtil.getSession();
		
		try
		{
		//load object
			prod=ses.load(Product.class,1001l);
			System.out.println(prod);
		}//try

		catch(HibernateException he)
		{
			System.out.println("record not found");
			he.printStackTrace();
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("record not found");
		}
		
		//commit or rolback or close obj
		finally {
			
			//close obj
			HibernetUtil.closeSession(ses);
			HibernetUtil.closeSessionFactory();
	
		}//finally
		
		
	}//main

}//class
