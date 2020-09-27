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
		boolean flag=false;
		Long idVal=0l;
		
		//get session obj
		ses=HibernetUtil.getSession();
		
		//create entity class obj
		prod= new Product();
		
		prod.setPid(1011l);
		//prod.setPname("rakesh");
		prod.setTeamSize(14);
		prod.setCompany("execle");
		
		//auto commit  remove
		try
		{
			tx=ses.beginTransaction();
			idVal=(Long) ses.save(prod);
			
			System.out.println();
			System.out.println(":::Generate id value::: "+idVal);
			System.out.println();
			
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
		
		//commit or rolback or close obj
		finally {
			
			//check flag
			if(flag)
			{
				tx.commit();
				System.out.println("::::::::::::::::::::object is save::::::::::::::::::::::::::");
			}
			else
			{
				tx.rollback();
				System.out.println("::::::::::::::::::::::::::object is not saved:::::::::::::::::::::::::::::::");
			}
			
			//close obj
			HibernetUtil.closeSession(ses);
			HibernetUtil.closeSessionFactory();
	
		}//finally
		
		
	}//main

}//class
