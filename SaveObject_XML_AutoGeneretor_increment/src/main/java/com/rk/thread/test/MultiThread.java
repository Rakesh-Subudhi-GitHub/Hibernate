package com.rk.thread.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.rk.entity.Product;

//import javassist.bytecode.stackmap.BasicBlock.Catch;

public class MultiThread {

	public static void main(String[] args) throws Exception {
		
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
		
		//value set to store
		//prod.setPid(880);
		//prod.setPid(2);
		prod.setPname("chai");
		prod.setPrice(8);
		prod.setQty(2);
		
		MyRequest req1= new MyRequest(ses, prod);
		MyRequest req2= new MyRequest(ses,prod);
		MyRequest req3= new MyRequest(ses,prod);
		MyRequest req4= new MyRequest(ses,prod);
		MyRequest req5= new MyRequest(ses,prod);
		
		Thread t1= new Thread(req1);
		Thread t2= new Thread(req2);
		Thread t3= new Thread(req3);
		Thread t4= new Thread(req4);
		Thread t5= new Thread(req5);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		
		//give some time to execute 
		Thread.sleep(3000000);
		//close ses obj
		ses.close();
		
		//close factory obj
		factory.close();
	}//main

}//class
