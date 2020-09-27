package com.rk.provider;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.engine.jdbc.connections.internal.UserSuppliedConnectionProviderImpl;

public class ApacheDBCP2_ConnectionPooled extends UserSuppliedConnectionProviderImpl{
	
	//read inputs
	private BasicDataSource bds;
	
	//constructor calling
	public ApacheDBCP2_ConnectionPooled()
	{
		System.out.println("ApacheDBCP2_ConnectionPooled 0-param constructor calling::::::::::");
		
		bds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		bds.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
		bds.setUsername("rakesh");
		bds.setPassword("devibhai");
		bds.setMinIdle(10);
		bds.setMaxIdle(100);

	}//constructor
	
	@Override
	public Connection getConnection(Connection con)throws SQLException
	{
		System.out.println("get connection calling ::::::::::::::::::::::::");
		return bds.getConnection();
		
	}
	
	@Override
	public void closeConnection(Connection conn)throws SQLException
	{
		System.out.println("close connection calling::::::::::::::::::;");
		conn.close();
	}

}
