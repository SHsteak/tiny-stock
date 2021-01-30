package com.ts.api.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloCTRL {
	@GetMapping(value = "/api/hello")
	String hello() {
		return "Hello Test!!";
	}
}
