package com.example.assignment.service;

import com.example.assignment.model.Transaction;
import io.grpc.stub.StreamObserver;
import io.quarkus.grpc.GrpcService;
import lombok.RequiredArgsConstructor;
import openapitools.RewardOuterClass;
import openapitools.RewardsOuterClass;
import openapitools.services.rewardsservice.RewardsServiceGrpc;
import openapitools.services.rewardsservice.RewardsServiceOuterClass;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

@GrpcService
@RequiredArgsConstructor
public class RewardsGrpcService extends RewardsServiceGrpc.RewardsServiceImplBase {

    @Value("${points.tier1.purchaseAmount}")
    private int pointsTier1PurchaseAmount;

    @Value("${points.tier1.perDollar}")
    private int pointsTier1PerDollar;

    @Value("${points.tier2.purchaseAmount}")
    private int pointsTier2PurchaseAmount;

    @Value("${points.tier2.perDollar}")
    private int pointsTier2PerDollar;

    @Override
    public void getRewardsByCustomerId(RewardsServiceOuterClass.GetRewardsByCustomerIdRequest request, StreamObserver<RewardsOuterClass.Rewards> responseObserver) {
        String customerId = request.getCustomerId();

        RewardsOuterClass.Rewards response = getRewards(customerId);
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    private RewardsOuterClass.Rewards getRewards(String customerId) {

        LocalDate now = LocalDate.now();
        LocalDate currentMonthMinusOne = now.minusMonths(1);
        LocalDate currentMonthMinusTwo = now.minusMonths(2);
        LocalDate currentMonthMinusThree = now.minusMonths(3);

        List<RewardOuterClass.Reward> rewardList = new ArrayList<>();
        rewardList.add(getRewardsPerMonth(customerId, currentMonthMinusOne));
        rewardList.add(getRewardsPerMonth(customerId, currentMonthMinusTwo));
        rewardList.add(getRewardsPerMonth(customerId, currentMonthMinusThree));

        int totalRewardPointsForPastThreeMonths = rewardList
                .stream()
                .mapToInt(RewardOuterClass.Reward::getRewardPoints)
                .reduce(
                        0,
                        (a, b) -> a + b);

        double totalPurchaseAmountForPastThreeMonths = rewardList
                .stream()
                .mapToDouble(RewardOuterClass.Reward::getPurchaseAmount)
                .reduce(
                        0,
                        (a, b) -> a + b);

        RewardsOuterClass.Rewards rewards = RewardsOuterClass.Rewards.newBuilder()
                .setCustomerId(customerId)
                .addAllRewards(rewardList)
                .setTotalRewardPointsForPastThreeMonths(totalRewardPointsForPastThreeMonths)
                .setTotalPurchaseAmountForPastThreeMonths(totalPurchaseAmountForPastThreeMonths)
                .build();

        return rewards;
    }

    private RewardOuterClass.Reward getRewardsPerMonth(String customerId, LocalDate monthNumber) {

        LocalDate monthNumberMinusOneStartDate = monthNumber.with(TemporalAdjusters.firstDayOfMonth());
        LocalDate monthNumberMinusOneEndDate = monthNumber.with(TemporalAdjusters.lastDayOfMonth());

        double purchaseAmountInTheMonth = amountSpentByCustomerInAMonth(customerId, monthNumberMinusOneStartDate, monthNumberMinusOneEndDate);

        RewardOuterClass.Reward r = RewardOuterClass.Reward.newBuilder()
                .setPurchaseAmount(purchaseAmountInTheMonth)
                .setMonth(monthNumber.getMonth().name())
                .setRewardPoints(getPointsFromPurchaseAmount(purchaseAmountInTheMonth))
                .build();
        return r;
    }

    private double amountSpentByCustomerInAMonth(String cusId, LocalDate startDate, LocalDate endDate) {
        double amountSpentInAMonth = getTransactions()
                .stream()
                .filter(t -> StringUtils.equals(cusId, t.getCustomerId()))
                .filter(t -> contains(t.getDateOfTransaction(), startDate, endDate))
                .mapToDouble(Transaction::getAmountSpent)
                .reduce(
                        0,
                        (a, b) -> a + b);
        return amountSpentInAMonth;
    }

    public boolean contains(LocalDate testDate, LocalDate start, LocalDate stop) {
        // Regarding the beginning date, a short way of saying2 "is equal to or is later than" is "is not before".
        boolean x = (!testDate.isBefore(start)) && testDate.isBefore(stop);
        return x;
    }

    private List<Transaction> getTransactions() {
        List<Transaction> transactions = new ArrayList<>();

        transactions.add(Transaction.builder().customerId("1").amountSpent(210).dateOfTransaction(LocalDate.of(2023, 11, 1)).build());
        transactions.add(Transaction.builder().customerId("1").amountSpent(200).dateOfTransaction(LocalDate.of(2023, 10, 1)).build());
        transactions.add(Transaction.builder().customerId("1").amountSpent(190).dateOfTransaction(LocalDate.of(2023, 9, 1)).build());
        transactions.add(Transaction.builder().customerId("1").amountSpent(180).dateOfTransaction(LocalDate.of(2023, 8, 1)).build());
        transactions.add(Transaction.builder().customerId("1").amountSpent(170).dateOfTransaction(LocalDate.of(2023, 7, 1)).build());
        transactions.add(Transaction.builder().customerId("1").amountSpent(160).dateOfTransaction(LocalDate.of(2023, 6, 1)).build());
        transactions.add(Transaction.builder().customerId("1").amountSpent(150).dateOfTransaction(LocalDate.of(2023, 5, 1)).build());
        transactions.add(Transaction.builder().customerId("1").amountSpent(140).dateOfTransaction(LocalDate.of(2023, 4, 1)).build());
        transactions.add(Transaction.builder().customerId("1").amountSpent(130).dateOfTransaction(LocalDate.of(2023, 3, 1)).build());
        transactions.add(Transaction.builder().customerId("1").amountSpent(120).dateOfTransaction(LocalDate.of(2023, 2, 1)).build());
        transactions.add(Transaction.builder().customerId("1").amountSpent(110).dateOfTransaction(LocalDate.of(2023, 1, 1)).build());

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
