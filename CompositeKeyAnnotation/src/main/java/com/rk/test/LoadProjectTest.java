package com.rk.test;

//import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rk.entity.ProgrProjID;
import com.rk.entity.ProgramersProjectInfo;
import com.rk.util.HibernetUtil;

public class LoadProjectTest {

	public static void main(String[] args) {
		
		//read inputs
		Session ses=null;
		Transaction tx=null;
		
		ProgramersProjectInfo info=null;
		ProgrProjID id=null;
		
		//get Session
		ses=HibernetUtil.getSession();
	
		try {
			
		//called  Entity class
		id= new ProgrProjID();
		
		//set query 1st params values
		id.setPid(100);
		
		 //load object
	       info=ses.get(ProgramersProjectInfo.class, id);
	       
	       if(info!=null)
	       {
	    	   System.out.println(" object show ");
	    	   System.out.println(info);
	       }
	    	   else
	    	   System.out.println("record not found");
		
		}//try
		catch(Exception se)
		{
			se.printStackTrace();
			}
		
		//check flag value 
		finally {
	
			//close objs
			HibernetUtil.closeSession(ses);
			HibernetUtil.closeSessionFactory();
		}//finally
		
	}//main

}//class
