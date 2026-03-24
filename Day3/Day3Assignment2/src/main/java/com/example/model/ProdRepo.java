package com.example.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

@Repository
public class ProdRepo {
	
	
	List<Product> products=new ArrayList<Product>((List.of(
			new Product(1,"kitkat",100,"abc"),
			new Product(2,"kitkat",100,"abc"),
			new Product(3,"kitkat",100,"abc"),
			new Product(4,"kitkat",100,"abc")
			)));
	
	public List<Product> findAllProducts(){
		return products;
	}
	
	
	public Optional<Product> findById(int id){
		return products.stream().filter(a -> a.getId()==id).findFirst();
	}
}
