package com.rk.test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rk.entity.PersionInfo;
import com.rk.utilty.HibernetUtil;

public class DateTest {

	public static void main(String[] args) {

		//read inputs
		Session ses=null;
		PersionInfo info=null;
		Transaction tx=null;
		Boolean flag=false;
		
		//get session
		ses=HibernetUtil.getSession();
		
		//Prepare Entity object
		info= new PersionInfo();
		
		//set values
		info.setPname("rakesh");
		info.setPaddrs("bbsr");
		info.setDob(LocalDateTime.of(1990,10,5,11,23,56));
		info.setDoj(LocalTime.now());
		info.setDom(LocalDate.of(99,10,23));
	
	try {
		//begin tx
		tx=ses.beginTransaction();
	
		//save object
		ses.save(info);
		flag=true;
	}
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
	
	//object or not
	finally
	{
		if(flag)
		{
			tx.commit();
			System.out.println("date info is saved::");
			
		}
		else
		{
			tx.rollback();
			System.out.println("date info is not saved::");
		}
		
		//close session obj
		HibernetUtil.closeSession(ses);
		HibernetUtil.closeSessionFactory();
	}//finally
	
	}//main

}//class
