package com.rk.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rk.entity.MobileCustInfo;
import com.rk.utilty.HibernetUtil;

public class 	UpdateCustomerTest {

	public static void main(String[] args) {

		//read inputs
		Session ses=null;
		Transaction tx=null;
		MobileCustInfo info=null;
		Boolean flag=false;
		
		//get session obj
		ses=HibernetUtil.getSession();
		
		try {
		
			//begin tx
			tx=ses.beginTransaction();
			
			//Load Object
			info= ses.get(MobileCustInfo.class,5);
			if(info!=null)
			{
				System.out.println("find and show it:::::::::::::::::::::::::");
				info.setCaddrs("bbsr");
				
				//save obj
				ses.save(info);
				flag=true;
				System.out.println(info);
			}
			else
			{
				System.out.println("record not found::::::::::::");
			}
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
		
		//save obj or not
		finally {
			
			if(flag)
			{
				tx.commit();
				System.out.println("customer data updated");
			}
			else
			{
				tx.rollback();
				System.out.println("customer data not updated");
			}
			
			//close obj
			HibernetUtil.closeSession(ses);
			HibernetUtil.closeSessionFactory();
		
		}//finally
		
		}//main
		
	}//class


