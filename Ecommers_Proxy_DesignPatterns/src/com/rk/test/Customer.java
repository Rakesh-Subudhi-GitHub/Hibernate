package com.rk.test;

import com.rk.component.EcommersStore;
import com.rk.factory.EcommersStoreFactory;

public class Customer {

	public static void main(String[] args) {

		System.out.println("main mehod calling::");
		
		//read obj
		EcommersStore store=null;//calling interface
		
		//calling with main
		store=EcommersStoreFactory.getInstance("am10");
		System.out.println("discount coupan code haichi ::::am10:::");
		System.out.println("jana nahi kauthi asiba::");
		System.out.println();
		System.out.println(store.getClass());
		System.out.println("same jana nahi");
		System.out.println();
		System.out.println("Bill amount ::"+store.shopping(new String[] {"abc","xyz"}, new double[] {500,500}));
	System.out.println();
	System.out.println("bill pasila pare");
	}//main
}//main
