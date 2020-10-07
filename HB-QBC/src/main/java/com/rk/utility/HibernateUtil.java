package com.rk.utility;

import javax.imageio.spi.ServiceRegistry;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.rk.entity.Project;

public class HibernateUtil {
	
	private static SessionFactory factory;

	
	static  //class load then it automatically load bcz its called static method so that
	{
		//read inputs
		Configuration cfg =null;
		StandardServiceRegistryBuilder builder=null;
		StandardServiceRegistry registry=null;
		
		//build factory obj
		try{
		
			//bootstrap hibernate
			cfg= new Configuration();
			cfg.configure("com/rk/cfgs/hibernate.cfg.xml");
			 
			cfg.addAnnotatedClass(Project.class); //for annoated classes
			 //build ServiceRegistry
			 builder=new StandardServiceRegistryBuilder();
			 //create ServiceRegistry
			 registry=builder.applySettings(cfg.getProperties()).build();
			 //build SessionFactory
			 factory=cfg.buildSessionFactory(registry);
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
