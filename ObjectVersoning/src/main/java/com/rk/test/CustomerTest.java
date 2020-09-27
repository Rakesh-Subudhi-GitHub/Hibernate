package com.rk.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rk.entity.MobileCustInfo;
import com.rk.utilty.HibernetUtil;

public class CustomerTest {

	public static void main(String[] args) {

		//read inputs
		Session ses=null;
		Transaction tx=null;
		MobileCustInfo info=null;
		Boolean flag=false;
		
		//get session obj
		ses=HibernetUtil.getSession();
		
		//get param values
		info= new MobileCustInfo();
		
		//set values
		info.setCname("raka");
		info.setPhon(9898989898l);
		info.setCaddrs("hyd");
		info.setCallerTune("dil jane");
		
		try {
			//begin tx
			tx=ses.beginTransaction();
			
			//save obj
			ses.save(info);
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
		
		//save obj or not
		finally {
			if(flag)
			{
				tx.commit();
				System.out.println("customer data save");
			}
			else
			{
				tx.rollback();
				System.out.println("customer data not save");
			}
			
			//close obj
			HibernetUtil.closeSession(ses);
			HibernetUtil.closeSessionFactory();
		
		}//finally
		
		}//main
		
	}//class


