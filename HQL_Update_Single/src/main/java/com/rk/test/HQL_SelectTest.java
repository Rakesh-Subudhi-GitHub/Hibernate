package com.rk.test;

import java.util.List;
import java.util.Optional;
import java.util.Iterator;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.rk.entity.InsurancePolicy;
import com.rk.utility.HibernateUtil;

public class HQL_SelectTest {

	public static void main(String[] args) {
		Session ses=null;
		Transaction tx=null;
		//Query<InsurancePolicy> query=null;
		//List<InsurancePolicy> list=null;
		
	     //get Session obj
		ses=HibernateUtil.getSession();
		try {
			tx=ses.beginTransaction(); //dummy
		
			//prepare Query
			Query query=ses.createQuery("UPDATE com.rk.entity.InsurancePolicy SET tenure=tenure+ :bonous WHERE POLICY_NAME like :cond");
			
			//set query param
			query.setParameter("bonous",10);
			query.setParameter("cond","r%");
			
			//execute HQL query
			int count=query.executeUpdate();
			
			if(count==0)
			{
				System.out.println("recond not executed::");
			}
			else
			{
				System.out.println(count+" recod modify succesfuly");
			}
		
	  }		//try
		
		catch(HibernateException he) {
			he.printStackTrace();
		}
		
		finally {
			HibernateUtil.closeSessionFacory();
		}

	}//main
}//class