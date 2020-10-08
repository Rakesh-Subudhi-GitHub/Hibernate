package com.rk.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.type.StandardBasicTypes;
import org.hibernate.type.Type;

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
			Criteria criteria=ses.createCriteria(Project.class);
			
			//Create Projection for single project
			Projection p1=Projections.property("Company");
			
			//set projections object to criteria object
			criteria.setProjection(p1);
			
			//prepare creation obj
			Criterion cond=Restrictions.eq("location","hyd");
			
			//add Creation obj
			criteria.add(cond);
			
			//execute QBC logic
			List<String> list= criteria.list();
			
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
