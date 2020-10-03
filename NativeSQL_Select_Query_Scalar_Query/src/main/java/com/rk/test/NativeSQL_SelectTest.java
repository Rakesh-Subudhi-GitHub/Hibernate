package com.rk.test;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.query.NativeQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.type.StandardBasicTypes;

import com.rk.entity.InsurancePolicy;
import com.rk.utility.HibernateUtil;
import com.sun.xml.bind.api.impl.NameConverter.Standard;

public class NativeSQL_SelectTest {

	public static void main(String[] args) {
		Session ses=null;
		Transaction tx=null;
		
	     //get Session obj
		ses=HibernateUtil.getSession();
		
		try {
			if(!ses.getTransaction().isActive())
			tx=ses.beginTransaction(); //dummy
		
			//prepare Query
			NativeQuery<Object[]> query=ses.createSQLQuery("SELECT POLICY_ID,POLICY_NAME FROM Insurance_Policy where COMPANY in(:comp1,:comp2)");
			
			//set query param values
			query.setParameter("comp1","mnm");
			query.setParameter("comp2","ctc");
			
			//================================converting datatype in control================================ 
			//its not then also print it
			query.addScalar("POLICY_ID",StandardBasicTypes.INTEGER);
			query.addScalar("POLICY_NAME",StandardBasicTypes.STRING);
			
			//execute query 
			List<Object[]> list=query.getResultList();//Previous version its support its
		
			//process the result set
			list.forEach(row->{
				for(Object o:row)
				{
					System.out.print(o+" ");
				}
				System.out.println();
			});
			
		}//try
		
		catch(HibernateException he) {
			he.printStackTrace();
		}
		
		finally {
			HibernateUtil.closeSessionFacory();
		}

	}//main
}//class