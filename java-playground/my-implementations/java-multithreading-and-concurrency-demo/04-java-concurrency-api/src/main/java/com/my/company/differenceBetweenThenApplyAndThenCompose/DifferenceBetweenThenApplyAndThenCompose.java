package com.my.company.differenceBetweenThenApplyAndThenCompose;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class DifferenceBetweenThenApplyAndThenCompose {
	
	CompletableFuture<Integer> compute() {
		return CompletableFuture.supplyAsync(() -> 25);
    }	

	CompletableFuture<Integer> computeAnother(Integer i){
	    return CompletableFuture.supplyAsync(() -> 10 + i);
	}

	CompletableFuture<User> getUserDetail(String userId) {
		return CompletableFuture.supplyAsync(() -> {
			return new UserService().getUserDetails(userId);
		});	
	}
	
	CompletableFuture<Double> getCreditRating(User user) {
		return CompletableFuture.supplyAsync(() -> {
			return new CreditRatingService().getCreditRating(user);
		});
	}	
	
}
