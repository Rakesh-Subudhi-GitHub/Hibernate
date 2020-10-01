package com.rk.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.rk.utility.HibernateUtil;

public class InsurancePolicyDAOImpl implements InsurancePolicyDAO {

	//query
	private static final String HQL_INSERT_QUERY="INSERT INTO com.rk.entity.PremiumInsurancePolicy(policy_id,policy_name,company,tenure)SELECT i.policy_id,i.policy_name,i.company,i.tenure FROM com.rk.entity.InsurancePolicy as i WHERE i.tenure>= :min";
	
	@Override
	public String transferPremiumInsurancePolicy(int minTenuer) {
		
		//read inputs
		Session ses=null;
		Transaction tx=null;
		
		int count=0;
		Query query=null;
		Boolean flag=false;
		String msg=null;
		
		//get session
		ses=HibernateUtil.getSession();
		
		//main code
		try {
			
			//begin tx
			tx=ses.beginTransaction();
			
			//prepare Query object
			query=ses.createQuery(HQL_INSERT_QUERY);
					
			//set query params
			query.setParameter("min",minTenuer);//minTenuer value insert min obj
			
			//execute query
			count=query.executeUpdate();
			flag=true;
			
			}//try
		
		catch(HibernateException he)
		{
			he.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		//flag or commit value check
		finally {
			if(flag)
			{
				tx.commit();
				msg= "num of record affect is:: "+count;
			}
			else
			{
				tx.rollback();
				msg="no record affectted";
			}
		
		}//finally
		
	return msg;
	
	}//method

}//class
