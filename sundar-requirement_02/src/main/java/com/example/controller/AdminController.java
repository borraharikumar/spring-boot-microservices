package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.util.KeyUtil;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
    private KeyUtil keyUtil;

	// http://localhost:9000/admin/decode-key/
    @GetMapping("/decode-key/{key}")
    public ResponseEntity<String> decodeKey(@PathVariable String key) {
        String decodedData = keyUtil.decodeKey(key);
        return ResponseEntity.ok(decodedData);
    }

}
