package com.priceminister.account.implementation;

import com.priceminister.account.*;


public class CustomerAccount implements Account {

    public void add(Double addedAmount) {
    	if(addedAmount>0)
    	balance = Double.valueOf(balance + addedAmount);
    }

    public Double getBalance() {
    	return balance;
    }

    public Double withdrawAndReportBalance(Double withdrawnAmount, AccountRule rule) 
    		throws IllegalBalanceException {
    	Double balanceAfterWithdraw = balance - withdrawnAmount;
        if(!rule.withdrawPermitted(balanceAfterWithdraw)) throw new IllegalBalanceException(balanceAfterWithdraw);
        balance = Double.valueOf(balanceAfterWithdraw);
        return balance;
    }

}
