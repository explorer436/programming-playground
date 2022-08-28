package com.example.assignment.model;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Transaction {
	
	String customerId;
	float amountSpent;
    LocalDate dateOfTransaction;

}
