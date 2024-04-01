package com.example.demo.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.model.Product;

@Controller
public class DataRenderingController {
	
	//Passing simple values from controller to view component
	@GetMapping("/simple-values")
	public String simpleValues(Map<String, Object> map) {
		System.err.println("DataRenderingController.simpleValues()");
		map.put("roll", "17X21A0302");
		map.put("name", "Harikumar Borra");
		map.put("department", "Mechanical Engineering");
		return "simple_values";
	}
	
	@GetMapping("/arrays-collection")
	public String arraysAndCollectionValues(Map<String, Object> map) {
		System.err.println("DataRenderingController.arraysAndCollectionValues()");
		map.put("name", "Harikumar Borra");
		map.put("favColors", new String[]{"Blue", "Red", "Green", "Black"});
		map.put("phoneNumbers", Set.of(9381815664L, 9493738178L, 8498979860L));
		map.put("qualifications", List.of("B.Tech", "Intermediate Education", "SSC"));
		map.put("identities", Map.of("aadhar", 713146183587L, "pan", "BJGPH0006M", "voterId", "WUT1416312"));
		return "arrays_collections";
	}
	
	@GetMapping("/model-data")
	public String modelData(Map<String, Object> map) {
		Product product = new Product(1000, "Motorora g42", "Mobiles", 11500D, 1);
		map.put("product", product);
		return "model";
	}
	
	@GetMapping("/collection-model")
	public String collectionOfModelObjects(Map<String, Object> map) {
		List<Product> products = List.of(new Product(1000, "Motorola g42", "Mobiles", 11500D, 2),
										 new Product(1001, "Mouse", "Computer Accessories", 600D, 5),
										 new Product(1101, "Sofa", "House holdings", 56000D, 2));
		map.put("products", products);
		return "model-collection";
	}

}
