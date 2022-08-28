package com.example.assignment.api.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class HelperUtility {
	
	@Value("${points.tier1.purchaseAmount}")
	private int pointsTier1PurchaseAmount;
	
	@Value("${points.tier1.perDollar}")
	private int pointsTier1PerDollar;
	
	@Value("${points.tier2.purchaseAmount}")
	private int pointsTier2PurchaseAmount;
	
	@Value("${points.tier2.perDollar}")
	private int pointsTier2PerDollar;
	
	public int getPointsFromPurchaseAmount(double amount) {
		
		int result = 0;
		
		double amountOverMinimumLimitForPoints = amount - pointsTier1PurchaseAmount;
		
		double amountOverMinimumLimitForExtraPoints = amountOverMinimumLimitForPoints - pointsTier2PurchaseAmount;
		
		if (amountOverMinimumLimitForPoints > 0) {
			if (amountOverMinimumLimitForPoints > pointsTier2PurchaseAmount) {
				result = (int) (result + (pointsTier2PurchaseAmount * pointsTier1PerDollar));
			} else {
				result = (int) (result + (amountOverMinimumLimitForPoints * pointsTier1PerDollar));
			}
		}
		
		if (amountOverMinimumLimitForExtraPoints > 0) {
			result = (int) (result + (amountOverMinimumLimitForExtraPoints * pointsTier2PerDollar));
		}
		
		return result;
	}
}
