package com.ts.api.sample;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleCtrl {
	@GetMapping(value = "/api/sample")
	String hello() {
		return "Hello! This is Sample.";
	}
}
