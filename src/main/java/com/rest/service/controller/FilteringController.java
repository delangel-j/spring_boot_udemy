package com.rest.service.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.rest.service.model.SomeBean;

@RestController
public class FilteringController {
	
	@GetMapping("/filtering")
	public MappingJacksonValue filtering() {
		SomeBean someBean = new SomeBean("value1", "Value2", "Value3");
		//Allows implement filters
		MappingJacksonValue mapping_jackson_value = new MappingJacksonValue(someBean);
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1" , "field3");
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		mapping_jackson_value.setFilters(filters);
		return mapping_jackson_value;
	}
	
	@GetMapping("/filtering_list")
	public MappingJacksonValue filtering_list() {
		List<SomeBean> asList = Arrays.asList(new SomeBean("value1", "Value2", "Value3"),
				new SomeBean("value4", "Value5", "Value6"));
		MappingJacksonValue mapping_jackson_value = new MappingJacksonValue(asList);
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field2" , "field3");
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		mapping_jackson_value.setFilters(filters);
		
		return mapping_jackson_value ;
	}

}
