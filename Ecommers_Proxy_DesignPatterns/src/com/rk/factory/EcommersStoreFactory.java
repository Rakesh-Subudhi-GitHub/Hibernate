package com.rk.factory;

import com.rk.component.AmazonStoreImpl;
import com.rk.component.EcommersStore;
import com.rk.proxy.EcommersStoreDiscountProxy;

public class EcommersStoreFactory {

	public EcommersStoreFactory() {
		System.out.println("calling EcommersStoreFactory::");
		System.out.println();
	}
	public static EcommersStore getInstance(String Discount_Coupan_CODE)
	{
		System.out.println("calling EcommersStore :::");
		System.out.println("calling discount is there or no checking::");
		System.out.println();
		if(Discount_Coupan_CODE.equalsIgnoreCase("") || Discount_Coupan_CODE.trim().length()==0)
		{
			System.out.println("no coupan is there");
			return new AmazonStoreImpl();//real with out coupan code normal selling
		}
		else
		{
			System.out.println("if coupan is there then used:::");
			if(Discount_Coupan_CODE.equalsIgnoreCase("AM10"))
			{
				System.out.println("if coupan code is 10 then calling:::");
				return new EcommersStoreDiscountProxy(10);
			}
			else if(Discount_Coupan_CODE.equalsIgnoreCase("AM20"))
			{
				System.out.println("if coupan code is 20 then calling:::");
				return new EcommersStoreDiscountProxy(20);
			}
			else if(Discount_Coupan_CODE.equalsIgnoreCase("AM30"))
			{
				System.out.println("if coupan code is 30 then calling:::");
				return new EcommersStoreDiscountProxy(30);
			}
			else
			{
				System.out.println("if coupan code is 50 then calling:::");
				return new EcommersStoreDiscountProxy(50);
			}
		}//else
	}//method

}//class
