package com.hk.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hk.rest.exception.TouristNotFoundException;
import com.hk.rest.model.Tourist;
import com.hk.rest.service.ITouristMgmtService;


@RestController
@RequestMapping("/tourist")
public class TouristController {
	
	@Autowired
	private ITouristMgmtService service;
	
	@PostMapping("/enroll")
	public ResponseEntity<Tourist> enrollTourist(@RequestBody Tourist tourist) {
			return new ResponseEntity<Tourist>(service.insertTourist(tourist), HttpStatus.CREATED);
	}
	
	@GetMapping("/fetch-all-tourists")
	public ResponseEntity<?> fetchAllTourists() {
			return new ResponseEntity<List<Tourist>>(service.selectAllTourists(), HttpStatus.CREATED);
	}
	
	@GetMapping("/fetch/{id}")
	public ResponseEntity<?> fetchTourist(@PathVariable Integer id) {
			return new ResponseEntity<Tourist>(service.selectTourist(id), HttpStatus.CREATED);
	}
	
	@GetMapping("/update")
	public ResponseEntity<?> updateTourist(@RequestBody Tourist tourist) throws TouristNotFoundException {
			return new ResponseEntity<Tourist>(service.updateTourist(tourist), HttpStatus.CONFLICT);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteTourist(@PathVariable Integer id) throws TouristNotFoundException {
			service.deleteTourist(id);
			return new ResponseEntity<String>("Tourist deleted with id '" + id +"'", HttpStatus.OK);
	}
	
	@PatchMapping("/update/{id}/{address}")
	public ResponseEntity<Tourist> updateTouristAddress(@PathVariable Integer id, @PathVariable String address) throws TouristNotFoundException {
			return new ResponseEntity<Tourist>(service.updateTouristAddress(id, address), HttpStatus.OK);
	}

}
