package com.rk.entity;

import java.io.Serializable;

public class Delete_Account implements Serializable {

	// 0- pram Constructor
		public Delete_Account() {
	System.out.println("create a 0-param constructor for update account::: ");
		}

		private Integer acc_no;
		private String acc_name;
		private String acc_add;
		private String acc_type;
		private float acc_bal;
		
		//setters & getters
		public Integer getAcc_no() {
			return acc_no;
		}
		public void setAcc_no(Integer acc_no) {
			this.acc_no = acc_no;
		}
		public String getAcc_name() {
			return acc_name;
		}
		public void setAcc_name(String acc_name) {
			this.acc_name = acc_name;
		}
		public String getAcc_add() {
			return acc_add;
		}
		public void setAcc_add(String acc_add) {
			this.acc_add = acc_add;
		}
		public String getAcc_type() {
			return acc_type;
		}
		public void setAcc_type(String acc_type) {
			this.acc_type = acc_type;
		}
		public float getAcc_bal() {
			return acc_bal;
		}
		public void setAcc_bal(float acc_bal) {
			this.acc_bal = acc_bal;
		}
		
		//show out put 
		@Override
		public String toString() {
			return "UpdateAccount [acc_no=" + acc_no + ", acc_name=" + acc_name + ", acc_add=" + acc_add + ", acc_type="
					+ acc_type + ", acc_bal=" + acc_bal + "]";
		}
}
