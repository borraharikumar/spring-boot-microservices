package com.batch.reader;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.stereotype.Component;

@Component
public class BookItemReader implements ItemReader<String> {
	
	private String books[] = new String[] {"Head First Java", "Java - A beginner guide", "Java for Dummies", "Effective java", "Head first design patterns", "Core Java Volume 1-Fundamentals", "Java 9 for programmers", "Java 8 in Action", "Head First Servlets and JSP"};

	private int i = 0;
	
	@Override
	public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		System.err.println("BookItemReader.read()");
		
		if(i<books.length)
			return books[i++];
		else
			return null;
	}

}
