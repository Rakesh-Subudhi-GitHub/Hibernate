package com.rk.proxy;

import com.rk.component.AmazonStoreImpl;
import com.rk.component.EcommersStore;

public class EcommersStoreDiscountProxy implements EcommersStore {
	
	//calling EcommersStore real class
	private EcommersStore real;
	private float discount;
	
	//create 0param constructor
	public EcommersStoreDiscountProxy(float discount) {
	System.out.println("create 0-param constructor");
	
	this.discount=discount;
	real= new AmazonStoreImpl();//calling amazon store with some discount
	}

	@Override
	public double shopping(String[] items, double[] price) {
		
		System.out.println("under EcommersStoreDiscountProxy with shopping method ");
		
		//read obj
		double billamt=0.0d;
		double finalAmt=0.0d;
		
		//use real obj 
		real.shopping(items, price);
		
		//give discount
		finalAmt=billamt-(billamt*discount/100);
		
		return finalAmt;
	}

}
