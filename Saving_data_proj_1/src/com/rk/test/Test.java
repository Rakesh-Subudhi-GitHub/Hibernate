package com.rk.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.rk.entity.Product;

//import javassist.bytecode.stackmap.BasicBlock.Catch;

public class Test {

	public static void main(String[] args) {
		
		//input
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;
		Product prod=null;
		Transaction tx=null;
		boolean flag=false;

		//Activate hibernate (bootstap) just like star the hibernate
		cfg= new Configuration();
		
		//supply hibernate cfg file is an input
		cfg.configure("com/rk/cfgs/hibernate.cfg.xml");
		
		//build session factory
		factory=cfg.buildSessionFactory();
		
		//open session
		ses=factory.openSession();
		
		//create  entity object o save the database s/w
		prod= new Product();
		
		//valuse set to store
		prod.setPid(104);
		prod.setPname("chai");
		prod.setPrice(8);
		prod.setQty(2);
		
		//remove auto commite option to save manually
		
		try {
			
			tx=ses.beginTransaction();//Internally call con.auto_commit  and it changes to manual setting 
			
			//save it manually and transfer to ses obj
			ses.save(prod);
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
		
		//print the output
		finally {
		if(flag==true)
			{
			tx.commit();//save it 
			System.out.println("product is save");
			}
			else
			{
				tx.rollback();//rollback it
			System.out.println("some error product is not save");
			}
		//close ses obj
		ses.close();
		
		//close factory obj
		factory.close();
		
		}//finally
	}//main

}//class
