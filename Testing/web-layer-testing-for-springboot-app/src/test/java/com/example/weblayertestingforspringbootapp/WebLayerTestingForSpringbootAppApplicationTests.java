package com.example.weblayertestingforspringbootapp;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.weblayertestingforspringbootapp.controller.HomeController;

@SpringBootTest
class WebLayerTestingForSpringbootAppApplicationTests {
	
	@Autowired
	private HomeController controller;

	@Test
	public void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}

}
