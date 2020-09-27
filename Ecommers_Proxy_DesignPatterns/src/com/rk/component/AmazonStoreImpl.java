package com.rk.component;

import java.util.stream.DoubleStream;

public class AmazonStoreImpl implements EcommersStore{

	
	
//	@Override
//	public float shopping(String[] items, double[] price) {
//System.out.println("impl under shoping method calling");
//double total=0.0d;
//
////calling instance for loop
//		for(double p:price)
//			total=total+p;
//	
//		return total;
//	}//method
	
	@Override
	public double shopping(String[] items, double[] price) {
		
		System.out.println("impl under shoping method calling");
	double billamt=0.0d;
		
	billamt=DoubleStream.of(price).sum();
			//its new  java8+ this just like collect for price and its store in DoubleStream.of(price) and also calling sum() and add it and store billamt
	
		return billamt;   //return billamt to EcommersStore.interface
	}//method

}//class
