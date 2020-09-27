package com.rk.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rk.entity.Membership;
import com.rk.util.HibernetUtil;

public class SaveOrUpdate_Object {

	public static void main(String[] args) {

		//read inputs
		Session ses=null;
		Membership member=null;
		Transaction tx=null;
		boolean flag=false;
		
		//get session object
		ses=HibernetUtil.getSession();
		
		//prepare object
		member= new Membership();
		
		//set param
		member.setMid(12359l);
		member.setName("daddy");
		member.setAddres("rohit");
		member.setReward_points(900l);
try {
	
	
	tx=ses.beginTransaction();
	ses.saveOrUpdate(member);
	flag=true;
	
	//ses.refresh(member);
System.out.println(member);	
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
		System.out.println("object is save or updateed");
		System.out.println(member);
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
