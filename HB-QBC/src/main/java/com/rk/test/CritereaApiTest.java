package com.rk.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rk.entity.Project;
import com.rk.utility.HibernateUtil;

public class CritereaApiTest {

	public static void main(String[] args) {
		
		//Read inputs
		Session ses=null;
		Transaction tx=null;
		
		//create session
		ses= HibernateUtil.getSession();
		
		try {
		
			//create or locate tx
			if(!ses.getTransaction().isActive())
				 tx=ses.beginTransaction();
				 
				 //create Criteria
					Criteria criteria=ses.createCriteria(Project.class);
						 
				 //execute QBC logic
					 List<Project> list=criteria.list();
			
					 //process result
					 list.forEach(System.out :: println);
		}//try
		catch(HibernateException he)
		{
			he.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		finally {
			HibernateUtil.closeSessionFacory();
		}
	}//main
}//class
