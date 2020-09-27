package com.rk.utility;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;
import org.hibernate.service.ServiceRegistry;

import com.rk.service.UserConnectionService;

public class HibernateUtil {
	
	private static SessionFactory factory;

	
	static  //class load then it automatically load bcz its called static method so that
	{
		//read inputs
		Configuration cfg =null;
		StandardServiceRegistryBuilder builder=null;
		ServiceRegistry registry=null;
		
		
		//build factory obj
		try{
		
			//bootstrap hibernate
			cfg= new Configuration();
			cfg.configure("com/rk/cfgs/hibernate.cfg.xml");
			cfg.addResource("com/rk/entity/InsurancePolicy.hbm.xml");
			
			//build ServiceRegistry
			 builder=new StandardServiceRegistryBuilder();
			 //add service
			 builder.addService(ConnectionProvider.class, new UserConnectionService());
			 //create ServiceRegistry
			 registry=builder.applySettings(cfg.getProperties()).build();
			
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
			ses=factory.openSession();
		
		return ses;
	
	}//getSession
	
	//close session
	public static void closeSession(Session ses)
	{
		if(ses!= null)
		ses.close();
		
	}//close
	
	//close SessionFactory
	public static void closeSessionFacory()
	{
		if(factory!= null)
			factory.close();
		
	}//close

}//class
