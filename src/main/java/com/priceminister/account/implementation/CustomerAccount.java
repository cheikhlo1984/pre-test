package com.priceminister.account.implementation;

import com.priceminister.account.*;


public class CustomerAccount implements Account {

	private Double balance= 0.0d; 
	
	public void add(Double addedAmount) {
		balance += addedAmount;
	}

	public Double getBalance() {
		if (balance == null) {
			balance = new Double(0.0d);
		}
		return balance;
	}

	public Double withdrawAndReportBalance(Double withdrawnAmount, AccountRule rule) 
			throws IllegalBalanceException {

		boolean result = rule.withdrawPermitted(withdrawnAmount);
		
		balance = balance-withdrawnAmount; 
		
		if (result && balance >= 0) {
			return balance;
		}else {
			throw new IllegalBalanceException(withdrawnAmount);
		}
	}

}
