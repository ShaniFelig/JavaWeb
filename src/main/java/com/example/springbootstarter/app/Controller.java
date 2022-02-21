package com.example.springbootstarter.app;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	
	@RequestMapping("/hello")
	public String sayHi() {
		return "Hi";
	}

}
