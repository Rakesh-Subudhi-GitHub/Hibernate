package com.rk.utility;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private static SessionFactory factory;

	
	static  //class load then it automatically load bcz its called static method so that
	{
		//read inputs
		Configuration cfg =null;
		
		
		//build factory obj
		try{
		
			//bootstrap hibernate
			cfg= new Configuration();
			cfg.configure("com/rk/cfgs/hibernate.cfg.xml");
			cfg.addResource("com/rk/entity/InsurancePolicy.hbm.xml");
			
			cfg.addResource("com/rk/entity/PremiumInsurancePolicy.hbm.xml");
			
			//build SessionFactory
			factory=cfg.buildSessionFactory();
			
		}//try
		catch(HibernateException he)
		{
			he.printStackTrace();
		}
	}//static
	
	// build session help of factory obj
	public static Session getSession()
	{
		Session ses=null;
		
		if(factory!=null)
			ses=factory.getCurrentSession();
		
		return ses;
	
	}//getSession
	
	//close SessionFactory
	public static void closeSessionFacory()
	{
		if(factory!= null)
			factory.close();
		
	}//close

}//class
