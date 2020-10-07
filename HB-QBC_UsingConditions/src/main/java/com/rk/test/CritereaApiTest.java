package com.rk.test;

import java.util.List;

//import javax.persistence.criteria.Order;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
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
			//prepare Criteria object
			Criteria criteria=ses.createCriteria(Project.class);
			//prepare Criterion objects
			Criterion cond1=Restrictions.ge("teamsize",10);
			Criterion cond2=Restrictions.le("teamsize",20);
			//add Criterion objs to Criteria object
			criteria.add(cond1); criteria.add(cond2);
			//Order object
			Order order1=Order.asc("location");
			Order order=Order.desc("ProjName");
			criteria.addOrder(order);
			criteria.addOrder(order1);
			//execute QBC logic
			List<Project> list=criteria.list();
			//process results
			list.forEach(System.out::println);
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
