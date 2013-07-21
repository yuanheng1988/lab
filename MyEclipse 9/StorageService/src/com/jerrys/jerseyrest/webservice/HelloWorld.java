package com.jerrys.jerseyrest.webservice;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

//@Path("/hello")
public class HelloWorld{
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayHello(){
		return "hello jersey";
		}
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	public String sayHello2(){
		return "hello jersey2dsd";
		} 
	}