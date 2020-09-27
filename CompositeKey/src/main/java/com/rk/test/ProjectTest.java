package com.rk.test;

//import javax.transaction.Transaction;

//import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rk.entity.ProgrProjID;
import com.rk.entity.ProgramersProjectInfo;
import com.rk.util.HibernetUtil;

public class ProjectTest {

	public static void main(String[] args) {
		
		//read inputs
		Session ses=null;
		Transaction tx=null;
		
		ProgramersProjectInfo info=null;
		ProgrProjID id=null;
		
		Boolean flag=false;
		
		//get Session
		ses=HibernetUtil.getSession();
	
		try {
		//called  Entity class
		info= new ProgramersProjectInfo();
		id= new ProgrProjID();
		
		//set query 1st params values
		id.setPid(111);
		id.setProjid(9909);
		
		//set query 2nd params values
		info.setId(id);//bcz its link to fast
		info.setPname("rakesh");
		info.setProjName("bbsr");
		info.setDeptno(55);
	
		//save obj
		id=(ProgrProjID) ses.save(info);//id is store the id values 
		System.out.println("Generate id value is:: "+id);
		flag= true;
		
		}//try
		catch(Exception se)
		{
			se.printStackTrace();
		flag=false;
		}
		
		//check flag value 
		finally {

			//Perform TxMgmt
			if(flag) {
				tx.commit();
				System.out.println("object is saved");
			}
			else {
				//tx.rollback();
				System.out.println("Object is not saved");
			}

			//close objs
			HibernetUtil.closeSession(ses);
			HibernetUtil.closeSessionFactory();
		}//finally
		
	}//main

}//class
