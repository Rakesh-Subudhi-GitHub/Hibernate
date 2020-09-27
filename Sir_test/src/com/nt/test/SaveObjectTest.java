package com.nt.test;



import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.entity.Product;

public class SaveObjectTest {

	public static void main(String[] args) {
		
		//read inputs
		 Configuration cfg=null;
		 SessionFactory factory=null;
		 Session ses=null;
		 Product prod=null;
		 Transaction tx=null;
		 boolean flag=false;
		 
		 //Activate Hibernate f/w (BootStrap hibernate)
		  cfg=new Configuration();
		 System.out.println("1st");
		  
		 //supply hiberante cfg file as input file
		  cfg.configure("com/nt/cfg/product.cfg.xml");
		  
		  System.out.println("2nd after cfg");
		  
		  //build Session Factory
		  factory=cfg.buildSessionFactory();
		  
		  //open Session
		  ses=factory.openSession();
		  
		  //create Entity  object to save with Db s/w
		  prod=new Product();
		 System.out.println("3rd calling method");
		  prod.setPid(855); prod.setPname("chair"); prod.setPrice(60000); prod.setQty(2);
		  try {
			  tx=ses.beginTransaction();    //internally calls  con.setAutoCommit(false) to begin the Tx
			      //save object
			     ses.save(prod);
			     flag=true;
		  }
		  catch(HibernateException he) {
			  he.printStackTrace();
			  flag=false;
		  }
		  finally {
			   //commit or rollback  Tx
			    if(flag==true) {
			    	   tx.commit();  //internally calls con.commit()
			    	   System.out.println("Object is saved");
			    }
			    else {
			    	tx.rollback(); //internally calls  con.rollback()
			    	 System.out.println("Object is not saved");
			    }    
			    //close  session object
			    ses.close();
			    //close SessionFactroy
			    factory.close();
		  }//finally
		  

	}//main
}//class