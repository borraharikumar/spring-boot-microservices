package com.hk.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hk.rest.model.Cricketer;
import com.hk.rest.service.ICricketerService;

@RestController
@RequestMapping("/cricketer")
public class CricketerOperationsController {

	@Autowired
	private ICricketerService service;

	@PostMapping("/enroll")
	public ResponseEntity<Cricketer> enrollCricketer(@RequestBody Cricketer cricketer){
		return new ResponseEntity<Cricketer>(service.insertCricketer(cricketer), HttpStatus.CREATED);
	}

	@PostMapping("/update")
	public ResponseEntity<Cricketer> updateCricketer(@RequestBody Cricketer cricketer) throws Exception {
		return new ResponseEntity<Cricketer>(service.updateCricketer(cricketer), HttpStatus.CREATED);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteCricketer(@PathVariable Integer id) throws Exception {
		service.deleteCricketer(id);
		return new ResponseEntity<String>("Cricketer with id '" + id + "' deleted successfully", HttpStatus.CREATED);
	}

	@GetMapping("/find/{id}")
	public ResponseEntity<Cricketer> getCricketer(@PathVariable Integer id) throws Exception {
		return new ResponseEntity<Cricketer>(service.getCricketer(id), HttpStatus.CREATED);
	}

}
