package com.rk.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

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
			
		//create or locate Tx
			if(!ses.getTransaction().isActive())
				tx=ses.beginTransaction();
			
			//prepared Criteria object
			Criteria criteria= ses.createCriteria(Project.class);
			
			//prepared Criteria object
			Criterion cond1=Restrictions.between("teamsize", 10,20);
			
			Criterion cond2= Restrictions.in("Company","Abc","Bcd");
		
			Criterion cond3= Restrictions.in("ProjName","p%");
			
			//Create Criterion object having and Clause b/w cond1,cond2 or Clause with cond3
			Criterion finalCond=Restrictions.or(Restrictions.and(cond1,cond2),cond3);
			
			//Add Criterion object to Criteria object
			criteria.add(finalCond);
			
			//execute QBC logic
			List<Project> list= criteria.list();
			
			//show output
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
