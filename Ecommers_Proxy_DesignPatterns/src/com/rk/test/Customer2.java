package com.rk.test;

import com.rk.component.EcommersStore;
import com.rk.factory.EcommersStoreFactory;

public class Customer2 {

	public static void main(String[] args) {

		System.out.println("main mehod calling::");
		
		//read obj
		EcommersStore store=null;//calling interface
		
		//calling with main
		store=EcommersStoreFactory.getInstance("");
		System.out.println("coupan code use haichini :::no coupan::::::");
		System.out.println("::;;;;;;;;;;");
		System.out.println();
		System.out.println(store.getClass());
		System.out.println("getcallass pare main ra");
		System.out.println();
		System.out.println("Bill amount ::"+store.shopping(new String[] {"abc","xyz"}, new double[] {500,500}));
	System.out.println();
	System.out.println("bill pasila pare");
	}//main
}//main
