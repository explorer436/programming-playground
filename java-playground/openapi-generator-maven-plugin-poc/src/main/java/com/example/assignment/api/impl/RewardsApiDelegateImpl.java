package com.example.assignment.api.impl;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.assignment.model.Transaction;
import com.example.assignment.rewards.api.RewardsApiDelegate;
import com.example.assignment.rewards.model.Reward;
import com.example.assignment.rewards.model.Rewards;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RewardsApiDelegateImpl implements RewardsApiDelegate {
	
	private final HelperUtility helperUtility;

	@Override
	public ResponseEntity<Rewards> getRewardsByCustomerId(String customerId) {
		
		Rewards rewards = getRewards(customerId);
		return ResponseEntity.ok(rewards);
	}

	private Rewards getRewards(String customerId) {
		
		LocalDate now = LocalDate.now();
		LocalDate currentMonthMinusOne = now.minusMonths(1);
		LocalDate currentMonthMinusTwo = now.minusMonths(2);
		LocalDate currentMonthMinusThree = now.minusMonths(3);
		
		Rewards rewards = new Rewards();
		rewards.setCustomerId(customerId);
		rewards.addRewardsItem(getRewardsPerMonth(customerId, currentMonthMinusOne));
		rewards.addRewardsItem(getRewardsPerMonth(customerId, currentMonthMinusTwo));
		rewards.addRewardsItem(getRewardsPerMonth(customerId, currentMonthMinusThree));
		rewards.setTotalRewardPointsForPastThreeMonths(
				rewards.getRewards()
					.stream()
					.mapToInt(Reward::getRewardPoints)
							.reduce(
								0,
								(a, b) -> a + b));
		rewards.setTotalPurchaseAmountForPastThreeMonths(
				rewards.getRewards()
				.stream()
				.mapToDouble(Reward::getPurchaseAmount)
						.reduce(
							0,
							(a, b) -> a + b)
				);
		return rewards;
	}

	private Reward getRewardsPerMonth(String customerId, LocalDate monthNumber) {
		
		LocalDate monthNumberMinusOneStartDate = monthNumber.with(TemporalAdjusters.firstDayOfMonth());
		LocalDate monthNumberMinusOneEndDate = monthNumber.with(TemporalAdjusters.lastDayOfMonth());
		
		double purchaseAmountInTheMonth = amountSpentByCustomerInAMonth(customerId, monthNumberMinusOneStartDate, monthNumberMinusOneEndDate);
		
		Reward r = new Reward();
		r.setPurchaseAmount(purchaseAmountInTheMonth);
		r.setMonth(monthNumber.getMonth().name());
		r.setRewardPoints(helperUtility.getPointsFromPurchaseAmount(purchaseAmountInTheMonth));
		return r;
	}

	private double amountSpentByCustomerInAMonth(String cusId, LocalDate startDate, LocalDate endDate) {
		double amountSpentInAMonth = getTransactions()
				.stream()
				.filter(t ->  StringUtils.equals(cusId, t.getCustomerId()))
				.filter(t ->  contains(t.getDateOfTransaction(), startDate, endDate))
				.mapToDouble(Transaction::getAmountSpent)
				.reduce(
						0,
						(a, b) -> a + b);
		return amountSpentInAMonth;
	}
	
	public boolean contains ( LocalDate testDate, LocalDate start, LocalDate stop ) {
        // Regarding the beginning date, a short way of saying2 "is equal to or is later than" is "is not before".
        boolean x = ( ! testDate.isBefore( start ) ) && testDate.isBefore( stop );
        return x;
    }

	private List<Transaction> getTransactions() {
		List<Transaction> transactions = new ArrayList<>();
		
		transactions.add(Transaction.builder().customerId("1").amountSpent(110).dateOfTransaction(LocalDate.of(2022, 5, 1)).build());
		transactions.add(Transaction.builder().customerId("1").amountSpent(120).dateOfTransaction(LocalDate.of(2022, 4, 1)).build());
		transactions.add(Transaction.builder().customerId("1").amountSpent(130).dateOfTransaction(LocalDate.of(2022, 3, 1)).build());
		transactions.add(Transaction.builder().customerId("1").amountSpent(140).dateOfTransaction(LocalDate.of(2022, 2, 1)).build());
		
		transactions.add(Transaction.builder().customerId("2").amountSpent(80).dateOfTransaction(LocalDate.of(2022, 5, 1)).build());
		transactions.add(Transaction.builder().customerId("2").amountSpent(90).dateOfTransaction(LocalDate.of(2022, 4, 1)).build());
		transactions.add(Transaction.builder().customerId("2").amountSpent(100).dateOfTransaction(LocalDate.of(2022, 3, 1)).build());
		transactions.add(Transaction.builder().customerId("2").amountSpent(110).dateOfTransaction(LocalDate.of(2022, 2, 1)).build());
		
		transactions.add(Transaction.builder().customerId("3").amountSpent(160).dateOfTransaction(LocalDate.of(2022, 5, 1)).build());
		transactions.add(Transaction.builder().customerId("3").amountSpent(170).dateOfTransaction(LocalDate.of(2022, 4, 1)).build());
		transactions.add(Transaction.builder().customerId("3").amountSpent(180).dateOfTransaction(LocalDate.of(2022, 3, 1)).build());
		transactions.add(Transaction.builder().customerId("3").amountSpent(190).dateOfTransaction(LocalDate.of(2022, 2, 1)).build());
		
		transactions.add(Transaction.builder().customerId("4").amountSpent(200).dateOfTransaction(LocalDate.of(2022, 5, 1)).build());
		transactions.add(Transaction.builder().customerId("4").amountSpent(210).dateOfTransaction(LocalDate.of(2022, 4, 1)).build());
		transactions.add(Transaction.builder().customerId("4").amountSpent(220).dateOfTransaction(LocalDate.of(2022, 3, 1)).build());
		transactions.add(Transaction.builder().customerId("4").amountSpent(230).dateOfTransaction(LocalDate.of(2022, 2, 1)).build());
		
		return transactions;
	}
}