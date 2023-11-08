package com.example.assignment.rewards.api.controller;

import com.example.assignment.rewards.api.clients.SampleClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class GreetingController {

	private final SampleClient sampleClient;

	@RequestMapping("/greeting")
	public @ResponseBody String greeting() {
		sampleClient.post();
		return "done";
	}

}