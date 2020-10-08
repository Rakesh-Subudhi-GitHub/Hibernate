package com.rk.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
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
			
			//create or Locate Tx
			if(!ses.getTransaction().isActive())
		           tx=ses.beginTransaction();
			
			// Create Criteria object
			Criteria criteria=ses.createCriteria(Project.class);
			
			//prepare Projection object for aggragate result 
			Projection p1=Projections.max("cost");
            
			//add Projection to Criteria
			criteria.setProjection(p1);
			
			//execute QBC logic
			List<Long> list=criteria.list();
			
			//process results
			System.out.println("records count::"+list.get(0));
					
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
