package com.example.demo;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.base.Charsets;
import com.google.common.io.CharStreams;

//Controller  
@RestController
public class Calculator {

//using get method and hello-world as URI  
	@RequestMapping(method = RequestMethod.GET, path = "/add")
	public String addNumbers(String num1, String num2) throws IOException {
		float answer = Float.parseFloat(num1) + Float.parseFloat(num2);
		String time = getTime();
		String ipAdress = checkIP();
		return "Your answer is: "+  answer + "<br>and the time is: " + time + "<br>and your IP is: " + ipAdress + "<br><br><h1>You can run but you can't hide</h1>";
	} 

	@RequestMapping(value = "/sub", method = RequestMethod.GET)
	public String subNumbers(String num1, String num2) throws IOException {
		float answer = Float.parseFloat(num1) - Float.parseFloat(num2);
		String time = getTime();
		String ipAdress = checkIP();
		return "Your answer is: "+  answer + "<br>and the time is: " + time + "<br>and your IP is: " + ipAdress + "<br><br><h1>You can run but you can't hide</h1>";
	}
	@RequestMapping(value = "/div", method = RequestMethod.GET)
	
	public String divNumbers(String	 num1, String num2) throws IOException {
		float answer = Float.parseFloat(num1) / Float.parseFloat(num2);
		
		String time = getTime();
		String ipAdress = checkIP();				
		return "Your answer is: "+  answer + "<br>and the time is: " + time + "<br>and your IP is: " + ipAdress + "<br><br><h1>You can run but you can't hide</h1>";
	}
	
	@RequestMapping(value = "/mul", method = RequestMethod.GET)
	public String mulNumbers(String num1, String num2) throws IOException {
		float answer = Float.parseFloat(num1) * Float.parseFloat(num2);
		String time = getTime();
		String ipAdress = checkIP();
		return "Your answer is: "+  answer + "<br>and the time is: " + time + "<br>and your IP is: " + ipAdress + "<br><br><h1>You can run but you can't hide</h1>";
	}
	
	@RequestMapping(value = "/time", method = RequestMethod.GET)
	public String getTime() {
		   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm yyyy-MM-dd");  
		   LocalDateTime now = LocalDateTime.now();  
		  
		return dtf.format(now);
	}
	 
	@RequestMapping(value = "/id", method = RequestMethod.GET)
	public String getIP( HttpServletRequest requestContext){

	   String ipAdress = requestContext.getRemoteAddr();

	   return ipAdress;

	}
	public String checkIP()  throws IOException{
				URL url = new URL("http://localhost:8080/id");
				
				HttpURLConnection connection =
			    (HttpURLConnection) url.openConnection();
				connection.setRequestMethod("GET");
				InputStream ipURL = connection.getInputStream();
				String ipAdress = CharStreams.toString(new InputStreamReader(
					      ipURL, Charsets.UTF_8));
				connection.disconnect();
				return ipAdress;
	}
}