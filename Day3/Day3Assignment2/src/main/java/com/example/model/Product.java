package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Product {

	
	//id (int), name (String), price (double), category (String)
	
	public long id;
	public String name;
	public double price;
	public String category;
}
