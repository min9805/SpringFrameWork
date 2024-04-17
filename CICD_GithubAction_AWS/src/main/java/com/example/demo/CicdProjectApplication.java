package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class CicdProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(CicdProjectApplication.class, args);
	}

}

@RestController
class HelloWorldController {

	@GetMapping("/")
	public String hello() {
		return "Check the CI/CD pipeline in action With docker!!";
	}
}