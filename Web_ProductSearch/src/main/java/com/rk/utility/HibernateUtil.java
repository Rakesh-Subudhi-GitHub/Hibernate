package com.rk.utility;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	//read inputs
	private static SessionFactory factory;
	private static ThreadLocal<Session>threadLocal= new ThreadLocal();
	
	static {
		Configuration cfg=null;
		
		try {
			
			//boot strap Hibernate
			cfg= new Configuration();
			cfg.configure("com/rk/cfgs/hibernate.cfgs.xml");
			
			//build session factory
			factory=cfg.buildSessionFactory();
			
			
		}//try
		
		catch(HibernateException he)
		{
			System.out.println("hibernate configer session problem:::::::");
			System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			he.printStackTrace();
		}
		catch(Exception e)
		{
			System.out.println("session problem:::::::::::::::::::");
			System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			e.printStackTrace();
		}
		
	}//static
	
	//get session method called
	public  static Session getSession()
	{
		Session ses=null;
		
		//get Session object form ThreadLocal
		ses=threadLocal.get();
		
		if(ses==null)
		{
			if(factory != null)
			{
				ses=factory.openSession();
				threadLocal.set(ses);
			}
		}//if
		System.out.println("session is called :::");
		return ses;
		
	}//get session method
	
	//close session so create a method
	public static void closeSession()
	{
		Session ses=null;
		ses=threadLocal.get();
		
		if(ses!=null)
		{
			ses.close();
			System.out.println("close session block::::::::");
			threadLocal.remove();
		}//if
		
	}//closeSession
	
	//close session factory so create a Session factory method
	public static void closeSessionFactory()
	{
		if(factory!=null)
			factory.close();
		System.out.println("session factory closed:::::::::");
	
	}//closeSessionfactory 

}//class
