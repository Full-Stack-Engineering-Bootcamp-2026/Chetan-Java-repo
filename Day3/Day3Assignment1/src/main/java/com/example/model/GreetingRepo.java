package com.example.model;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;




@Getter
@Setter

@Repository

public class GreetingRepo {
	
	
	List<String> messages=new ArrayList<String>((List.of(
			new String("try try "),
			new String("dont give up")
			)));
	
	public List<String> msg(){
		System.out.println(messages);
		return messages;
	}
	
	
}
