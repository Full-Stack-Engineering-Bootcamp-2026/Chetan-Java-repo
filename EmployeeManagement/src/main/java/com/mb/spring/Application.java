package com.mb.spring;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.mb.spring.dto.EmployeeRequestDto;
import com.mb.spring.entity.Employee;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	 @Bean
	    public ModelMapper modelMapper() {

	        ModelMapper modelMapper = new ModelMapper();

	        modelMapper.typeMap(EmployeeRequestDto.class, Employee.class)
	                .addMappings(mapper -> mapper.skip(Employee::setId));

	        return modelMapper;
	    }

}
