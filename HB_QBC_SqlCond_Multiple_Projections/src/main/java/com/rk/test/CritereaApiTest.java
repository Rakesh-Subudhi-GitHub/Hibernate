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
			
		//create or locate Tx
			if(!ses.getTransaction().isActive())
				tx=ses.beginTransaction();
			
			//prepared Criteria object
			Criteria criteria=ses.createCriteria(Project.class);
			
			//Create Projection for single project
			Projection p1=Projections.property("Company");
			Projection p2=Projections.property("projid");
			
			//add Projections to ProjectionList object
			ProjectionList pList=Projections.projectionList();
			pList.add(p1); 
			pList.add(p2);
			
			//create ProjectionList to Criteria
			criteria.setProjection(pList);
			
			//execute QBC logic
			List<Object[]> list=criteria.list();
			
			//process results
			list.forEach(row->{
				System.out.println(row[0]+"......"+row[1]);
			});
					
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
