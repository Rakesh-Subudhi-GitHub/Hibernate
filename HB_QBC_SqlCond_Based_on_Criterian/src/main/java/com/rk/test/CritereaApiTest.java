package com.rk.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
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
			Criteria criteria= ses.createCriteria(Project.class);
			
			//prepared Criteria object
			Criterion cond1=Restrictions.sqlRestriction("rowNum>=? and rowNum<=?",
																								new Object[] {1,3},
																								new Type[] {StandardBasicTypes.INTEGER,StandardBasicTypes.INTEGER});
			
			//Add Criterion object to Criteria object
			criteria.add(cond1);
			
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
