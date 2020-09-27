package com.rk.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rk.entity.MobileCustInfo;
import com.rk.utilty.HibernetUtil;

public class LoadCustomerTest {

	public static void main(String[] args) {

		//read inputs
		Session ses=null;
		Transaction tx=null;
		MobileCustInfo info=null;
		Boolean flag=false;
		
		//get session obj
		ses=HibernetUtil.getSession();
		
		try {
		
			//Load Object
			info= ses.get(MobileCustInfo.class,5);
			if(info!=null)
			{
				System.out.println("find and show it:::::::::::::::::::::::::");
				System.out.println(info);
				System.out.println(info.getVersionCount());
			}
			else
			{
				System.out.println("record not found::::::::::::");
			}
		}//try
		
		//save obj or not
		finally {
			
			//close obj
			HibernetUtil.closeSession(ses);
			HibernetUtil.closeSessionFactory();
		
		}//finally
		
		}//main
		
	}//class


