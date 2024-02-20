package com.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InMemoryRestController {

	@GetMapping("/about")
	public String aboutUs() {
		return "This is Sandya";
	}
	@GetMapping("/contact")
	public String contactUS() {
		return "92969404";

	}
	@GetMapping("welcome")
	public String welcome() {
		return "Welcome to My Channel!";

	}

}
