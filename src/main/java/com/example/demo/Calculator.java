package com.example.demo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//Controller  
@RestController
public class Calculator {

//using get method and hello-world as URI  
	@RequestMapping(method = RequestMethod.GET, path = "/add")
	public float addNumbers(String num1, String num2) {
		float answer = Integer.parseInt(num1) + Integer.parseInt(num2);

		return answer;
	}

	@RequestMapping(value = "/sub", method = RequestMethod.GET)
	public float subNumbers(String num1, String num2) {
		float answer = Integer.parseInt(num1) - Integer.parseInt(num2);

		return answer;
	}
	@RequestMapping(value = "/div", method = RequestMethod.GET)
	public float divNumbers(String	 num1, String num2) {
		float answer = Integer.parseInt(num1) / Integer.parseInt(num2);;

		return answer;
	}
	@RequestMapping(value = "/mul", method = RequestMethod.GET)
	public float mulNumbers(String num1, String num2) {
		float answer = Integer.parseInt(num1) * Integer.parseInt(num2);

		return answer;
	}
	@RequestMapping(value = "/time", method = RequestMethod.GET)
	public String getTime() {
		   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");  
		   LocalDateTime now = LocalDateTime.now();  
		  
		return dtf.format(now);
	}
}