package edu.mum.cs544.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestWebService {
	@GetMapping("helloWorld")
	public String hello(){
		return "Hello";
	}
}
