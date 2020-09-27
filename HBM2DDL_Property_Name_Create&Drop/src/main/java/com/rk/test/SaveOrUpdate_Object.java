package com.rk.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rk.entity.Product;
import com.rk.util.HibernetUtil;

public class SaveOrUpdate_Object {

	public static void main(String[] args) throws Exception {

		//read inputs
		Session ses=null;
		Product prod=null;
		Transaction tx=null;
		boolean flag=false;
		
		//get session object
		ses=HibernetUtil.getSession();
		
		//prepare object
		prod= new Product();
		
		//set param
	prod.setPid(1010l);
	prod.setName("rakesh");
	prod.setAddres("bbsr");
	prod.setPrice(54879l);
	prod.setType("simple");
		
try {
	tx=ses.beginTransaction();
	ses.merge(prod);
	flag=true;
	
	//ses.refresh(member);
System.out.println(prod);	
	
}//try
	
catch(HibernateException he)
{
	he.printStackTrace();
}
catch(Exception e)
{
	e.printStackTrace();
}

	//finally chek or commet the trasaction
finally {
	
	if(flag)
	{
		tx.commit();
		System.out.println(" create table for Product_test and object is save or updateed");
		System.out.println(prod);
		Thread.sleep(10000);
	}
	else
	{
		System.out.println("object is not save");
		tx.rollback();
		return;
	}
	
	//close obj
	HibernetUtil.closeSession(ses);
	HibernetUtil.closeSessionFactory();
}//finally

	}//main

}//class
