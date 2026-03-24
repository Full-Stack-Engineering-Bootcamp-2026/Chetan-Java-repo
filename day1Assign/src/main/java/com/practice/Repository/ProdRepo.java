package com.practice.Repository;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.practice.model.Product;

import lombok.Getter;
import lombok.Setter;

@Repository
@Getter
@Setter
public class ProdRepo {
	
	

	 private List<Product> products=List.of(
			 new Product(1,"abc",100.00,"xyz"),
			 new Product(2,"def",200.00,"qwe")
			 );
	 
	 
	 
	
	
}
