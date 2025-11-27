package com.bmi_calculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")

public class BmiCalculatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(BmiCalculatorApplication.class, args);
	}
	@PostMapping("/handleData")
	public String postMethodName(@RequestBody UserData userData) //(@RequestBody UserData userData) => the first one "UserData" is the class.
	//the second one "userData", this is the object created by Spring to store the UserData passed from the frontend
	{
		double w = userData.getWeight();
		double h = userData.getHeight();
		double hm = h/100; //height in meters

		double bmi = w/(hm * hm);

		System.out.println("Height= " + h + " Weight= " + w);
		System.out.println("BMI: " + bmi);

		return String.valueOf(bmi);
	}

}
