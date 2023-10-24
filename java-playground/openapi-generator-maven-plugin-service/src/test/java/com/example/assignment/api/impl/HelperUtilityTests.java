package com.example.assignment.api.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

@ExtendWith(MockitoExtension.class)
public class HelperUtilityTests {
	
	@Spy
	@InjectMocks
	private HelperUtility helperUtility;
	
	@BeforeEach
	void setUp() {
		ReflectionTestUtils.setField(helperUtility, "pointsTier1PurchaseAmount", Integer.valueOf(50));
		ReflectionTestUtils.setField(helperUtility, "pointsTier1PerDollar", Integer.valueOf(1));
		ReflectionTestUtils.setField(helperUtility, "pointsTier2PurchaseAmount", Integer.valueOf(50));
		ReflectionTestUtils.setField(helperUtility, "pointsTier2PerDollar", Integer.valueOf(2));
	}
	
	@Test
	void test1() {
		int actual = helperUtility.getPointsFromPurchaseAmount(120);
		
		assertEquals(90, actual);
	}
	
	@Test
	void test2() {
		int actual = helperUtility.getPointsFromPurchaseAmount(70);
		
		assertEquals(20, actual);
	}
	
	@Test
	void test3() {
		int actual = helperUtility.getPointsFromPurchaseAmount(30);
		
		assertEquals(0, actual);
	}

}
