package com.batch.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class BookItemProcessor implements ItemProcessor<String, String> {

	@Override
	public String process(String item) throws Exception {
		System.err.println("BookItemProcessor.process()");
		
		if(item.equalsIgnoreCase("Head First Java"))
			return item + " By Kathe Sierra & Bert Bates";
		if(item.equalsIgnoreCase("Java - A beginner guide"))
			return item + " By Herbert Schildt";
		if(item.equalsIgnoreCase("Java for Dummies"))
			return item + " By Barry A & Burd";
		if(item.equalsIgnoreCase("Effective java"))
			return item + " By Joshua Bloch";
		if(item.equalsIgnoreCase("Head first design patterns"))
			return item + " By Eric Freeman";
		if(item.equalsIgnoreCase("Java 8 in Action"))
			return item + " By Raoul-Gabriel Urma, Mario Fusco, and Alan Mycroft";
		if(item.equalsIgnoreCase("Core Java Volume 1-Fundamentals"))
			return item + " By S. Horstmann & Gary Cornell";
		if(item.equalsIgnoreCase("Java 9 for programmers"))
			return item + " By Paul Deitel and Harvey Deitel";
		if(item.equalsIgnoreCase("Head First Servlets and JSP"))
			return item + " By O'Reilly Media";
		else
			return item;
	}

}
