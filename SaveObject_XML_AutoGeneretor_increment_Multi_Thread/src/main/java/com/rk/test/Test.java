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
		Product prod=null,prod1=null;
		Transaction tx=null;
		boolean flag=false;
		Integer idval=0,idval1=0;

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
		//prod.setPid(880);
		//prod.setPid(2);
		prod.setPname("chai");
		prod.setPrice(8);
		prod.setQty(2);
		
		//set multi set value
		prod1= new Product();
		prod1.setPid(500);
		prod1.setPname("table");
		prod1.setPrice(5000);
		prod1.setQty(6);
		
		//remove auto commite option to save manually
		
		try {
			
			tx=ses.beginTransaction();//Internally call con.auto_commit  and it changes to manual setting 
			
			//save it manually and transfer to ses obj
			idval=(Integer) ses.save(prod);
			idval1=(Integer) ses.save(prod1);
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
			System.out.println("pid is:: "+prod.getPid());
			System.out.println("pid is ::"+prod1.getPid());
			System.out.println("idval is= "+idval+"  "+idval1);
			//System.out.println("idval1 is="+idval1);
			}
			else
			{
				tx.rollback();//rollback it
			System.out.println("some error product is not save");
			System.out.println("pid is:: "+prod.getPid());
			}
		//close ses obj
		ses.close();
		
		//close factory obj
		factory.close();
		
		}//finally
	}//main

}//class
