package com.rest.service.controller;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.rest.service.model.HelloWorldBean;

@RestController
public class HelloWorldController {
	
	//internationalization
	private MessageSource message_source;
	
	//Constructor injection
	public HelloWorldController(MessageSource message_source) {
		this.message_source = message_source;
	}

	//@RequestMapping(method = RequestMethod.GET, path = "/hello-world")
	@GetMapping(path = "/hello-world")
	public String hello_world() {
		return "Hello world";
	}
	
	@GetMapping(path = "/hello-world-bean/{name}")
	public HelloWorldBean hello_world_bean(@PathVariable String name) {
		return new HelloWorldBean("Hello world, "  + name);
	}
	
	@GetMapping(path = "/hello-world-internationalized")
	public String hello_worldInternationalized() {
		Locale locale = LocaleContextHolder.getLocale();
		return message_source.getMessage("good.morning.message", null, "Default Message", locale );
		
	}
	

}
