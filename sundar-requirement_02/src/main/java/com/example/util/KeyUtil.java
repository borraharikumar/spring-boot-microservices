package com.example.util;

import java.util.Base64;

import org.springframework.stereotype.Component;

import com.example.entity.Company;

@Component
public class KeyUtil {
	
	public String encodeCompanyDetails(Company company) {
        String data = company.getName() + "|" + company.getAddress() + "|" + company.getEmail();
        return Base64.getEncoder().encodeToString(data.getBytes());
    }

    public String decodeKey(String encodedKey) {
        byte[] decodedBytes = Base64.getDecoder().decode(encodedKey);
        return new String(decodedBytes);
    }

}
